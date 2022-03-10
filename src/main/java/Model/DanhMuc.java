package Model;

public class DanhMuc {
	int iddanhmuc;
	String tendanhmuc;
	
	public DanhMuc(int iddanhmuc, String tendanhmuc) {
		super();
		this.iddanhmuc = iddanhmuc;
		this.tendanhmuc = tendanhmuc;
	}
	public int getIddanhmuc() {
		return iddanhmuc;
	}
	public void setIddanhmuc(int iddanhmuc) {
		this.iddanhmuc = iddanhmuc;
	}
	public String getTendanhmuc() {
		return tendanhmuc;
	}
	public void setTendanhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}
	
	
	
}
