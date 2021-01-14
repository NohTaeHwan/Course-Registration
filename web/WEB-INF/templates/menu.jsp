<%--
  Created by IntelliJ IDEA.
  User: taehwan
  Date: 2020-12-01
  Time: 00:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="<c:url value="/"/>">수강 신청</a>
    <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse" data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <!--<input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">-->
    <ul class="navbar-nav px-3">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <li class="nav-item text-nowrap">
                <a class="py-2 d-none d-md-inline-block"
                   href="javascript:document.getElementById('logout').submit()">Logout</a>
            </li>

            <form id="logout" action="<c:url value="/logout"/>" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </c:if>

        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <li class="nav-item text-nowrap">
                <a class="nav-link" href="<c:url value="/login"/>">Sign in</a>
            </li>
        </c:if>
    </ul>
</nav>