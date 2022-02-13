<%@ page import="model.Board" %>
<%@ page import="repository.MybatisBoardRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>MyProject</title>
</head>
<body>
<header>
    <%@ include file="/views/include/navbar.jsp" %>
</header>

<div class="container-fluid">
    <div class="row">
        <%@ include file="/views/include/sideMenu.jsp" %>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">게시판1</h1>
                <div class="btn-toolbar mb-2 mb-md-0">
                    <div class="btn-group me-2">
                        <button type="button" class="btn btn-sm btn-outline-secondary">버튼1</button>
                        <button type="button" class="btn btn-sm btn-outline-secondary">버튼2</button>
                    </div>
                    <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
                        <span data-feather="calendar"></span>
                        토글 버튼
                    </button>
                </div>
            </div>

            <%--Content--%>
            <div class="container-fluid">

                <table class="table">
                    <thead class="table-light">
                    <tr>
                        <th scope="col" class="text-center" style="width: 200px;">글 제목</th>
                        <th scope="col" class="text-left">${board.boardTitle}</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row" colspan="1" class="text-center" style="width: 200px;">글 내용</th>
                        <td colspan="4" class="text-left">${board.boardContent}</td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <%--댓글 구현--%>
            <div class="container-fluid">
                <table class="table">
                    <c:if test="${sessionScope.loginId ne null}">
                    <c:forEach var="comment" items="${comments}">
                        <c:if test="${comment.deleteAt eq 1}">
                        <tbody class="table-light">
                        <tr>
                            <td class="text-center" style="width: 200px;">${comment.writer}</td>
                            <td colspan="4" class="text-left">${comment.content}</td>
                            <td class="text-left"><fmt:formatDate value="${comment.createDate}" pattern="yyyy/MM/dd HH:mm"/></td>
                        </tr>
                        </tbody>
                        </c:if>
                    </c:forEach>
                    </c:if>
                </table>

                <div class="container-fluid">
                    <form class="row g-3" action="/comment/write" method="post">
                        <div class="col-auto"><textarea class="form-control" name="content" cols="50" rows="3" style="resize: none;" placeholder="댓글을 입력하세요."></textarea></div>
                        <div class="col-auto"><input class="btn btn-primary" type="submit"></div>

                        <input type="text" name="boardId" hidden value="${board.boardId}">
                        <input type="text" name="curPage" hidden value="${pagination.curPage}">
                        <input type="text" name="writer" hidden value="${sessionScope.loginId}">
                    </form>
                </div>
            </div>
            <%--댓글 구현 끝--%>

            <div class="row">
                <div class="col-1 justify-content-start btn-group" role="group" aria-label="Basic outlined example">
                    <a class="btn btn-primary" href="/board/list?curPage=${pagination.curPage}">목록으로</a>
                </div>

                <c:if test="${sessionScope.loginId eq board.memberId}">
                    <div class="col-1 justify-content-start btn-group" role="group" aria-label="Basic outlined example">
                        <a class="btn btn-outline-primary" href="/views/board/board-update.jsp?boardId=${board.boardId}">수정</a>
                    </div>
                    <div class="col-1 justify-content-start btn-group" role="group" aria-label="Basic outlined example">
                        <a class="btn btn-outline-primary" href="/board/delete?boardId=${board.boardId}">삭제</a>
                    </div>
                </c:if>

            </div>

        </main>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>

