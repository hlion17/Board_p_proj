<%@ page import="model.Board" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="deleteResult" value="${requestScope.deleteResult}"/>
<c:if test="${deleteResult eq '1'}">
    <script>
        alert('삭제가 완료되었습니다.')
    </script>
</c:if>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>MyProject</title>
</head>
<body>
<%--네비게이션 바--%>
<header>
    <%@ include file="/views/include/navbar.jsp" %>
</header>

<%--본문 내용--%>
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
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1"
                                data-bs-toggle="dropdown" aria-expanded="false">
                            게시물 수
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                            <li><a class="dropdown-item" href="#">미완성</a></li>
                            <li><a class="dropdown-item" href="#">10개씩 보기</a></li>
                            <li><a class="dropdown-item" href="#">5개씩 보기</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <%--테이블--%>
            <table class="table table-hover">
                <thead>
                <tr class="text-center">
                    <th scope="col" colspan="1">번호</th>
                    <th scope="col" colspan="5">게시글</th>
                    <th scope="col" colspan="2">작성자</th>
                    <th scope="col" colspan="2">등록일</th>
                    <th scope="col" colspan="1">추천</th>
                    <th scope="col" colspan="1">조회</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="board" items="${boards}">
                    <c:if test="${board.boardAvailable == 1}">
                        <tr>
                            <th scope="row" colspan="1" class="text-center">${board.boardId}</th>
                            <td colspan="5" class="text-left">
<%--                                <a style="text-decoration: none; color: #0f0f0f"--%>
<%--                                   href="/views/board/board-content(backup).jsp?boardId=${board.boardId}&curPage=${requestScope.pagination.curPage}">${board.boardTitle}</a>--%>
                                <%--현재 페이지의 request 정보를 어떻게 넘기지?--%>
                                    <a style="text-decoration: none; color: #0f0f0f"
                                   href="/board/post?boardId=${board.boardId}&curPage=${requestScope.pagination.curPage}">${board.boardTitle}</a>
                            </td>
                            <td colspan="2" class="text-center">${board.memberId}</td>
                            <td colspan="2" class="text-center">${board.boardDate}</td>
                            <td colspan="1" class="text-center">11</td>
                            <td colspan="1" class="text-center">22</td>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>

            <%--          이동 버튼      --%>
            <div class="row">
                <div class="col-2 justify-content-start btn-group" role="group" aria-label="Basic outlined example">
                    <c:if test="${requestScope.pagination.curPage ne 1 && requestScope.pagination.curPage > 0}">
                        <a class="btn btn-outline-primary"
                           href="/board/list?curPage=${requestScope.pagination.prevPage}">이전</a>
                    </c:if>
                    <c:if test="${requestScope.pagination.curPage ne requestScope.pagination.pageCnt && requestScope.pagination.curPage > 0}">
                        <a class="btn btn-outline-primary"
                           href="/board/list?curPage=${requestScope.pagination.nextPage}">다음</a>
                    </c:if>
                </div>
                <c:if test="${sessionScope.loginId != null}">
                    <div class="col-1 ms-auto">
                        <a class="btn btn-outline-primary"
                           href="/views/board/board-write.jsp?loginId=${sessionScope.loginId}&curPage=${requestScope.pagination.curPage}">글쓰기</a>
                    </div>
                </c:if>
            </div>

            <%--페이지네이션--%>
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <nav class="col-4" aria-label="Page navigation example">
                        <ul class="pagination">
                            <c:if test="${requestScope.pagination.curPage ne 1 && requestScope.pagination.curPage > 0}">
                                <li class="page-item">
                                    <a class="page-link" href="/board/list?curPage=${requestScope.pagination.prevPage}"
                                       aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:forEach var="pageNum" begin="${requestScope.pagination.startPage}"
                                       end="${requestScope.pagination.endPage}">
                                <c:choose>
                                    <c:when test="${pageNum eq requestScope.pagination.curPage}">
                                        <li class="page-item active" aria-current="page">
                                            <a class="page-link" href="#">${pageNum}</a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="page-item"><a class="page-link"
                                                                 href="/board/list?curPage=${pageNum}">${pageNum}</a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            <c:if test="${requestScope.pagination.curPage ne requestScope.pagination.pageCnt && requestScope.pagination.curPage > 0}">
                                <li class="page-item">
                                    <a class="page-link" href="/board/list?curPage=${requestScope.pagination.nextPage}"
                                       aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
            </div>

        </main>

    </div>
</div>

<%--<%@ include file="/views/include/footer.jsp" %>--%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
