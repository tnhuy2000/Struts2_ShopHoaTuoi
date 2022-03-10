package Model;

public class User {
	int id;
	String email,hoten, sodienthoai, loaiquyen;
	int trangthai;
	
	public User(int id, String email, String hoten, String sodienthoai, int trangthai, String loaiquyen) {
		super();
		this.id = id;
		this.email = email;
		this.hoten = hoten;
		this.sodienthoai = sodienthoai;
		this.trangthai = trangthai;
		this.loaiquyen = loaiquyen;
	}
	
	public int getId() {
		return id;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getLoaiquyen() {
		return loaiquyen;
	}
	public void setLoaiquyen(String loaiquyen) {
		this.loaiquyen = loaiquyen;
	}
	
}
