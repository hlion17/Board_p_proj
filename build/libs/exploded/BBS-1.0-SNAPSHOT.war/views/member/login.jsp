<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>MyProject</title>
</head>
<body>
<section>
    <c:if test="${requestScope.loginResult eq '-1'}">
        <script>
            alert(`아이디가 없습니다.`)
        </script>
    </c:if>
    <c:if test="${requestScope.loginResult eq '0'}">
        <script>
            alert(`비밀번호가 틀렸습니다.`)
        </script>
    </c:if>
</section>

<%@ include file="/views/include/navbar.jsp" %>

<main>

    <div class="modal modal-signin position-static d-block bg-secondary py-5" tabindex="-1" role="dialog"
         id="modalSignin">
        <div class="modal-dialog" role="document">
            <div class="modal-content rounded-5 shadow">
                <div class="modal-header p-5 pb-4 border-bottom-0">
                    <!-- <h5 class="modal-title">Modal title</h5> -->
                    <h2 class="fw-bold mb-0">로그인</h2>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"
                            onclick="location.href='/home';"></button>
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

    <!-- FOOTER -->
    <footer class="container">
        <p class="float-end"><a href="#">Back to top</a></p>
        <p>&copy; 2017–2021 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
    </footer>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
