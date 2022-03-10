package Action.Admin;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import DAO.DanhMucDAO;
import DAO.HoaDAO;
import DAO.UserDAO;
import Model.User;

public class AdminAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = -4813671982160371972L;
	private String hoten;
	private String sodienthoai;
	private String email;
	private String matkhaumoi;
	private Map<String, Object> session;
	
	public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }

	public String getHoten() {
		return hoten;
	}


	public String getMatkhaumoi() {
		return matkhaumoi;
	}

	public void setMatkhaumoi(String matkhaumoi) {
		this.matkhaumoi = matkhaumoi;
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


	public String home()
	{
		
		System.out.println("Welcome Admin home");
		User nd = (User) session.get("nguoidung");   
		//lấy thông tin ng dùng
		hoten=nd.getHoten();
		sodienthoai=nd.getSodienthoai();
		email=nd.getEmail();

		return "success";
	}
	public String doimatkhauAdmin() {
		System.out.println("Đổi mật khẩu");
		User nd = (User) session.get("nguoidung");       
	
		UserDAO userDAO=new UserDAO();
		
		userDAO.doimatkhau(nd.getId(), matkhaumoi);
		//lấy thông tin ng dùng
		hoten=nd.getHoten();
		sodienthoai=nd.getSodienthoai();
		email=nd.getEmail();
		addActionMessage("Đổi mật khẩu thành công!");	
		return "success";
		
	}
	public String capnhathosoAdmin() {
		User nd = (User) session.get("nguoidung");       
		hoten=nd.getHoten();
		sodienthoai=nd.getSodienthoai();
		email=nd.getEmail();
		UserDAO userDAO=new UserDAO();
		
		userDAO.capnhathoso(nd.getId(), hoten, sodienthoai,email);
		addActionMessage("Cập nhật hồ sơ thành công!");	
		
		return "success";
		
	}
}
