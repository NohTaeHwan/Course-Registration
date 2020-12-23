<%--
  Created by IntelliJ IDEA.
  User: taehwan
  Date: 2020-12-21
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
    <div class="jumbotron">
        <h1>교과목 추가</h1>
    </div>

    <sf:form id="addForm" method="post" modelAttribute="course">

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

        <input type="button" id="create_course" value="추가" class="btn btn-success">
        <a href="<c:url value="/admin/adminCourse"/>" class="btn btn-dark">취소</a>
    </sf:form>
</main>
<script src="<c:url value="/resources/js/ajax/adminCourseRouter.js?ver=1"/>"></script>
