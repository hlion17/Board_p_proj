<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">MyProject</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/board/list">게시판</a>
                </li>

            <%
                if (session.getAttribute("loginId") != null) {
            %>
                <li class="nav-item">
                    <a class="nav-link" href="/member/logout">로그아웃</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/views/member/edit.jsp">정보수정</a>
                </li>
            <%
                } else {
            %>
                <li class="nav-item">
<%--                    <a class="nav-link" href="/views/member/login.jsp">로그인</a>--%>
                    <a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#login" style="cursor: pointer;">로그인</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/views/member/join.jsp">회원가입</a>
                </li>
            <%
                }
            %>


            </ul>
        </div>
    </div>
</nav>

<%--로그인 모달--%>
<div class="modal fade" id="login" tabindex="-1" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content rounded-5 shadow">
            <div class="modal-header p-5 pb-4 border-bottom-0">
                <!-- <h5 class="modal-title">Modal title</h5> -->
                <h2 class="fw-bold mb-0">로그인</h2>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <div class="modal-body p-5 pt-0">
                <form class="" method="post" action="/login">
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control rounded-4" id="floatingInput" name="memberId"
                               placeholder="아이디">
                        <label for="floatingInput">아이디</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="password" class="form-control rounded-4" id="floatingPassword"
                               name="memberPassword" placeholder="비밀번호">
                        <label for="floatingPassword">비밀번호</label>
                    </div>
                    <button class="w-100 mb-2 btn btn-lg rounded-4 btn-primary" type="submit">로그인</button>
                    <a class="w-100 mb-2 btn btn-lg rounded-4 btn-primary" href="/views/member/join.jsp">회원가입</a>
                    <small class="text-muted">By clicking Sign up, you agree to the terms of use.</small>
                    <hr class="my-4">
                    <h2 class="fs-5 fw-bold mb-3">다른 사이트를 이용해서 회원가입</h2>
                    <button class="w-100 py-2 mb-2 btn btn-outline-dark rounded-4" type="submit">
                        <svg class="bi me-1" width="16" height="16">
                            <use xlink:href="#twitter"/>
                        </svg>
                        Sign up with Twitter
                    </button>
                    <button class="w-100 py-2 mb-2 btn btn-outline-primary rounded-4" type="submit">
                        <svg class="bi me-1" width="16" height="16">
                            <use xlink:href="#facebook"/>
                        </svg>
                        Sign up with Facebook
                    </button>
                    <button class="w-100 py-2 mb-2 btn btn-outline-secondary rounded-4" type="submit">
                        <svg class="bi me-1" width="16" height="16">
                            <use xlink:href="#github"/>
                        </svg>
                        Sign up with GitHub
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>