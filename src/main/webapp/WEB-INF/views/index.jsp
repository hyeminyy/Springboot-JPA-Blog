<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>

<style>
    .container {
        margin-top: 50px;
    }

    .card-container {
        display: grid;
        grid-template-columns: repeat(3, 1fr); /* 가로 3개의 카드 정렬 */
        grid-gap: 20px; /* 카드 간격 */
        margin-top: 20px; /* 부모 컨테이너 상단 간격 */
    }

    .card {
        border: none;
        background: #f8f9fa;
        width: 14rem;
        height: 20rem;
        box-shadow: 0px 0px 20px 0px rgba(0, 0, 0, 0.2);
        margin-bottom: 20px;
        cursor: pointer; /* 커서를 포인터로 변경하여 클릭 가능함을 나타냄 */
    }

    .card-body {
        padding: 20px;
    }

    .card-title {
        color: #007bff;
        font-size: 24px;
        margin-bottom: 10px;
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
                    <!-- 버튼을 클릭하는 대신 card-body를 클릭하면 redirectToBoard 함수가 호출됩니다. -->
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
