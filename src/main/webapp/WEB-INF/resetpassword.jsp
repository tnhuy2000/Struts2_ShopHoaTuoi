<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora">
	<link href="https://fonts.googleapis.com/css2?family=Dancing+Script&family=Lobster&display=swap" rel="stylesheet">
  <link href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet"> 
  	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
	  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" ></script>
	<style>
		:root {
		--font-family-sans-serif: "Lora", sans-serif;
		--font-family-monospace: SFMono-Regular, Menlo, Monaco, Consolas, "Liberation Mono", "Courier New", monospace;
			}
		
	
		body{
			font-family: "Lora", sans-serif;
			background-color: white;
			background-image:url("./img/bg-dn.jpg");
			background-repeat: no-repeat;
			background-size: cover;
		}
		.banner{
	      max-width: 100%;
	      margin: 0px 0px;
	      padding: 0px;
	    }
	</style>
<title>Quên mật khẩu</title>
</head>
<body>
<div class="banner">
  <img name="bannerpic" class="banner" src="./img/bannerhoatuoi.jpg">  
</div>
 	<nav class="navbar navbar-light bg-light sticky-top">
		<div class="container">
			<a class="navbar-brand" href="login">
				<img src="./img/logo.png" width="100" height="40" class="d-inline-block align-top" alt="" />
				<b>Quên mật khẩu</b></a>
		</div>
	</nav>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">

			</div>
			<div class="col-sm-6">
				<div class="card">
					<h4 class="card-header"><i class="bi bi-box-arrow-right"></i> <b>QUÊN MẬT KHẨU</b></h4>
					<div class="card-body">
					<s:if test="hasActionMessages()">
				        <div class="text-danger">
				            <b><s:actionmessage /> </b>
				        </div>
				    </s:if>
				    
					<form action="NewPassWord" method="POST">
						<div class="form-group">
							<label for="" >Email</label>
							<input type="email" class="form-control"  name="email">
							
						</div>
						
						<div class="form-group">
							<button type="submit" class="btn btn-block btn-success">Gửi</button>
						</div>
						
						
							<label for="">
									Bạn có tài khoản? <a href="login">Đăng nhập</a> 
							</label>
						
						
					 </form>
					
					</div>
				</div>

			</div>
		</div>
	</div>
 

    
</body>
</html>