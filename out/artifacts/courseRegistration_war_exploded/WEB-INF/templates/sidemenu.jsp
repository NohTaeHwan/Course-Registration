<%--
  Created by IntelliJ IDEA.
  User: taehwan
  Date: 2020-12-01
  Time: 00:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
    <div class="sidebar-sticky pt-3">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/"/>">
                    <span data-feather="home"></span>
                    Home <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/showSubjects"/>">
                    <span data-feather="file"></span>
                    교과목 조회
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/test"/>">
                    <span data-feather="shopping-cart"></span>
                    수강신청 장바구니
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="#">
                    <span data-feather="users"></span>
                    수강 신청한 과목
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <span data-feather="bar-chart-2"></span>
                    Reports
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <span data-feather="layers"></span>
                    Integrations
                </a>
            </li>

            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/register"/>">
                        <span data-feather="users"></span>
                        회원 가입
                    </a>
                </li>
            </c:if>

        </ul>

        <!-- admin menu -->
        <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
            <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                <span>관리자 페이지</span>
                <!--
                <a class="d-flex align-items-center text-muted" href="#" aria-label="Add a new report">
                    <span data-feather="plus-circle"></span>
                </a> -->
            </h6>
            <ul class="nav flex-column mb-2">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/admin/adminCourse"/>">
                        <span data-feather="file-text"></span>
                        교과목 관리
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <span data-feather="users"></span>
                        유저 관리
                    </a>
                </li>
            </ul>
        </c:if>



    </div>
</nav>