<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora">
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script&family=Lobster&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> 
  	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
	  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" ></script>
   <link href="<s:url value='./public/css/shop.css'/>" rel="stylesheet" type="text/css"/>
   
<title>Đặt hoa</title>
</head>
<body>

   
 	<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
		<div class="container">
			
			<a class="navbar-brand" href="homeKhachAction">
				<img src="./img/logo.png" width="100" height="40" class="d-inline-block align-top" alt="" />
			</a>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
	              <li class="nav-item active"><a class="nav-link" href="homeKhachAction"><i class="bi bi-house-fill"></i> Trang chủ</a></li>
	              <li class="nav-item dropdown active">
	                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"> Danh mục</a>
	                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
	                      <s:iterator var="danhmuc" value="danhmuclist" >
	                        <a class="dropdown-item" href="groupdanhmuc?iddanhmuc=<s:property value="iddanhmuc"/>"><s:property value="tendanhmuc"/></a>
	                      </s:iterator>
	                    </div>
	              </li>
	              
	        </ul>
	        <s:form action="TimKiem" method="GET" class="col-sm-5"> 
               
                <div class="input-group mb-0">
                        <input type="search" required class="form-control" name="tukhoa" style="width=300px;" placeholder="Tìm hoa ..." aria-label="Recipient's username" aria-describedby="button-addon2">
                    <div class="input-group-append">
                        <button class="btn" style="background-color:#FF9933;" type="submit"><i class="bi bi-search  text-white"></i></button>
                    </div>
                </div>
            </s:form>
			<ul class="navbar-nav ml-auto">
			
			<li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown">
                    <i class="bi bi-person-fill"></i><s:property value="hoten"/>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="#" data-target="#fdoimatkhau" data-toggle="modal"><i class="fa fa-lock"></i> Đổi mật khẩu</a>
                    <a class="dropdown-item" href="#" data-target="#fcapnhathoso" data-toggle="modal"><i class="fa fa-id-card"></i> Cập nhật hồ sơ</a>
                    <a class="dropdown-item" href="lichsuMuaHang"><i class="fa fa-history"></i> Lịch sử mua hàng</a>
                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#fdangxuat" ><i class="fa fa-sign-out"></i> Đăng xuất</a>
                </div>
             </li>
			<li class="nav-item "><a class="nav-link" href="#" data-toggle="modal" data-target="#fdangxuat"><i class="fa fa-sign-out"></i> Đăng xuất</a></li>
			</ul>
			</div>
		</div>
	</nav>  
	<br>
	 <div class="container">
    <!-- start row 1--> 
     <s:form action="submitOrderAction" method="POST"> 
    <div class="row">
        <div class="col-sm-5">     
            <div class="zoom-anh"><p><img class="rounded" src="./img/<s:property value="hoa.hinh"/>" width="450px" height="450px"></p></div>
            <br>
        </div>
        <div class="col-sm-7">
            <div class="bg-white pb-2 pt-3 px-4 rounded">
                <h5 class="text-success"><s:property value="hoa.tenhoa"/></h5>
                
	                <div class="alert alert-success" role="alert">
	                    <h4 class="text-primary">Giá bán: 
	                    	<span class="text-danger"><s:property value="%{getText('{0,number,###,##0}', {hoa.gia})}"/><sup>đ</sup></span>
	                    </h4>
	                    
	                    <span class="badge badge-light">Lượt xem: <s:property value="hoa.luotxem"/></span>
                    <span class="badge badge-light">Lượt mua: <s:property value="hoa.luotmua"/></span>
	                </div>
           
               
                	<input type="hidden" id="gia" name="gia" value='<s:property value="hoa.gia"/>'/>
                    <input type="hidden" name="idhoatuoi" value='<s:property value="idhoatuoi"/>'/>
                    <div class="form-row">
                        <div class="form-group col-sm-4">
                            <label for="">Số lượng</label>
                            <input class="form-control" type="number" id="soluong" name="soluong" value="0" required onchange="tinhthanhtien()" min=1 max=10>
                           
                        </div>
                    </div>
                   
                	<div class="form-row">
                        <div class="form-group col-sm-4">
                            <label for="">Thành tiền </label>
                            
                        	<input class="form-control" type="number" id="thanhtien" name="thanhtien" readonly>
                        </div>
                    </div>
                    
                   
                    <a type="" href="#hoantatdathang" class="btn btn-success">Đặt hàng</a>
                <br><br>
                
        
            </div>
        </div>
    </div>
    <!-- end row 1-->
    <!--======================================-->
    <!-- start row 2-->
    
    <div class="row">
        
        <div class="col-sm-12">
            <div class="bg-white px-2 py-2 rounded">
                <div class="accordion" id="accordionExample">
 
  
				  <div class="card">
				    <div class="card-header" id="headingThree">
				      <h2 class="mb-0">
				        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
				          MÔ TẢ SẢN PHẨM
				        </button>
				      </h2>
				    </div>
				    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
				      <div class="card-body">
				      <div><s:property value="hoa.mota"/></div>
				        
				      </div>
				    </div>
				  </div>
				</div>
				 <br>
				<div id="hoantatdathang" class="alert alert-danger alert-dismissible fade show mb-0" role="alert">
		            <h5 > THÔNG TIN ĐẶT HÀNG</h5>
				</div>
							
					<br>
					
					<div class="form-row">
						<div class="form-group col-sm-6">
							<label class="control-label">Ngày giao hàng</label>
							<input type="date" name="ngaygiaohang" class="form-control" value="2022-01-10" required>
						</div>
						<div class="form-group col-sm-6">
							<label class="control-label">Thời gian giao hàng</label><br>
							<input class="form-control" type="time" name="tggiaohang" min="07:00" max="21:00" value="07:00" required>
						</div>
					</div>
					
						
					
					 <div class="form-group">
						<label class="control-label">Thông tin người nhận</label>
						<textarea class="form-control" id="nguoinhan" name="nguoinhan" required placeholder="Ví dụ: Nguyễn Thị Hoa, Số điện thoại: 0123456789"></textarea>
					</div>
					
					<div class="form-group">
						<label class="control-label">Địa chỉ giao hàng</label><br>
						<input class="form-control" type="text" name="diachi" required placeholder="Nhập địa chỉ giao hàng">
					</div> 
					
					
					
					 
					<div class="form-group">  
						<label>Lời nhắn & Thông điệp</label>
						<input class="form-control" type="text" name="loinhan">
					</div>
					<div class="form-group">
						<label>Yêu cầu, lưu ý cho shop</label>
						<textarea class="form-control" id="mota" name="ghichu" placeholder="Ví dụ: Mô tả địa chỉ giao hàng chi tiết, giấu thông tin người gửi, ..."></textarea>
					</div>
					
					<div class="form-group">
						<input type="submit" value="Hoàn tất đặt hàng" class="btn btn-success">
						<a href="homeKhachAction" type="button" class="btn btn-warning">Huỷ</a>
					</div>
				
				</div>
            
                
            </div>

                
        </div>
       </s:form>
    </div>
    <!--end row 2 -->
    <!--======================================-->
    <!-- start row 3-->
    <hr>
    
    <!--end row 3-->
</div>
<!-- =========================== -->

	<script>
	function tinhthanhtien() {
		var soluong = document.getElementById("soluong").value;
		var gia = document.getElementById("gia").value;
		document.getElementById("thanhtien").value = soluong*gia;
	}
	
	
	</script>
	    <!--Bắt đầu đăng xuất-->
	<div class="modal fade" id="fdangxuat" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title">Đăng xuất</h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
                
            </div>
            <div class="modal-body">
                <form method="post" enctype="multipart/form-data">
                    
                    <div class="form-group">
                        <label>Bạn chắn chắn muốn đăng xuất?</label>
                    </div>
                    
                </form>
            </div>
            <div class="modal-footer">
              <a href="logOut" class="btn btn-success" type="button" >Đồng ý</a>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>
<!--Bắt đầu đổi mật khẩu-->
<div class="modal fade" id="fdoimatkhau" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title">Đổi mật khẩu</h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
                
            </div>
            <div class="modal-body">
                 <s:form action="doiMatKhau" method="POST"> 
                    
                    <div class="form-group">
                        <label>Mật khẩu mới</label>
                        <input class="form-control" type="password" name="matkhaumoi"
                        placeholder="Nhập mật khẩu mới" required>
                    </div>
                    
                    <div class="form-group">
                        <input class="btn btn-primary" type="submit" value="Lưu">
                        <input class="btn btn-warning" type="reset" value="Hủy">
                    </div>
                </s:form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<!--Kết thúc đổi mật khẩu-->
<!--cập nhật thông tin người dùng-->
<div class="modal fade" id="fcapnhathoso" role="dialog" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title">Hồ sơ cá nhân</h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
                
            </div>
            <div class="modal-body">
            	
                <s:form action="capnhatHoSo" method="POST"> 
                    
                    <div class="form-group">
                        <label>Email</label>
                        <input class="form-control" type="email" name="email"
                        placeholder="Email" value="<s:property value="email"/>"
                        >
                    </div>
                    <div class="form-group">
                        <label>Số điện thoại</label>
                        <input class="form-control" type="number" name="sodienthoai"
                        placeholder="Email" value="<s:property value="sodienthoai"/>"
                        >
                    </div>
                    <div class="form-group">
                        <label>Họ tên</label>
                        <input class="form-control" type="text" name="hoten"
                        placeholder="Họ tên" value="<s:property value="hoten"/>"
                        required>
                    </div>
                    
                    <div class="form-group">
                        
                        <input class="btn btn-success" type="submit" value="Lưu">
                        
                    </div>
                </s:form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<br>
<footer class="text-center">
  
 <br>
  <h2><a href="homeKhachAction"><img src="./img/logo.png" width="120" height="70" class="d-inline-block align-top" alt="" /></a></h2>
  
  <h6>&copy;Bản quyền thuộc về DH19TH1</h6>
    <h6>18 Ung Văn Khiêm, Đông Xuyên, TP Long Xuyên</h6>
</footer>
</body>
</html>