package Action.Admin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import DAO.DanhMucDAO;

import Model.DanhMuc;

import Model.User;

public class DanhMucAction extends ActionSupport implements SessionAware{
	private List<DanhMuc> danhmuclist;
	
	private DanhMuc danhmuc;
	private String tendanhmuc;
	private String message;
	private int iddanhmuc;
	
	private String hoten;
	private String sodienthoai;
	private String email;
	
	
	private Map<String, Object> session;
	
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

	

	public List<DanhMuc> getDanhmuclist() {
		return danhmuclist;
	}

	public void setDanhmuclist(List<DanhMuc> danhmuclist) {
		this.danhmuclist = danhmuclist;
	}

	public DanhMuc getDanhmuc() {
		return danhmuc;
	}

	public void setDanhmuc(DanhMuc danhmuc) {
		this.danhmuc = danhmuc;
	}

	public String getTendanhmuc() {
		return tendanhmuc;
	}

	public void setTendanhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getIddanhmuc() {
		return iddanhmuc;
	}

	public void setIddanhmuc(int iddanhmuc) {
		this.iddanhmuc = iddanhmuc;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String create() {
        System.out.println("Create Danh Muc"); 
        User nd = (User) session.get("nguoidung");   
		//lấy thông tin ng dùng
		hoten=nd.getHoten();
		sodienthoai=nd.getSodienthoai();
		email=nd.getEmail();
        danhmuclist=new DanhMucDAO().getList();
        return SUCCESS;
	}
	
	public String store() {
        System.out.println("Store Danh Muc");
        DanhMucDAO danhmucDAO=new DanhMucDAO();
        danhmucDAO.store(tendanhmuc);
        
      
        addActionMessage("Thêm thành công!");		
        //hoalist=HoaDAO.getList();
        return "list";
	}
	
	public String edit() {
        System.out.println("Edit Hoa");
        User nd = (User) session.get("nguoidung");  
      //lấy thông tin ng dùng
  		hoten=nd.getHoten();
  		sodienthoai=nd.getSodienthoai();
  		email=nd.getEmail();
        danhmuc=new DanhMucDAO().getDanhMucByID(iddanhmuc);
        danhmuclist=new DanhMucDAO().getList();
        return SUCCESS;
	}
	
	public String update() {
        System.out.println("Update Danh Muc");
        DanhMucDAO danhmucDAO=new DanhMucDAO();
        
		
		danhmucDAO.update(iddanhmuc,tendanhmuc);
        
        message="Cập nhật thành công";
        //Hoalist=HoaDAO.getList();
        return "list";
	}
	
	public String delete() {
        System.out.println("Delete Danh Muc");
        try {
	        DanhMucDAO danhmucDAO=new DanhMucDAO();
	        danhmucDAO.delete(iddanhmuc);
	        message="Xóa thành công";
	        danhmuclist=danhmucDAO.getList();
	        return "list";  
        }
        catch(Exception e) {
        	
			System.out.println("Xoa that bai!");
			return "error";
        }
	}
	
	public String list() {
        System.out.println("Danh muc list");
        danhmuclist=new DanhMucDAO().getList();	
        User nd = (User) session.get("nguoidung");   
		//lấy thông tin ng dùng
		hoten=nd.getHoten();
		sodienthoai=nd.getSodienthoai();
		email=nd.getEmail();
        return SUCCESS;
    }
	
}
