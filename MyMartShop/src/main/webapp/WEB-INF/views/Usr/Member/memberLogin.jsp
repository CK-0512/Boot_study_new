<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="로그인" />
<link rel='stylesheet' href='/css/login.css'>
<%@ include file="../../common/head.jsp" %>
<body>
<div class="wrapper">
    <div class="form-box login">
        <h1>Login</h1>
        <form name="member" method="post" action="/Usr/Member/memberLogin" >
        
            <div class="input-box">
                <span class="icon"><i class='bx bxs-user' ></i></span>
                <input name="memberid" type="text" placeholder="Your Id" required>   
            </div>
            <div class="input-box">
                <span class="icon"><i class='bx bxs-lock-alt'></i></span>
                <input name="pass" type="password" placeholder="Your Password" required>
                
            </div> 
            <div class="remember-forgot">
                <label><input type="checkbox">Remember me</label>
                <a href="#">Forgot password?</a>
            </div>
                <button type="submit" class="btn">Login</button>
            <div class="register-link">
            <p>Don't have an account?
                <a href="/Usr/Member/memberInfo_insert">Register</a>
            </p>

        </div>
    </form>
</div>
</div>
<%@ include file="../../common/foot.jsp" %>