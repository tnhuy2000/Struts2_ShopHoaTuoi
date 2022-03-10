package DAO;
import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Model.Hoa;
import Model.User;
public class UserDAO {
	public User login(String email, String matkhau)
	{
		User nd=null;
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			
			statement = db.getConn().prepareStatement("SELECT * from NGUOIDUNG WHERE email = ? AND matkhau=?");
			
			
			statement.setString(1, email);
			statement.setString(2, MD5.getMd5(matkhau) );
			
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{ 
				while(rs.next())
				{
					nd=new User(rs.getInt("id"),
					rs.getString("email"),rs.getString("hoten"), rs.getString("sodienthoai"),rs.getInt("trangthai"),rs.getString("loaiquyen"));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nd;
	}
	public User kiemtratontaiemail(String email)
	{
		User nd=null;
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			
			statement = db.getConn().prepareStatement("SELECT * from NGUOIDUNG WHERE email = ?");
			
			
			statement.setString(1, email);
			
			
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{ 
				while(rs.next())
				{
					nd=new User(rs.getInt("id"),
					rs.getString("email"),rs.getString("hoten"), rs.getString("sodienthoai"),rs.getInt("trangthai"),rs.getString("loaiquyen"));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nd;
		
	}
	public List<User> getList(){
		List<User> list=new ArrayList<User>();
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT *	from NGUOIDUNG");
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					list.add( new User(rs.getInt("id"),
							rs.getString("email"),
							rs.getString("hoten"),
							rs.getString("sodienthoai"),
							rs.getInt("trangthai"),
							rs.getString("loaiquyen")));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void doimatkhau(int id, String matkhaumoi) {
		// TODO Auto-generated method stub
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("UPDATE NGUOIDUNG SET matkhau=? where id=?");
			statement.setString(1, MD5.MaHoa(matkhaumoi));
			statement.setInt(2, id);	
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void capnhathoso(int id, String hoten, String sodienthoai, String email) {
		// TODO Auto-generated method stub
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("UPDATE NGUOIDUNG SET hoten=? , sodienthoai=?, email=? where id=?");
			statement.setString(1, hoten);
			statement.setString(2, sodienthoai);
			statement.setString(3, email);
			statement.setInt(4, id);	
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void quenmatkhau(String email) throws MessagingException, UnsupportedEncodingException {

        final String fromEmail = "nutycosmestic@gmail.com";
        // Mat khau email cua ban
        final String password = "Nutyshop123";
        // dia chi email nguoi nhan
        final String toEmail = email;

        final String subject = "Quên mật khẩu";
        final String matkhaumoi=rand(0,999999)+"";
        
        final String body = "Bạn nhận được thư này, do bạn hoặc ai đó yêu cầu đổi mật khẩu.\n"
        		+ "Mật khẩu của bạn là: "+ matkhaumoi;

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);


        MimeMessage msg = new MimeMessage(session);
        //set message headers
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");

        msg.setFrom(new InternetAddress(fromEmail, "ShopHoaTuoi"));

        msg.setReplyTo(InternetAddress.parse(fromEmail, false));

        msg.setSubject(subject, "UTF-8");

        msg.setText(body, "UTF-8");

        msg.setSentDate(new Date());

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        Transport.send(msg);
        System.out.println("Gui mail thanh cong");
      
		// TODO Auto-generated method stub
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("UPDATE NGUOIDUNG SET matkhau=? where email=?");
			statement.setString(1, MD5.MaHoa(matkhaumoi) );	
			statement.setString(2, email);
			
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

	private int rand(int i, int j) {
		// TODO Auto-generated method stub
	Random rd = new Random();
	int number = rd.nextInt(999999); 
	return number;
	}
	public User getUserByID(int id)
	{
		User user=null;
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT * from NGUOIDUNG WHERE id = ? ");
			statement.setInt(1, id);
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					user=new User(rs.getInt("id"),
							rs.getString("email"),
							rs.getString("hoten"),
							rs.getString("sodienthoai"),
							rs.getInt("trangthai"),
							rs.getString("loaiquyen"));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return user;
	}
	
	public void store(String email, String hoten,String sodienthoai,String matkhau)
	{
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("INSERT INTO	NGUOIDUNG(email,hoten,sodienthoai,matkhau) values(?,?,?,?)");
			statement.setString(1, email);
			statement.setString(2, hoten);
			statement.setString(3, sodienthoai);
			statement.setString(4, MD5.MaHoa(matkhau));
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void storeUser(String email, String hoten,String sodienthoai,String loaiquyen)
	{
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("INSERT INTO	NGUOIDUNG(email,hoten,sodienthoai, matkhau, loaiquyen) values(?,?,?,?,?)");
			statement.setString(1, email);
			statement.setString(2, hoten);
			statement.setString(3, sodienthoai);
			statement.setString(4, MD5.MaHoa(sodienthoai));
			statement.setString(5, loaiquyen);
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(int id,String loaiquyen) {
		// TODO Auto-generated method stub
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("UPDATE NGUOIDUNG SET loaiquyen=? where id=?");
			statement.setString(1, loaiquyen);
			statement.setInt(2, id);	
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("DELETE FROM NGUOIDUNG  where id=?");
			statement.setInt(1, id);	
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateTrangThai(int id,int trangthai) {
		// TODO Auto-generated method stub
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("UPDATE NGUOIDUNG SET trangthai=? where id=?");
			statement.setInt(1, trangthai);
			statement.setInt(2, id);	
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
