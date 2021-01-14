<%--
  Created by IntelliJ IDEA.
  User: taehwan
  Date: 2021-01-13
  Time: 01:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
    <div class="container">

        <div class="jumbotron">
            <h1>회원가입</h1>
            <p class="lead">회원 가입을 위한 정보를 입력하세요.</p>
        </div>

        <sf:form action="${pageContext.request.contextPath}/register"
                 method="post" modelAttribute="user">

            <div class="form-group">
                <label for="username">아이디</label>
                <span style="color:#ff0000">${usernameMsg}</span><!-- 아이디 중복 체크-->
                <sf:input path="username" id="username" class="form-control" style="width: 20%;"/>
                <sf:errors path="username" cssStyle="color: #ff0000"/>
            </div>

            <div class="form-group">
                <label for="password">비밀번호</label>
                <sf:password path="password" id="password" class="form-control" style="width: 20%;"/>
                <sf:errors path="password" cssStyle="color: #ff0000"/>
            </div>

            <!-- TODO 학과 , 학년 콤보박스 -->
            <br/>

            <input type="submit" value="submit" class="btn btn-primary">
            <a href="<c:url value="/"/>" class="btn btn-dark">Cancel</a>
        </sf:form>
        <br/>
    </div>
</main>