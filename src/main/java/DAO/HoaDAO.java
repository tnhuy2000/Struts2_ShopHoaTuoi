package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import Model.Hoa;
import Model.User;
public class HoaDAO {
	public List<Hoa> getList(){
		List<Hoa> list=new ArrayList<Hoa>();
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT *	from HOATUOI");
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					list.add( new Hoa(rs.getInt("id"),
							rs.getString("tenhoa"),
							rs.getString("hinhanh"),
							rs.getString("mota"),
							rs.getInt("gia"),
							rs.getInt("luotxem"),
							rs.getInt("luotmua"),
							rs.getInt("iddanhmuc")));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Hoa> getListHoaTheoIdDanhMuc(int iddanhmuc){
		List<Hoa> list=new ArrayList<Hoa>();
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT *	from HOATUOI WHERE iddanhmuc=?");
			statement.setInt(1, iddanhmuc);
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					list.add( new Hoa(rs.getInt("id"),
					rs.getString("tenhoa"),
					rs.getString("hinhanh"),
					rs.getString("mota"),
					rs.getInt("gia"),
					rs.getInt("luotxem"),
					rs.getInt("luotmua"),
					rs.getInt("iddanhmuc")));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Hoa> timkiemhoatheoten(String tukhoa){
		List<Hoa> list=new ArrayList<Hoa>();
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT *	from HOATUOI WHERE tenhoa like ?");
			statement.setString(1, "%"+tukhoa+"%");
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					list.add( new Hoa(rs.getInt("id"),
					rs.getString("tenhoa"),
					rs.getString("hinhanh"),
					rs.getString("mota"),
					rs.getInt("gia"),
					rs.getInt("luotxem"),
					rs.getInt("luotmua"),
					rs.getInt("iddanhmuc")));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Hoa getHoaByID(int id)
	{
		Hoa hoa=null;
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT * from HOATUOI WHERE id = ? ");
			statement.setInt(1, id);
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					hoa=new Hoa(rs.getInt("id"),
							rs.getString("tenhoa"),
							rs.getString("hinhanh"),
							rs.getString("mota"),
							rs.getInt("gia"),
							rs.getInt("luotxem"),
							rs.getInt("luotmua"),
							rs.getInt("iddanhmuc"));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return hoa;
	}
	
	public void TangLuotXem(int id)
	{
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("UPDATE HOATUOI SET luotxem=luotxem+1 WHERE id=?");
			statement.setInt(1, id);
			db.executeUpdate(statement);
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	public void TangLuotMua(int id)
	{
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("UPDATE HOATUOI SET luotmua=luotmua+1 WHERE id=?");
			statement.setInt(1, id);
			db.executeUpdate(statement);
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	public void Order(int idnguoidung,int idhoatuoi, int soluong, int gia, int thanhtien, String ngaygiaohang, String nguoinhan, String diachi, String tggiaohang, String loinhan, String ghichu)
	{
        
        
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("INSERT INTO	DATHOA(idnguoidung,idhoatuoi,soluong,gia,thanhtien, ngaygiaohang, nguoinhan, diachi, tggiaohang, loinhan, ghichu) values(?,?,?,?,?,?,?,?,?,?,?)");
			statement.setInt(1, idnguoidung);
			statement.setInt(2, idhoatuoi);
			statement.setInt(3, soluong);
			statement.setInt(4, gia);
			statement.setInt(5, thanhtien);
			statement.setString(6, ngaygiaohang);
			statement.setString(7, nguoinhan);
			statement.setString(8, diachi);
			statement.setString(9, tggiaohang);
			statement.setString(10, loinhan);
			statement.setString(11, ghichu);
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void store(String ten, String hinh,String mota,int gia,int luotxem,int luotmua,int iddanhmuc)
	{
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("INSERT INTO	HOATUOI(tenhoa,hinhanh,mota,gia,luotxem,luotmua,iddanhmuc) values(?,?,?,?,?,?,?)");
			statement.setString(1, ten);
			statement.setString(2, hinh);
			statement.setString(3, mota);
			statement.setInt(4, gia);
			statement.setInt(5, luotxem);
			statement.setInt(6, luotmua);
			statement.setInt(7, iddanhmuc);
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(int id, String tenhoa, String hinh,String mota, int gia,int luotxem,int luotmua,int iddanhmuc) {
		// TODO Auto-generated method stub
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("UPDATE HOATUOI SET tenhoa=?, hinhanh=?,mota=?, gia=? ,luotxem=?, luotmua=?, iddanhmuc=? where id=?");
			statement.setString(1, tenhoa);
			statement.setString(2, hinh);
			statement.setString(3, mota);
			statement.setInt(4, gia);
			statement.setInt(5, luotxem);
			statement.setInt(6, luotmua);
			statement.setInt(7, iddanhmuc);
			statement.setInt(8, id);	
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
			statement = db.getConn().prepareStatement("DELETE FROM HOATUOI  where id=?");
			statement.setInt(1, id);	
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}