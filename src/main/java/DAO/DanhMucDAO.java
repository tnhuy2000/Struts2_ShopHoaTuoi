package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.DanhMuc;

import Model.User;
public class DanhMucDAO {
	public List<DanhMuc> getList(){
		List<DanhMuc> list=new ArrayList<DanhMuc>();
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT *	from DANHMUC");
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					list.add( new DanhMuc(rs.getInt("id"),
					rs.getString("tendanhmuc")
					));
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public DanhMuc getDanhMucByID(int id)
	{
		DanhMuc danhmuc=null;
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT * from DANHMUC WHERE id = ? ");
			statement.setInt(1, id);
			ResultSet rs=db.executeQuery(statement);
			if(rs!=null)
			{
				while(rs.next())
				{
					danhmuc=new DanhMuc(rs.getInt("id"),
							rs.getString("tendanhmuc")
							);
				}
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return danhmuc;
	}
	
	
	
	public void store(String ten)
	{
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("INSERT INTO	DANHMUC(tendanhmuc) values(?)");
			statement.setString(1, ten);			
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(int id, String tendanhmuc) {
		// TODO Auto-generated method stub
		DBService db=new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("UPDATE DANHMUC SET tendanhmuc=? where id=?");
			statement.setString(1, tendanhmuc);
			
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
			statement = db.getConn().prepareStatement("DELETE FROM DANHMUC  where id=?");
			statement.setInt(1, id);	
			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}