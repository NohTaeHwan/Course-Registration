<%--
  Created by IntelliJ IDEA.
  User: taehwan
  Date: 2020-12-20
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">

    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h2>교과목 관리 페이지</h2>
    </div>
    <div class="table-responsive table-wrapper-scroll-y my-custom-scrollbar">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>연도</th>
                <th>학기</th>
                <th>학과</th>
                <th>학점</th>
                <th>과목명</th>
                <th>상세정보</th> <!-- TODO add btn : view details-->
            </tr>
            </thead>
            <tbody id="courses">

            </tbody>
        </table>
        <a href="<c:url value="/admin/addCourse"/>" class="btn btn-success">추가</a>
    </div>
</main>

<script src="<c:url value="/resources/js/ajax/adminCourseRouter.js?ver=2"/>"></script>
