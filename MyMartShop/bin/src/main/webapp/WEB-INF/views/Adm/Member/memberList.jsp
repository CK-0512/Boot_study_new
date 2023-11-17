<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' href='/css/list.css'>
    <script src='main.js'></script>
</head>
<body>
    <main>
    <div class="list">
		<c:forEach var="member" items="${list}">
	        <div class="line">
	            <div class="user">
	                <div class="details">
	                    <h1 class="name">NAME:${member.m_name}</h1>
	                    <h1 class="id">ID:${member.memberid}</h1>
	                </div>
	            </div>
	            <div class="first-login">
	                <p>${member.regdate.substring(0,10)}</p>
	            </div>
	            <div class="last-login">
	                <p>${member.lastlogin.substring(0,10)}</p>
	            </div>
	            <div class="phone">
	                <p>${member.m_tel}</p>
	            </div>
	            <div class="delete">
	                <a href="#" class="btn">Delete</a>
	            </div>
	            <div class="action">
	                <div class="icon">
	                    <span></span>
	                    <span></span>
	                    <span></span>
	                </div>
	            </div>
	        </div>
		</c:forEach>
    </div>
</main>
</body>
</html>