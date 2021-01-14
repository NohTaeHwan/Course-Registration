<%--
  Created by IntelliJ IDEA.
  User: taehwan
  Date: 2021-01-13
  Time: 00:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">

    <div class="jumbotron">
        <h2>로그인</h2>
    </div>

    <c:if test="${not empty errorMsg}">
        <div style="color: red;"><h3>${errorMsg}</h3></div>
    </c:if>

    <c:if test="${not empty logoutMsg}">
        <div style="color: blue;"><h3>${logoutMsg}</h3></div>
    </c:if>

    <form action="<c:url value="/login"/>" method="post">
        <div class="form-group">
            <label for="username">아이디</label>
            <input type="text" class="form-control" id="username" placeholder="Enter username" name="username" style="width: 20%">
        </div>

        <div class="form-group">
            <label for="pwd">비밀번호</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password" style="width: 20%">
        </div>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <button type="submit" class="btn btn-primary">Sign in</button>
        <a href="<c:url value="/"/>" class="btn btn-dark">Cancel</a>
    </form>


</main>