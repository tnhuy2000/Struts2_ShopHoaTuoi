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
	  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css" />
	  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" ></script>
   <link href="<s:url value='./public/css/shop.css'/>" rel="stylesheet" type="text/css"/>
   
<title>Trang chủ</title>
<style>
	table.table-bordered{
    border:1px solid green;
    margin-top:20px;
  }
table.table-bordered > thead > tr > th{
    border:1px solid green;
    font-size: 9pt;
}
table.table-bordered > tbody > tr > td{
    border:1px solid green;
}
</style>
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
                    <a class="dropdown-item" href=""><i class="fa fa-history"></i> Lịch sử mua hàng</a>
                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#fdangxuat" ><i class="fa fa-sign-out"></i> Đăng xuất</a>
                </div>
             </li>
			
			<li class="nav-item "><a class="nav-link" href="#" data-toggle="modal" data-target="#fdangxuat"><i class="fa fa-sign-out"></i> Đăng xuất</a></li>
			</ul>
			</div>
		</div>
	</nav>
	
 		<s:if test="hasActionMessages()">
		   <div class="welcome">
		      <s:actionmessage/>
		   </div>
		</s:if>
        

	<br>
    <div class="container">
    	
	    <div class="row">
		    <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
	         	
	         	<h4 class="text-danger text-uppercase font-weight-bold">LỊCH SỬ MUA HÀNG</h4>
	         	<table id="PhanTrang" class="table table-hover table-sm table-bordered" width="100%">
	         		<thead>
						<tr class="" style="background-color: #CCFFCC;">
							<th width="3%">#</th>
							
							<th width="9%" >Tên hoa</th>
							<th>Ảnh</th>
							<th width="3%">SL</th>		
							<th width="5%">Giá</th>		
							<th>TT</th>
							<th>Ngày đặt</th>
							<th>Ngày giao</th>
							<th >TG giao</th>
							<th >Người nhận</th>
							<th>Địa chỉ</th>
							
							<th>Lời nhắn</th>
							<th>Ghi chú</th>
							<th>Trạng thái</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator var="dathoa" value="dathoalist" >
						<tr>
							<td class="small"><s:property value="iddathoa"/></td>
							
							<td class="small"><s:property value="tenhoa"/></td>
							<td><img class="img-thumnail" src="./img/<s:property value="hinh"/>" width="70" height="60" alt=""></td>
							<td class="small"><s:property value="soluong"/></td>
							<td class="small"><s:property value="%{getText('{0,number,###,##0đ}', {gia})}"/></td>
							<td class="small"><s:property value="%{getText('{0,number,###,##0đ}', {thanhtien})}"/></td>
							<td class="small"><s:property value="ngaydat"/></td>
							<td class="small"><s:property value="ngaygiaohang"/></td>
							<td class="small"><s:property value="tggiaohang"/></td>
							<td class="small"><s:property value="nguoinhan"/></td>
							<td class="small"><s:property value="diachi"/></td>
							
							<td class="small"><s:property value="loinhan"/></td>
							<td class="small"><s:property value="ghichu"/></td>
							<td><s:if test="trangthai==0">
								    <span class='badge badge-secondary'>Chờ xử lý</span>
								</s:if>
								<s:elseif test="trangthai==1">
								   <span class='badge badge-warning'>Đã xử lý </span>
								</s:elseif>
								<s:elseif test="trangthai==2">
								   <span class='badge badge-primary'>Đang giao hàng </span>
								</s:elseif>
								<s:elseif test="trangthai==3">
								   <span class='badge badge-success'>Đã giao hàng </span>
								</s:elseif>
								<s:else>
								   <span class='badge badge-danger'>Đã huỷ đơn </span>
								</s:else>
							</td>
		                  </tr>
						</s:iterator>
					</tbody>
				</table>
		      </div>
		   </div>
			    	
    	</div>
	   
    </div>
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

<script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js"></script>
<script src="<s:url value='./public/js/shop.js'/>"></script>

<br>
<footer class="text-center">
 <br>
  <h2><a href="homeKhachAction"><img src="./img/logo.png" width="120" height="70" class="d-inline-block align-top" alt="" /></a></h2>
  
  <h6>&copy;Bản quyền thuộc về DH19TH1</h6>
    <h6>18 Ung Văn Khiêm, Đông Xuyên, TP Long Xuyên</h6>
</footer>
</body>
</html>