package Action.Khach;


import java.io.UnsupportedEncodingException;

import java.util.Properties;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import DAO.DanhMucDAO;

import DAO.DonHangDAO;
import DAO.HoaDAO;
import DAO.UserDAO;
import Model.DanhMuc;
import Model.DatHoa;
import Model.Hoa;
import Model.User;

public class KhachAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = -4813671982160371972L;
	
	private List<Hoa> hoalist;
	private List<DanhMuc> danhmuclist;
	private List<DatHoa> dathoalist;
	
	private Hoa hoa;
	private int idhoatuoi;
	private int soluong;
	private int gia;
	private int thanhtien;
	private int luotxem;
	private int luotmua;
	
	private String tukhoa;
	
	private String hoten;
	private String sodienthoai;
	private String email;
	
	private String ngaygiaohang;
	private String nguoinhan;
	private String matkhaumoi;
	
	private String diachi;
	private String tggiaohang;
	private String loinhan;
	private String ghichu;
	private Map<String, Object> session;
	
	
	private DanhMuc danhmuc;
	private int iddanhmuc;
	
	private DatHoa dathoa;
	private int iddathoa;
	
	
	public void setDathoa(DatHoa dathoa) {
		this.dathoa = dathoa;
	}

	public String getTukhoa() {
		return tukhoa;
	}

	public void setTukhoa(String tukhoa) {
		this.tukhoa = tukhoa;
	}

	public DatHoa getDathoa() {
		return dathoa;
	}

	public List<DatHoa> getDathoalist() {
		return dathoalist;
	}

	public void setDathoalist(List<DatHoa> dathoalist) {
		this.dathoalist = dathoalist;
	}

	public int getIddathoa() {
		return iddathoa;
	}

	public void setIddathoa(int iddathoa) {
		this.iddathoa = iddathoa;
	}

	public DanhMuc getDanhmuc() {
		return danhmuc;
	}

	public void setDanhmuc(DanhMuc danhmuc) {
		this.danhmuc = danhmuc;
	}

	public int getIddanhmuc() {
		return iddanhmuc;
	}

	public void setIddanhmuc(int iddanhmuc) {
		this.iddanhmuc = iddanhmuc;
	}

	public String getMatkhaumoi() {
		return matkhaumoi;
	}

	public void setMatkhaumoi(String matkhaumoi) {
		this.matkhaumoi = matkhaumoi;
	}

	public String getNgaygiaohang() {
		return ngaygiaohang;
	}

	public void setNgaygiaohang(String ngaygiaohang) {
		this.ngaygiaohang = ngaygiaohang;
	}

	public String getNguoinhan() {
		return nguoinhan;
	}

	public void setNguoinhan(String nguoinhan) {
		this.nguoinhan = nguoinhan;
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

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getTggiaohang() {
		return tggiaohang;
	}

	public void setTggiaohang(String tggiaohang) {
		this.tggiaohang = tggiaohang;
	}

	public String getLoinhan() {
		return loinhan;
	}

	public void setLoinhan(String loinhan) {
		this.loinhan = loinhan;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public int getLuotxem() {
		return luotxem;
	}

	public void setLuotxem(int luotxem) {
		this.luotxem = luotxem;
	}

	public int getLuotmua() {
		return luotmua;
	}

	public void setLuotmua(int luotmua) {
		this.luotmua = luotmua;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public int getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}

	public Map<String, Object> getSession() {
		return session;
	}	

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	
	public Hoa getHoa() {
		hoa=new HoaDAO().getHoaByID(idhoatuoi);
		return hoa;
	}

	
	public void setHoa(Hoa hoa) {
		this.hoa = hoa;
	}

	public int getIdhoatuoi() {
		return idhoatuoi;
	}

	public void setIdhoatuoi(int idhoatuoi) {
		this.idhoatuoi = idhoatuoi;
	}

	public void setHoalist(List<Hoa> hoalist) {
		this.hoalist = hoalist;
	}

	public List<Hoa> getHoalist() {
		return hoalist;
	}



	public List<DanhMuc> getDanhmuclist() {
		return danhmuclist;
	}

	public void setDanhmuclist(List<DanhMuc> danhmuclist) {
		this.danhmuclist = danhmuclist;
	}

	public String home()
	{
		
		System.out.println("Welcome KHACH home");
		User nd = (User) session.get("nguoidung");   
		//lấy thông tin ng dùng
		hoten=nd.getHoten();
		sodienthoai=nd.getSodienthoai();
		email=nd.getEmail();
		//lấy danh sách hoa
		hoalist=new HoaDAO().getList();
		//lấy danh mục
		danhmuclist=new DanhMucDAO().getList();
		
		return "success";
	}
	

	public String order() {
        System.out.println("Order"); 
        System.out.println("Tang luot xem!");
      //lấy thông tin ng dùng
        User nd = (User) session.get("nguoidung");
        hoten=nd.getHoten(); 		
  		sodienthoai=nd.getSodienthoai();
  		email=nd.getEmail();
              
        danhmuc=new DanhMucDAO().getDanhMucByID(iddanhmuc);
        danhmuclist=new DanhMucDAO().getList();
        new HoaDAO().TangLuotXem(idhoatuoi); 
        return "success";
    }
	public String groupdanhmuc() {
        System.out.println("Groupdanhmuc"); 
        User nd = (User) session.get("nguoidung");    
        //lấy thông tin ng dùng
        hoten=nd.getHoten(); 		
  		sodienthoai=nd.getSodienthoai();
  		email=nd.getEmail();
        danhmuc=new DanhMucDAO().getDanhMucByID(iddanhmuc);
        danhmuclist=new DanhMucDAO().getList();
        
        hoalist=new HoaDAO().getListHoaTheoIdDanhMuc(iddanhmuc);
        return "success";
    }
	public String TimKiem() {
        System.out.println("Tim kiem"); 
        User nd = (User) session.get("nguoidung");    
        //lấy thông tin ng dùng
        hoten=nd.getHoten(); 		
  		sodienthoai=nd.getSodienthoai();
  		email=nd.getEmail();
  		
        danhmuc=new DanhMucDAO().getDanhMucByID(iddanhmuc);
        danhmuclist=new DanhMucDAO().getList();
        
        hoalist=new HoaDAO().timkiemhoatheoten(tukhoa);
       
    	addActionMessage("Kết quả cho từ khoá `"+tukhoa+"`");		
    	return "success";
        
       
    }
	
	public String submitorder() {
        System.out.println("Submit Order");

        User nd = (User) session.get("nguoidung");       
		
		new HoaDAO().Order(nd.getId(),
		idhoatuoi,
		soluong,
		gia,
		thanhtien, ngaygiaohang, nguoinhan, diachi,tggiaohang, loinhan, ghichu);      
		new HoaDAO().TangLuotMua(idhoatuoi); 
		
		addActionMessage("Đặt hàng thành công! Đơn hàng của bạn sẽ được xử lý trong thời gian sớm nhất.");		
		
        return home();
    }	
	public String doiMatKhau() {
		User nd = (User) session.get("nguoidung");       
	
		UserDAO userDAO=new UserDAO();
		
		userDAO.doimatkhau(nd.getId(), matkhaumoi);
	//lấy thông tin ng dùng
		hoten=nd.getHoten();
		sodienthoai=nd.getSodienthoai();
		email=nd.getEmail();
		//lấy danh sách hoa
		hoalist=new HoaDAO().getList();
		//lấy danh mục
		danhmuclist=new DanhMucDAO().getList();
		
		return "success";
		
	}
	public String capnhatHoSo() {
		User nd = (User) session.get("nguoidung");       
	
		UserDAO userDAO=new UserDAO();
		
		userDAO.capnhathoso(nd.getId(), hoten, sodienthoai,email);
		
		//lấy danh sách hoa
		hoalist=new HoaDAO().getList();
		//lấy danh mục
		danhmuclist=new DanhMucDAO().getList();
		
		return "success";
		
	}
	
	public String lichsuMuaHang() {
		System.out.println("Lich su mua hang");
		User nd = (User) session.get("nguoidung");   
		//lấy thông tin ng dùng
		hoten=nd.getHoten();
		sodienthoai=nd.getSodienthoai();
		email=nd.getEmail();
		//lấy danh sách đơn hàng
		dathoalist=new DonHangDAO().getListDatHoaTheoIdNguoiDung(nd.getId());
		
		//lấy danh mục
		 danhmuc=new DanhMucDAO().getDanhMucByID(iddanhmuc);
	     danhmuclist=new DanhMucDAO().getList();
		return "success";
    }
	
}