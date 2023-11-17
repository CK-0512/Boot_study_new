<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="로그인" />
<link rel='stylesheet' href='login.css'>
<%@ include file="../../common/head.jsp"%>
<body>
	<div class="wrapper">
		<div class="form-box login">
			<h1>Login</h1>
			<form name="company" method="post" action="/Usr/Company/companyLogin">

				<div class="input-box">
					<span class="icon"><i class='bx bxs-user'></i></span> <input
						name="c_name" type="text" placeholder="사명" required>
				</div>	
				<div class="input-box">
					<span class="icon"><i class='bx bxs-lock-alt'></i></span> <input
						name="corNum" type="password" placeholder="법인번호" required>

				</div>
				<button type="submit" class="btn">Login</button>
			</form>
		</div>
	</div>
	<%@ include file="../../common/foot.jsp"%>