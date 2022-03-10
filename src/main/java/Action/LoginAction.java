package Action;
import javax.mail.*;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
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

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import DAO.HoaDAO;
import DAO.UserDAO;
import Model.User;


public class LoginAction extends ActionSupport implements SessionAware {

	
	private Map<String, Object> session;
	private String matkhau;
	private String email;
	private String hoten;
	private String sodienthoai;
	
	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	
	public String login() {    
    	User nd=new UserDAO().login(email, matkhau);
    	if(nd!=null)
		{
    		if(nd.getTrangthai()==1)
    		{
    			session.put("nguoidung", nd);
        		System.out.println("Login success");
        		if(nd.getLoaiquyen().equals("ADMIN"))
    			{
        			return "admin";
    			}
        		else
        			return "khach";
    		}
    		else
    		{
    			addActionMessage("Tài khoản của bạn đã bị khoá");
                System.out.println("Login fail");
                return "login";
    		}
    		    			
                		
		}
    	else
    	{
    		 addActionMessage("Bạn nhập sai email hoặc mật khẩu");
             System.out.println("Login fail");
             return "login";
    	}
    }
	
	public String logOut() {
        System.out.println("LogOut");
        session.remove("nguoidung");        
        return SUCCESS;
    }
	public String NewPassWord() throws UnsupportedEncodingException, MessagingException {
		System.out.println("quenmatkhau");
		User nd=new UserDAO().kiemtratontaiemail(email);
    	if(nd!=null)
		{
    		
    		new UserDAO().quenmatkhau(email);
			addActionMessage("Cấp lại mật khẩu thành công. Vui lòng kiểm tra email để lấy mật khẩu mới!");
			System.out.println("Doi mat khau thanh cong!");
			return "login";			
                		
		}
    	else
    	{
    		addActionMessage("Email không tồn tại trong hệ thống!");
			System.out.println("Doi mat khau that bai!");
			return SUCCESS;
    	}
		
	}
	public String DangKyUser() {
        System.out.println("Store khach");
        User nd=new UserDAO().kiemtratontaiemail(email);
    	if(nd==null)
		{
    		UserDAO userDAO=new UserDAO();
            userDAO.store(email, hoten, sodienthoai, matkhau);          
            addActionMessage("Đăng ký thành công!");	
            System.out.println("Dang ky thanh cong!");
            return "login";		
                		
		}
    	else
    	{
    		addActionMessage("Email đã tồn tại trong hệ thống! Vui lòng nhập email khác");
			System.out.println("Dang ky that bai!");
			return SUCCESS;
    	}
        
    }
		
}