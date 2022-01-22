<%@ page import="java.util.Enumeration" %>
<%@ page import="repository.MybatisBoardRepository" %>
<%@ page import="model.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MybatisBoardRepository boardRepository = new MybatisBoardRepository();
    int boardId = Integer.parseInt(request.getParameter("boardId"));
    Board searchedBoard = boardRepository.findById(boardId);
    pageContext.setAttribute("searchedBoard", searchedBoard);
%>


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
        <%@ include file="/views/include/sideMenu.jsp"%>

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

            <%--작성창--%>
            <form method="post" action="/board/update">
                <input type="hidden" name="boardId" value="${pageScope.searchedBoard.boardId}">
                <div class="row">
                    <div class="col-lg-5">
                        <label for="writeTitle" class="form-label">글 제목</label>
                        <input type="text" class="form-control" id="writeTitle" name="boardTitle"
                               placeholder="글제목" value="${pageScope.searchedBoard.boardTitle}">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-8">
                        <label for="writeContent" class="form-label">글 내용</label>
                        <textarea class="form-control" id="writeContent" rows="6" name="boardContent">${pageScope.searchedBoard.boardContent}</textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="col-1 justify-content-start btn-group" role="group" aria-label="Basic outlined example">
                        <button type="submit" class="btn btn-outline-primary">수정</button>
                    </div>
                </div>
            </form>

        </main>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
