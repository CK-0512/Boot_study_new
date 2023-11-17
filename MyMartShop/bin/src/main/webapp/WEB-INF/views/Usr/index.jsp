<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="">
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <link rel='stylesheet'  href='style.css'>
    <script src='script.js'></script>
</head>
<body>
    <header class="header">
        <a href="#" class="logo">
            <h1>logo</h1>
        </a>
        <!--링크-->
        <nav class="navbar">
            <a href="#">Home</a>
            <a href="#">Board</a>
            <a href="#">Shop</a>
        </nav>
        <!--아이콘-->
        <div class="icon">
            <i class='bx bx-user'></i>
            <i class='bx bx-buildings'></i>
            <i class='bx bx-search' id="search"></i>
        </div>
        <div class="search-form">
            <input type="search" id="search-box" placeholder="search here...">
            <label for="search-box" class="bx bx-search"></label>
        </div>
    </header>
    
</body>
<script src='script.js'></script>
</html>