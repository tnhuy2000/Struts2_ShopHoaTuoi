package Action.Admin;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import DAO.DanhMucDAO;
import DAO.HoaDAO;
import DAO.UserDAO;
import Model.DanhMuc;
import Model.Hoa;
import Model.User;

public class HoaAction extends ActionSupport implements SessionAware {

 
	private List<Hoa> hoalist;
	private Hoa hoa;
	
	int id,gia;
	int luotxem, luotmua, iddanhmuc;
	String tenhoa;
	private List<DanhMuc> danhmuclist;
	private File hinh;
	private String hinhContentType;
	private String hinhFileName;
	private String mota;
	
	private String hoten;
	private String sodienthoai;
	private String email;
	
	private String message;
	
	private Map<String, Object> session;
	
	@Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
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

	public List<DanhMuc> getDanhmuclist() {
		return danhmuclist;
	}

	public void setDanhmuclist(List<DanhMuc> danhmuclist) {
		this.danhmuclist = danhmuclist;
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

	public int getIddanhmuc() {
		return iddanhmuc;
	}

	public void setIddanhmuc(int iddanhmuc) {
		this.iddanhmuc = iddanhmuc;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getMessage() {
		return message;
	}

	public List getHoalist() {
		return hoalist;
	}

	public Hoa getHoa() {
		return hoa;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public String getTenhoa() {
		return tenhoa;
	}

	public void setTenhoa(String tenhoa) {
		this.tenhoa = tenhoa;
	}
	
	public File getHinh() {
		return hinh;
	}

	public void setHinh(File hinh) {
		this.hinh = hinh;
	}

	public String getHinhContentType() {
		return hinhContentType;
	}

	public void setHinhContentType(String hinhContentType) {
		this.hinhContentType = hinhContentType;
	}

	public String getHinhFileName() {
		return hinhFileName;
	}

	public void setHinhFileName(String hinhFileName) {
		this.hinhFileName = hinhFileName;
	}

	public String create() {
        System.out.println("Create Hoa"); 
        User nd = (User) session.get("nguoidung");   
		//lấy thông tin ng dùng
		hoten=nd.getHoten();
		sodienthoai=nd.getSodienthoai();
		email=nd.getEmail();
        danhmuclist=new DanhMucDAO().getList();
        return SUCCESS;
	}
	
	public String store() {
        System.out.println("Store Hoa");
      
        String path = ServletActionContext.getServletContext().getRealPath("./img");
		System.out.println("Image Location:" + path);
		System.out.println(hinhFileName);
		 if(hinhFileName!=null)
		 {
			// handling the file
			File file = new File(path, hinhFileName);
			
			try {
				
				FileUtils.copyFile(hinh, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }

        
        HoaDAO hoaDAO=new HoaDAO();
        hoaDAO.store(tenhoa, hinhFileName, mota, gia, luotxem, luotmua, iddanhmuc);
        
      
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
        hoa=new HoaDAO().getHoaByID(id);
        danhmuclist=new DanhMucDAO().getList();
        return SUCCESS;
	}
	
	public String update() {
        System.out.println("Update Hoa");
        HoaDAO hoaDAO=new HoaDAO();
        String path = ServletActionContext.getServletContext().getRealPath("./img");
		System.out.println("Image Location:" + path);
		System.out.println(hinh);
		
		 if(hinhFileName!=null)
		 {
			// handling the file
			File file = new File(path, hinhFileName);
			
			try {
				
				FileUtils.copyFile(hinh, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 else
		 {
		        hoa= hoaDAO.getHoaByID(id);
		        hinhFileName=hoa.getHinh();			 
		 }
        
        hoaDAO.update(id,tenhoa, hinhFileName,mota, gia, luotxem, luotmua, iddanhmuc);
        
        message="Cập nhật thành công";
        //Hoalist=HoaDAO.getList();
        return "list";
	}
	
	public String delete() {
        System.out.println("Delete Hoa");
        HoaDAO hoaDAO=new HoaDAO();
        hoaDAO.delete(id);
        message="Xóa thành công";
        addActionMessage("Xóa thành công!");
        hoalist=hoaDAO.getList();
        return "list";    
	}
	
	public String list() {
        System.out.println("Hoa list");
        hoalist=new HoaDAO().getList();	
        danhmuclist=new DanhMucDAO().getList();
        User nd = (User) session.get("nguoidung");   
		//lấy thông tin ng dùng
		hoten=nd.getHoten();
		sodienthoai=nd.getSodienthoai();
		email=nd.getEmail();
        return SUCCESS;
    }
	
	
	
    
}