<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp" %>
<style>
    body {
        background-color: #eaf2d7;
        
    }

    .btn-primary {
        background-color: #D2E5A8;
        color: #ffffff;
        border: none;
        border-radius: 5px;
        
        font-size: 18px;
        cursor: pointer;
        transition: background-color 0.3s;
        margin-bottom: 15px;
    }

    .btn-primary:hover {
        background-color: #C0D396;
    }
    
</style>
<div class="container">
 	<form>
	  <div class="form-group">
	    <input type="text" class="form-control" placeholder="Enter Title" id="title">
	  </div>
	
	  
	<div class="form-group">
	  <textarea class="form-control summernote" rows="5" id="content"></textarea>
	</div>
	  
	
	</form>
	  <button id="btn-save" class="btn btn-primary">글쓰기 완료</button>
</div>
	<script>
	      $('.summernote').summernote({
	        placeholder: '글을 작성해주세요 !',
	        tabsize: 2,
	        height: 300
	      });
	</script>
	<script src ="/js/board.js"></script>
<%@include file="../layout/footer.jsp" %>
