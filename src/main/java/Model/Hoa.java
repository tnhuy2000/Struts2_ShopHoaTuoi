package Model;

public class Hoa {
	int idhoatuoi;
	String tenhoa;
	String hinh;
	String mota;
	int gia;
	int luotxem;
	int luotmua;
	int fk_iddanhmuc;
	
	
	
	public Hoa(int idhoatuoi, String tenhoa, String hinh, String mota, int gia, int luotxem, int luotmua,
			int fk_iddanhmuc) {
		super();
		this.idhoatuoi = idhoatuoi;
		this.tenhoa = tenhoa;
		this.hinh = hinh;
		this.mota = mota;
		this.gia = gia;
		this.luotxem = luotxem;
		this.luotmua = luotmua;
		this.fk_iddanhmuc = fk_iddanhmuc;
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


	public int getIdhoatuoi() {
		return idhoatuoi;
	}
	public void setIdhoatuoi(int idhoatuoi) {
		this.idhoatuoi = idhoatuoi;
	}
	public String getTenhoa() {
		return tenhoa;
	}
	public void setTenhoa(String tenhoa) {
		this.tenhoa = tenhoa;
	}
	public String getHinh() {
		return hinh;
	}
	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public int getFk_iddanhmuc() {
		return fk_iddanhmuc;
	}
	public void setFk_iddanhmuc(int fk_iddanhmuc) {
		this.fk_iddanhmuc = fk_iddanhmuc;
	}
	
	

	
}
