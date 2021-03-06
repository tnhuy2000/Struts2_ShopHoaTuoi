package Action.Admin;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


import DAO.UserDAO;
import Model.User;

public class UserAction extends ActionSupport implements SessionAware{
	
	private List<User> userlist;
	
	private User user;
	
	private String message;
	private int id;
	private String hoten;
	private String sodienthoai;
	private String email;
	private String matkhaumoi;
	private int trangthai;
	private String loaiquyen;
	
	private Map<String, Object> session;


	
	public String getLoaiquyen() {
		return loaiquyen;
	}

	public void setLoaiquyen(String loaiquyen) {
		this.loaiquyen = loaiquyen;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getMatkhaumoi() {
		return matkhaumoi;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public void setMatkhaumoi(String matkhaumoi) {
		this.matkhaumoi = matkhaumoi;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String create() {
        System.out.println("Create User"); 
        User nd = (User) session.get("nguoidung");   
		//l???y th??ng tin ng d??ng
		hoten=nd.getHoten();
		sodienthoai=nd.getSodienthoai();
		email=nd.getEmail();
        userlist=new UserDAO().getList();
        return SUCCESS;
	}
	
	public String store() {
        System.out.println("Store User");
        User nd=new UserDAO().kiemtratontaiemail(email);
    	if(nd==null)
		{
		        UserDAO userDAO=new UserDAO();
		        userDAO.storeUser(email,  hoten, sodienthoai, loaiquyen);
		        addActionMessage("Th??m th??nh c??ng!");		
		        //hoalist=HoaDAO.getList();
		        return "list";
		}
    	else
    	{
    		addActionMessage("Email ???? t???n t???i trong h??? th???ng! Vui l??ng nh???p email kh??c");
			System.out.println("Them nguoi dung that bai!");
			return "error";
    	}
	}
	
	public String edit() {
        System.out.println("Edit User");
        User nd = (User) session.get("nguoidung");  
      //l???y th??ng tin ng d??ng
  		hoten=nd.getHoten();
  		sodienthoai=nd.getSodienthoai();
  		email=nd.getEmail();
        user=new UserDAO().getUserByID(id);
        userlist=new UserDAO().getList();
        return SUCCESS;
	}
	
	public String update() {
        System.out.println("Update User");
        UserDAO userDAO=new UserDAO();
        
        User nd = (User) session.get("nguoidung");   
		//l???y th??ng tin ng d??ng
		hoten=nd.getHoten();
		sodienthoai=nd.getSodienthoai();
		email=nd.getEmail();
        userDAO.update(id,loaiquyen);
        
        message="C???p nh???t th??nh c??ng";
        //Hoalist=HoaDAO.getList();
        return "list";
	}
	
	public String delete() {
        System.out.println("Delete User");
        
        	UserDAO userDAO=new UserDAO();
            userDAO.delete(id);
            message="X??a th??nh c??ng";
            userlist=userDAO.getList();
            return "list";
        
        
            
	}
	
	public String list() {
        System.out.println("User list");
        userlist=new UserDAO().getList();		
        User nd = (User) session.get("nguoidung");   
		//l???y th??ng tin ng d??ng
		hoten=nd.getHoten();
		sodienthoai=nd.getSodienthoai();
		email=nd.getEmail();
        return SUCCESS;
    }
	public String trangthai() {
        System.out.println("Update trang thai User");
        UserDAO userDAO=new UserDAO();
        
        userDAO.updateTrangThai(id,trangthai);
        
        message="C???p nh???t tr???ng th??i th??nh c??ng";
        //Hoalist=HoaDAO.getList();
        return "list";
	}
}
