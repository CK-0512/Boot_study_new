<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <link rel='stylesheet'  href='/css/menubar.css'>
    <link rel='stylesheet'  href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css'>
<title>${pageTitle }</title>
</head>
<body>
    <header class="header">
        <a href="/" class="logo">
            <h2>logo</h2>
        </a>
        
        <!--링크-->
        <nav class="navbar">
            <a href="/">Home</a>
            <a href="/Usr/Article/articleList">Board</a>
            <a href="#">Shop</a>
        </nav>
        <!--아이콘-->
        <div class="icon">
            
        <ul>
            <li> <i class='bx bx-buildings'></i></li>
            <li><i class='bx bx-user'></i>
            <ul class="dropdown">
                <c:if test="${member==null}">
	                <li><a href="/Usr/Member/memberLogin">Login</a></li>
	                <li><a href="/Usr/Member/memberInfo_insert">Register</a></li>
                </c:if>
                <c:if test="${member!=null}">
                	<li><a href="">MyPage</a></li>
                	<li><a href="/Usr/Member/memberLogout">Logout</a></li>
                </c:if>	
            </ul>
        </li>
            
            <li><i class='bx bx-search' id="search"></i></li>
        </ul>
        </div>
        <form action="" method="post" class="search-form">
            <input type="text" id="search-box" placeholder="search here...">
            <a href="#"><label for="search-box" class="bx bx-search"></label></a>
        </form>
    </header>
    
</body>
<script src='/js/script.js'></script>
</html>