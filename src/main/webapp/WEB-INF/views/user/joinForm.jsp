<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<style>
	body {
	    background-color: #eaf2d7;
	    font-family: Arial, sans-serif;
	}
	
	.container {
	    margin-top: 50px;
	    margin-bottom: 50px;
	    max-width: 400px;
	    background-color: #ffffff;
	    border-radius: 10px;
	    box-shadow: 0px 0px 20px 0px rgba(0, 0, 0, 0.2);
	    padding: 40px;
	    
	    
	}
	
	.form-group {
	    margin-bottom: 20px;
	    
	}
	
	.form-control {
	    width: calc(100% - 20px);
	    padding: 15px 10px;
	    font-size: 16px;
	    border: 1px solid #ced4da;
	    border-radius: 5px;
	    margin-top: 7px;
	    margin-bottom: 10px;
	    display: inline-block;
	    box-sizing: border-box;
	    transition: border-color 0.3s;
	}
	.wa{
		text-align: left;
	}
	
	.form-control:focus {
	    border-color: #007bff;
	}
	
	.btn-primary {
	    background-color: #D2E5A8;
	    color: #ffffff;
	    border: none;
	    border-radius: 5px;
	    padding: 15px 20px;
	    font-size: 18px;
	    cursor: pointer;
	    transition: background-color 0.3s;
	    width: 100%;
	}
	
	.btn-primary:hover {
	    background-color: #C0D396;
	}
	
	.btn-save:active {
	    background-color: #003366;
	}
	h2{
		text-align: center;
	}

</style>

<div class="container">
<h2>회원가입 </h2>
<form>

  <div class="form-group">
  
    
    <input type="text" class="form-control" placeholder="사용자명" id="username">
  </div>
  
   <div class="form-group">
   	
   	 
  	  <input type="password" class="form-control" placeholder="비밀번호" id="password">
  </div>
  
   <div class="form-group">
    	
   	 <input type="email" class="form-control" placeholder="이메일" id="email">
  </div>
 
</form>
  <button id = "btn-save" class="btn btn-primary">회원가입 완료</button>


</div>

<%@ include file="../layout/footer.jsp" %>
<script src="/js/user.js"></script>
