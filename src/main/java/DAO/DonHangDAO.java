package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.DatHoa;
import Model.Hoa;

public class DonHangDAO {
	public List<DatHoa> getListDatHoaTheoIdNguoiDung(int idnguoidung){
		List<DatHoa> list=new ArrayList<DatHoa>();
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT dh.*, ht.tenhoa,ht.hinhanh, nd.hoten,nd.sodienthoai from DATHOA dh, HOATUOI ht, NGUOIDUNG nd WHERE dh.idhoatuoi=ht.id and dh.idnguoidung=? and dh.idnguoidung=nd.id");
			statement.setInt(1, idnguoidung);
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					list.add( new DatHoa(rs.getInt("dh.id"),
							rs.getInt("dh.idnguoidung"),
							rs.getString("nd.hoten"),
							rs.getString("nd.sodienthoai"),
							rs.getInt("dh.idhoatuoi"),
							rs.getString("ht.tenhoa"),
							rs.getString("ht.hinhanh"),
							rs.getInt("dh.soluong"),
							rs.getInt("dh.gia"),
							rs.getInt("dh.thanhtien"),
							rs.getString("dh.ngaydat"),
							rs.getString("dh.ngaygiaohang"),
							rs.getString("dh.nguoinhan"),
							rs.getString("dh.diachi"),
							rs.getString("dh.tggiaohang"),
							rs.getString("dh.loinhan"),
							rs.getString("dh.ghichu"),
							rs.getInt("dh.trangthai")));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public DatHoa getDonHangByID(int id)
	{
		DatHoa dathoa=null;
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT dh.*, ht.tenhoa,ht.hinhanh,nd.hoten,nd.sodienthoai from DATHOA dh, HOATUOI ht,NGUOIDUNG nd WHERE dh.idhoatuoi=ht.id and dh.idnguoidung=nd.id and dh.id=?");
			statement.setInt(1, id);
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					dathoa=new DatHoa(rs.getInt("id"),
							rs.getInt("dh.idnguoidung"),
							rs.getString("nd.hoten"),
							rs.getString("nd.sodienthoai"),
							rs.getInt("dh.idhoatuoi"),
							rs.getString("ht.tenhoa"),
							rs.getString("ht.hinhanh"),
							rs.getInt("dh.soluong"),
							rs.getInt("dh.gia"),
							rs.getInt("dh.thanhtien"),
							rs.getString("dh.ngaydat"),
							rs.getString("dh.ngaygiaohang"),
							rs.getString("dh.nguoinhan"),
							rs.getString("dh.diachi"),
							rs.getString("dh.tggiaohang"),
							rs.getString("dh.loinhan"),
							rs.getString("dh.ghichu"),
							rs.getInt("dh.trangthai"));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return dathoa;
	}
	public List<DatHoa> getList(){
		List<DatHoa> list=new ArrayList<DatHoa>();
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT dh.*, ht.tenhoa,ht.hinhanh, nd.hoten,nd.sodienthoai from DATHOA dh, HOATUOI ht, NGUOIDUNG nd WHERE dh.idhoatuoi=ht.id and dh.idnguoidung=nd.id");
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					list.add( new DatHoa(rs.getInt("dh.id"),
							rs.getInt("dh.idnguoidung"),
							rs.getString("nd.hoten"),
							rs.getString("nd.sodienthoai"),
							rs.getInt("dh.idhoatuoi"),
							rs.getString("ht.tenhoa"),
							rs.getString("ht.hinhanh"),
							rs.getInt("dh.soluong"),
							rs.getInt("dh.gia"),
							rs.getInt("dh.thanhtien"),
							rs.getString("dh.ngaydat"),
							rs.getString("dh.ngaygiaohang"),
							rs.getString("dh.nguoinhan"),
							rs.getString("dh.diachi"),
							rs.getString("dh.tggiaohang"),
							rs.getString("dh.loinhan"),
							rs.getString("dh.ghichu"),
							rs.getInt("dh.trangthai")));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void update(int iddathoa, String ngaygiaohang,String tggiaohang, String nguoinhan, String diachi, 
			String loinhan, String ghichu, int trangthai) {
		// TODO Auto-generated method stub
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("UPDATE DATHOA SET ngaygiaohang=?, tggiaohang=?, nguoinhan=?,diachi=? ,loinhan=?, ghichu=?, trangthai=? where id=?");
			statement.setString(1, ngaygiaohang);
			statement.setString(2, tggiaohang);
			statement.setString(3, nguoinhan);
			statement.setString(4, diachi);
			statement.setString(5, loinhan);
			statement.setString(6, ghichu);
			statement.setInt(7, trangthai);
			statement.setInt(8, iddathoa);	
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
			statement = db.getConn().prepareStatement("DELETE FROM DATHOA  where id=?");
			statement.setInt(1, id);	
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
