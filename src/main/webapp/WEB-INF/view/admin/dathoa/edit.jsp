<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Mizu Shop - Chỉnh sửa hoa</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <link href="<s:url value='./public/css/shop.css'/>" rel="stylesheet" type="text/css"/>
  <style>
    .row.content {height: 1000px}
    .sidenav {background-color: #f1f1f1; height: 100%;}
    @media screen and (max-width: 767px) { .row.content {height: auto;} }
  </style>
</head>
<body>
<!-- Menu mh nhỏ -->
<nav class="navbar navbar-inverse visible-xs">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Mizu Shop</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="homeAdminAction"><span class="glyphicon glyphicon-cog"></span> Bảng điều khiển</a></li>
        <li><a href="listHoaAction"><span class="glyphicon glyphicon-asterisk"></span> Quản lý hoa tươi</a></li>
        <li><a href="listDanhMucAction"><span class="glyphicon glyphicon-list-alt"></span> Quản lý danh mục</a></li>
        <li><a href="listDonHangAction"><span class="glyphicon glyphicon-gift"></span> Quản lý đơn hàng</a></li>
		<li><a href="listUserAction"><span class="glyphicon glyphicon-user"></span> Quản lý người dùng</a></li>
              
      </ul>
    </div>
  </div>
</nav>
<!-- Menu mh nhỏ - kết thúc -->
<div class="container-fluid">
  <div class="row content">
    <!-- Menu mh lớn -->     
    <div class="col-sm-3 sidenav hidden-xs">
      <h3>          
        <span class="label label-info">M</span>
        <span class="label label-warning">I</span>
        <span class="label label-danger">Z</span>
        <span class="label label-danger">U</span>
        Shop
      </h3><br>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="homeAdminAction"><span class="glyphicon glyphicon-cog"></span> Bảng điều khiển</a></li>
        <li><a href="listHoaAction"><span class="glyphicon glyphicon-asterisk"></span> Quản lý hoa tươi</a></li>
        <li><a href="listDanhMucAction"><span class="glyphicon glyphicon-list-alt"></span> Quản lý danh mục</a></li>
        <li><a href="listDonHangAction"><span class="glyphicon glyphicon-gift"></span> Quản lý đơn hàng</a></li>
		<li><a href="listUserAction"><span class="glyphicon glyphicon-user"></span> Quản lý người dùng</a></li>
       
		
      </ul><br>
    </div>
    <!-- Menu mh lớn - kết thúc -->
    <br>
    
    <div class="col-sm-9">
      <div class="container-fluid">  
        <!-- Thông tin người dùng - sẽ bổ sung ở bài thực hành sau -->          
        <div class="dropdown" style="text-align: right;">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            <span class="glyphicon glyphicon-user"></span> Chào Quản trị
            <span class="caret"></span>
          </a>
            
          <ul class="dropdown-menu dropdown-menu-right">
           
            <li><a href="#" data-toggle="modal" data-target="#fcapnhathoso">
            <span class="glyphicon glyphicon-edit"></span> Hồ sơ cá nhân</a></li>
            <li><a href="#" data-toggle="modal" data-target="#fdoimatkhau">
            <span class="glyphicon glyphicon-wrench"></span> Đổi mật khẩu</a></li>
            <li class="divider"></li>
            <li><a href="#" data-target="#fdangxuat" data-toggle="modal"><span class="glyphicon glyphicon-log-out"></span> Thoát</a></li>
          </ul>
        </div>
      </div>
      <h1>Cập nhật đơn hàng <label>#<s:property value="dathoa.iddathoa"/></label></h1>	
		<br>
		<s:form action="updateDonHangAction" method="POST" enctype="multipart/form-data" validate="true">
			<input type="hidden" name="iddathoa" value='<s:property value="dathoa.iddathoa"/>'/>
			
			<div class="form-group">
				<label>Trạng thái đơn hàng</label>
				
				<select class="form-control" name="trangthai">
				
					<s:if test="dathoa.trangthai==0">
					<option value="0" selected>Chờ xử lý</option>
				    <option value="1" >Đã xử lý</option>
				    <option value="2" >Đang giao hàng</option>
				    <option value="3" >Đã giao hàng</option>
				    <option value="4" >Đã huỷ đơn</option>
				</s:if>
				<s:elseif test="dathoa.trangthai==1">
				    <option value="1" selected>Đã xử lý</option>
				    <option value="2" >Đang giao hàng</option>
				    <option value="3" >Đã giao hàng</option>
				    <option value="4" >Đã huỷ đơn</option>
				</s:elseif>
				<s:elseif test="dathoa.trangthai==2">
				    <option value="2" selected>Đang giao hàng</option>
				    <option value="3" >Đã giao hàng</option>
				    <option value="4" >Đã huỷ đơn</option>
				</s:elseif>
				<s:elseif test="dathoa.trangthai==3">
				    <option value="3" selected>Đã giao hàng</option>
				</s:elseif>
				<s:else>
				    <option value="4" selected>Đã huỷ đơn</option>
				</s:else>
				
				</select>
			</div>
			<div class="form-group">
				<label>Họ tên khách hàng: <s:property value="dathoa.hoten"/></label>
				<label>-----------Số điện thoại: <s:property value="dathoa.sodienthoai"/></label>
				
				
			</div>
			<div class="form-group">
				<label>Tên hoa: <s:property value="dathoa.tenhoa"/></label>
				<label></label>
				<img class="img-thumnail" width='80' src='./img/<s:property value="dathoa.hinh"/>'/>
				<label>-----------Giá: <s:property value="%{getText('{0,number,###,##0đ}', {dathoa.gia})}"/></label>
				<label>-----------Số lượng: <s:property value="dathoa.soluong"/></label>
				<label>-----------Thành tiền: <s:property value="%{getText('{0,number,###,##0đ}', {dathoa.thanhtien})}"/></label>
			</div>
			
			<div class="form-group">
				<label>Ngày đặt: <s:property value="dathoa.ngaydat"/></label>
				
			</div>
			<div class="form-group">
				<label>Ngày giao hàng</label>
				<input type="date" name="ngaygiaohang" id="ngaygiaohang" class="form-control" value="<s:property value="dathoa.ngaygiaohang"/>" required>
				
			</div>
			<div class="form-group">
				<label>Thời gian giao hàng</label>
				<input class="form-control" type="time" name="tggiaohang" min="07:00" max="21:00" value="<s:property value="dathoa.tggiaohang"/>" required>
			</div>
			<div class="form-group">
				<label>Người nhận</label>
				<input class="form-control" name="nguoinhan" id="nguoinhan" value="<s:property value="dathoa.nguoinhan"/>">
			</div>
			<div class="form-group">
				<label>Địa chỉ giao hàng</label>
				<textarea class="form-control" name="diachi" id="diachi"><s:property value="dathoa.diachi"/></textarea>
			</div>
			<div class="form-group">
				<label>Lời nhắn</label>
				<textarea class="form-control" name="loinhan" id="loinhan"><s:property value="dathoa.loinhan"/></textarea>
			</div>
			<div class="form-group">
				<label>Ghi chú</label>
				<textarea class="form-control" name="ghichu" id="ghichu"><s:property value="dathoa.ghichu"/></textarea>
			</div>
			
			
		
			
			<div class="form-group">
				<input type="submit" value="Lưu" class="btn btn-success">
				<input type="reset" value="Hủy" class="btn btn-warning">
			</div>
		
		</s:form>
		
   </div>
  </div>
</div>
<!--Bắt đầu đăng xuất-->
<div class="modal fade" id="fdangxuat" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
                <h3 class="modal-title">Đăng xuất</h3>
            </div>
            <div class="modal-body">
                <form method="post" >
                    <div class="form-group">
                        <label>Bạn chắc chắn muốn đăng xuất?</label>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            	<a type="button" class="btn btn-success" href="logOut">Đồng ý</a>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
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
                 <s:form  method="POST" action="doimatkhauAdmin"> 
                    
                    <div class="form-group">
                        <label>Mật khẩu mới</label>
                        <input class="form-control" type="password" name="matkhaumoi" placeholder="Nhập mật khẩu mới" required>
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
            	
                <s:form action="capnhathosoAdmin" method="POST"> 
                    
                    <div class="form-group">
                        <label>Email</label>
                        <input class="form-control" type="email" id="email" name="email"placeholder="Email" value="<s:property value="email"/>" required>
                    </div>
                    <div class="form-group">
                        <label>Số điện thoại</label>
                        <input class="form-control" type="number" id="sodienthoai" name="sodienthoai" value="<s:property value="sodienthoai"/>" required>
                    </div>
                    <div class="form-group">
                        <label>Họ tên</label>
                        <input class="form-control" type="text" id="hoten" name="hoten" placeholder="Họ tên" value="<s:property value="hoten"/>" required>
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
</body>
</html>