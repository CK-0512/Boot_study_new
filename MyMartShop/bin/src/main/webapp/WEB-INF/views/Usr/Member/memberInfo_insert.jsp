<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="회원 가입" />
<link rel='stylesheet' href='register.css'>
<%@ include file="../../common/head.jsp" %>
<body>
<script>
	$(function(){
		//아이디 중복
		$("input[name='memberid']").on("change",function(){
			var memberid=$('#memberid').val();
			$.ajax({
				url:'member_idcheck',
				type:'post',
				data:{'memberid':memberid},
				success:function(result){
					if(result==0){
						memberID_c.innerHTML="사용가능한 아이디입니다";
					}else if(result==1){
						memberID_c.innerHTML="중복된 아이디입니다";
			            $('#memberid').val('');
			            $('#memberid').focus();
					}else{
						alert("Error");
					}
				}
			});
				
		});
	
		//비번 체크
		$("input[name='repass']").on("change",function(){
			var pass=$('#pass').val();
			var repass=$('#repass').val();
			if(pass!=repass){
				repass_c.innerHTML="비밀번호를 다시 입력하세요";
				$('#repass').val('');
				$('#repass').focus();
			}else if(pass==repass){
				repass_c.innerHTML="확인되었습니다";
			}
		});
	});
</script>
<div class="wrapper">
    <div class="form-box register">
        <h1>Registration</h1>
        <form name="member" method="post" action="/Usr/Member/memberInfo_insert" >
        <div class="input-box">
                <span class="icon"><i class='bx bxs-user' ></i></span>
                <input name="memberid" id="memberid" type="text" placeholder="ID" required> 
                <!-- ajax -->
                <a id="memberID_c"></a>  
            </div>
            <div class="input-box">
                <span class="icon"><i class='bx bxs-user' ></i></span>
                <input name="m_name" type="text" placeholder="UserName" required>   
            </div>
            <div class="input-box">
                <span class="icon"><i class='bx bxs-lock-alt'></i></span>
                <input name="pass" id="pass" type="password" placeholder="Password" required>
            </div>
            <div class="input-box">
                <span class="icon"><i class='bx bxs-lock'></i></span>
                <input name="repass" id="repass" type="password" placeholder="Re Password" required>
                <!-- ajax -->
                <a id="repass_c"></a>  
            </div> 
            <div class="input-box">
                <span class="icon"><i class='bx bxs-envelope' ></i></span>
                <input name="m_tel" type="text" placeholder="Phone Number" required>   
            </div>
            <div class="input-box">
                <span class="icon"><i class='bx bxs-building' ></i></span>
                <input name="age" type="text" placeholder="Age" required>   
            </div>
            <div class="input-box">
                <span class="icon"><i class='bx bxs-building-house' ></i></span>
                <input name="job" type="text" placeholder="job" required>   
            </div>
            <div class="remember-forgot">
                <label><input type="checkbox">Agree to register</label>
            </div>
                <button type="submit" class="btn">Sign up</button>
            <div class="register-link">
            <p>Already have an account?
                <a href="/Usr/Member/memberLogin">Login</a>
            </p>
        </div>
    </form>
</div>
</div>
<%@ include file="../../common/foot.jsp" %>