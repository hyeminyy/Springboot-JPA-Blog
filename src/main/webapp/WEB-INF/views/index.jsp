<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>

<style>
    body {
        background-color: #eaf2d7;
        
    }
    .container {
        margin-top: 50px;
    }

    .card-container {
        display: grid;
        
        grid-gap: 20px; 
        margin-top: 20px; 
    }

  .card {
    border: none;
    background: #f8f9fa;

    height: 5rem;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    margin-bottom: 20px;
    cursor: pointer;
}

    .card-body {
        padding: 20px;
    }

    .card-title {
        color:#363636;
        font-size: 24px;
        
        margin-bottom: 10px;
    }
    .card-text{
   	 font-size: 12px;
    }

    .btn-primary {
        background-color: #007bff;
        border: none;
    }

    .btn-primary:hover {
        background-color: #0056b3;
    }

    .pagination {
        margin-top: 20px;
    }

    .page-item.disabled .page-link {
        background-color: #f8f9fa;
        border-color: #dee2e6;
        color: #6c757d;
    }
    
    .page-item:not(.disabled) .page-link {
    background-color: #f8f9fa;
    border-color: #dee2e6;
    color: #C0D396; 
}
</style>

<script>
    // card-body 클릭 시 해당 URL로 이동하는 함수
    function redirectToBoard(boardId) {
        window.location.href = "/board/" + boardId;
    }
</script>

<div class="container">
    <div class="card-container">
        <c:forEach var="board" items="${boards.content}">
            <div class="card" onclick="redirectToBoard(${board.id})">
                <div class="card-body">
                    <h4 class="card-title">${board.title}</h4>
                    
                </div>
            </div>
        </c:forEach>
    </div>

    <ul class="pagination justify-content-center">
        <c:choose>
            <c:when test="${boards.first}">
                <li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${boards.last}">
                <li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>

<%@ include file="layout/footer.jsp" %>
