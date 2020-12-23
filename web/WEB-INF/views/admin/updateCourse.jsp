<%--
  Created by IntelliJ IDEA.
  User: taehwan
  Date: 2020-12-23
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
    <div class="jumbotron">
        <h1>교과목 수정</h1>
    </div>

    <sf:form id="addForm" method="put" modelAttribute="course">

        <!-- update 시에는 id값을 따로 바인딩해줘야함.그래야 맞는 id로 update가능 -->
        <sf:hidden path="code"/>

        <div class="form-group">
            <label for="year">연도 </label>
            <sf:input path="year" id="year" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="semester">학기 </label>
            <sf:input path="semester" id="semester" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="division">학과 </label>
            <sf:input path="division" id="division" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="credit">학점 </label>
            <sf:input path="credit" id="credit" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="subject">과목명 </label>
            <sf:input path="subject" id="subject" class="form-control"/>
        </div>

        <input type="button" id="update_course" value="수정" class="btn btn-success">
        <a href="<c:url value="/admin/adminCourse"/>" class="btn btn-dark">취소</a>
    </sf:form>
</main>
<script src="<c:url value="/resources/js/ajax/adminCourseRouter.js"/>"></script>
