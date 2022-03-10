
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
      <h1>Danh sách đơn hàng</h1>	
		 <s:if test="hasActionMessages()">
	      <p>
	          <s:actionmessage /> 
	      </p>
	  </s:if>
		
		<table id="PhanTrang" class="table table-hover table-sm table-bordered" width="100%">
        		<thead>
				<tr class="" >
					<th width="3%">#</th>
					<th width="9%" >Khách hàng</th>
					<th width="5%" >Tên hoa</th>
					<th>Ảnh</th>
					<th width="3%">SL</th>		
					<th width="5%">Giá</th>		
					<th>TT</th>
					<th>Ngày đặt</th>
					<th>Ngày giao</th>
					<th >TG giao</th>
					<th >Người nhận</th>
					<th>Địa chỉ</th>
					
					
					<th>Ghi chú</th>
					<th>Trạng thái</th>
					<th width="3%">Sửa</th>
					<th  width="3%">Xoá</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator var="dathoa" value="dathoalist" >
				<tr>
					<td class="small"><s:property value="iddathoa"/></td>
					<td class="small"><s:property value="hoten"/></td>
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
					
					
					<td class="small"><s:property value="ghichu"/></td>
					<td><s:if test="trangthai==0">
						    <span class='label label-default'>Chờ xử lý</span>
						</s:if>
						<s:elseif test="trangthai==1">
						   <span class='label label-warning'>Đã xử lý </span>
						</s:elseif>
						<s:elseif test="trangthai==2">
						   <span class='label label-primary'>Đang giao hàng </span>
						</s:elseif>
						<s:elseif test="trangthai==3">
						   <span class='label label-success'>Đã giao hàng </span>
						</s:elseif>
						<s:else>
						   <span class='label label-danger'>Đã huỷ đơn </span>
						</s:else>
					</td>
					<td>
					<s:if test="trangthai==0 ||trangthai==1 |trangthai==2">
						    <a href='editDonHangAction?iddathoa=<s:property value="iddathoa"/>'>Chỉnh sửa</a>
					</s:if>
					
					</td>
					<td>
					<s:if test="trangthai==3 ||trangthai==4">
						   <a href='deleteDonHangAction?iddathoa=<s:property value="iddathoa"/>' onclick="return confirm('Bạn chắc chắn xóa?')">Xóa</a>
					</s:if>
					
					</td>
                  </tr>
				</s:iterator>
			</tbody>
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