
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Mizu Shop - Quản lý hoa tươi</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css" />
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
      <h1>Danh sách người dùng</h1>	
		 <s:if test="hasActionMessages()">
	      <p>
	          <s:actionmessage /> 
	      </p>
	  </s:if>
		<p><a class="btn btn-primary" href="createUserAction">Thêm mới</a>
		<table id="PhanTrang" class="table table-hover">
		<thead>
			<tr>
			
			<th>Họ tên</th>
			<th>Số điện thoại</th>
			<th>Email</th>
			<th>Phân quyền</th>
			<th>Trạng thái</th>
			<th>Sửa</th>
			<th>Xoá</th>
			</tr>
		</thead>
		<tbody>
		<s:iterator var="user" value="userlist" >
		<tr>
			
			<td><s:property value="hoten"/></td>
			
			<td><s:property value="sodienthoai"/></td>
			<td><s:property value="email"/></td>
			<td>
			<s:if test="loaiquyen=='ADMIN'">
				<span class="label label-primary">Admin</span>
				
			</s:if>
			<s:else>
				<span class="label label-warning">Khách hàng</span>
			</s:else>
			
			</td>
			<td>
				<s:if test="trangthai==1">
					<a onclick="return confirm('Bạn chắc chắn muốn khoá người dùng <s:property value="hoten"/>?')" href='trangthaiUserAction?trangthai=0&id=<s:property value="id"/>'><span class="label label-success">Kích hoạt</span></a>
					
				</s:if>
				<s:else>
				   	
					<a onclick="return confirm('Bạn chắc chắn muốn kích hoạt người dùng <s:property value="hoten"/>?')" href='trangthaiUserAction?trangthai=1&id=<s:property value="id"/>'><span class="label label-danger">Khoá</span></a>
				</s:else>
			</td>
			
			<td>
				<s:if test="loaiquyen=='KHACH'">
					<a href='editUserAction?id=<s:property value="id"/>'>Chỉnh sửa</a>
				</s:if>
			</td>
			<td>
				<s:if test="trangthai!=1">
					<a href='deleteUserAction?id=<s:property value="id"/>' onclick="return confirm('Bạn chắc chắn xóa?')">Xóa</a>
				</s:if>
			</td>
		</tr>
		</s:iterator>
		<tbody>
		</table>
			
	   </div>
	  </div>
	</div>
<script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js"></script>
<script src="<s:url value='./public/js/shop.js'/>"></script>

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