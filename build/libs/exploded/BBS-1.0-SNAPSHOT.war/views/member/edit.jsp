<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="repository.MybatisBoardRepository" %>
<%@ page import="repository.MybatisMemberRepository" %>
<%@ page import="repository.MemberRepository" %>
<%@ page import="model.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String loginId = (String)session.getAttribute("loginId");
    MemberRepository memberRepository = new MybatisMemberRepository();
    Member searchedMember = memberRepository.findById(loginId);
    pageContext.setAttribute("member", searchedMember);
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

<div class="container-md">
    <main>
        <div class="py-5 text-center">
            <h2>회원 정보 수정</h2>
            <p class="lead">회원정보 수정 양식입니다.</p>
        </div>
        <form method="post" action="/member/edit?memberId=${member.memberId}">
            <div class="row mb-3">
<%--                <label for="inputEmail3" class="col-sm-2 col-form-label">아이디</label>--%>
                <div class="col-sm-6">
                    <input type="hidden" class="form-control" name="memberId">
                </div>
            </div>
            <div class="row mb-3">
                <label for="inputPassword3" class="col-sm-2 col-form-label">비밀번호</label>
                <div class="col-sm-6">
                    <input type="password" class="form-control" id="inputPassword3" name="memberPassword">
                </div>
            </div>
            <div class="row mb-3">
                <label for="inputPassword3" class="col-sm-2 col-form-label">이름</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="memberName" value="${member.memberName}">
                </div>
            </div>
            <div class="row mb-3">
                <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm-6">
                    <input type="email" class="form-control" id="inputEmail3" name="memberEmail" value="${member.memberEmail}">
                </div>
            </div>
            <fieldset class="row mb-3">
                <legend class="col-form-label col-sm-2 pt-0">성별</legend>
                <div class="col-sm-10">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="memberGender" id="gridRadios1" value="남자"
                               ${member.memberGender eq "남자" ? "checked": ""}>
                        <label class="form-check-label" for="gridRadios1">
                            남자
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="memberGender" id="gridRadios2" value="여자" ${member.memberGender eq "여자" ? "checked": ""}>
                        <label class="form-check-label" for="gridRadios2">
                            여자
                        </label>
                    </div>
                </div>
            </fieldset>
            <button type="submit" class="btn btn-primary">정보 수정</button>
            <button type="button" class="btn btn-primary" onclick="
                    if (confirm(`정말로 ${member.memberId} 를 탈퇴하시겠습니까?`)){ location.href=`/member/withdraw?memberId=${member.memberId}` } else {}
                    ">회원 탈퇴</button>
        </form>
    </main>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
