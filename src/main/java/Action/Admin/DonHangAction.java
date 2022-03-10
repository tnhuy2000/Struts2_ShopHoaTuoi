package Action.Admin;


import java.util.List;
import java.util.Map;


import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import DAO.DonHangDAO;
import Model.DatHoa;
import Model.Hoa;
import Model.User;

public class DonHangAction extends ActionSupport implements SessionAware{
	
	private List<Hoa> hoalist;

	private List<DatHoa> dathoalist;
	
	private Hoa hoa;
	private int idhoatuoi;
	private int soluong;
	private int gia;
	private int thanhtien;
	
	private String message;
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
	private int trangthai;
	private Map<String, Object> session;

	private DatHoa dathoa;
	private int iddathoa;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Hoa> getHoalist() {
		return hoalist;
	}
	public void setHoalist(List<Hoa> hoalist) {
		this.hoalist = hoalist;
	}
	public List<DatHoa> getDathoalist() {
		return dathoalist;
	}
	public void setDathoalist(List<DatHoa> dathoalist) {
		this.dathoalist = dathoalist;
	}
	public Hoa getHoa() {
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
	public String getMatkhaumoi() {
		return matkhaumoi;
	}
	public void setMatkhaumoi(String matkhaumoi) {
		this.matkhaumoi = matkhaumoi;
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
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public DatHoa getDathoa() {
		return dathoa;
	}
	public void setDathoa(DatHoa dathoa) {
		this.dathoa = dathoa;
	}
	public int getIddathoa() {
		return iddathoa;
	}
	public void setIddathoa(int iddathoa) {
		this.iddathoa = iddathoa;
	}
	
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	public String edit() {
        System.out.println("Edit Don hang");
        User nd = (User) session.get("nguoidung");  
      //lấy thông tin ng dùng
  		hoten=nd.getHoten();
  		sodienthoai=nd.getSodienthoai();
  		email=nd.getEmail();
        dathoa=new DonHangDAO().getDonHangByID(iddathoa);
     
        return SUCCESS;
	}
	
	public String update() {
        System.out.println("Update Don hang");
        DonHangDAO dathoaDAO=new DonHangDAO();
        
        
		dathoaDAO.update(iddathoa,ngaygiaohang,tggiaohang,nguoinhan,diachi,loinhan,ghichu,trangthai);
        
        message="Cập nhật thành công";
        //Hoalist=HoaDAO.getList();
        return "list";
	}
	
	public String delete() {
        System.out.println("Delete don hang");
        DonHangDAO dathoaDAO=new DonHangDAO();
        dathoaDAO.delete(iddathoa);
        message="Xóa thành công";
        dathoalist=dathoaDAO.getList();
        return "list";    
	}
	
	public String list() {
        System.out.println("Don hang list");
		//lấy danh sách đơn hàng
		dathoalist=new DonHangDAO().getList();	
		User nd = (User) session.get("nguoidung");   
		//lấy thông tin ng dùng
		hoten=nd.getHoten();
		sodienthoai=nd.getSodienthoai();
		email=nd.getEmail();
		return SUCCESS;
    }
}
