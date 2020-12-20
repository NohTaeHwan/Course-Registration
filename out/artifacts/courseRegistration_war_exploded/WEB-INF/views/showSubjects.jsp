<%--
  Created by IntelliJ IDEA.
  User: taehwan
  Date: 2020-12-02
  Time: 00:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">

    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">교과목 조회</h1>

        <!-- 후에 spring form으로 변경할 계획 -->
        <sf:form class="form-inline" id="search_form" modelAttribute="course">
            <div class="form-group">
                년도 :
                <sf:select path="year" class="selectpicker">
                    <option value="NONE">선택해주세요 </option>
                    <c:forEach var="element" items="${years}">
                        <sf:option value="${element}"/>
                    </c:forEach>
                </sf:select>
            </div>

            <div class="form-group">
                학기 :
                <sf:select path="semester" class="selectpicker">
                    <option value="NONE">선택해주세요 </option>
                    <c:forEach var="element" items="${semesters}">
                        <sf:option value="${element}"/>
                    </c:forEach>
                </sf:select>
            </div>

            <div class="form-group">
                학과 :
                <sf:select path="division" class="selectpicker">
                    <option value="NONE">선택해주세요</option>
                    <c:forEach var="element" items="${divisions}">
                        <sf:option value="${element}"/>
                    </c:forEach>
                </sf:select>
            </div>

            <div class="form-group">
                <input type="button" class="btn btn-primary" id="search_subject_btn" value="조회"/>
            </div>

        </sf:form>

        <!-- TODO 직접 입력해서 원하는 교과목 조회 drop button
        <div class="dropdown">
            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                직접 입력
            </button>
            <div class="dropdown-menu">
                <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
                <button class="btn btn-primary" style="float: right;">검색</button>
            </div>
        </div>
        -->
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
    </div>
</main>

<script src="<c:url value="/resources/js/ajax/showSubjectRouter.js?ver=2"/>"></script>
