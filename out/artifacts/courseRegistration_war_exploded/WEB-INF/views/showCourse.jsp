<%--
  Created by IntelliJ IDEA.
  User: taehwan
  Date: 2020-12-02
  Time: 00:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">

    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">교과목 조회</h1>

        <form class="form-inline">
            <div class="form-group" style="margin-right: 30px;">
                년도 :   
                <select class="selectpicker" >
                    <option>Mustard</option>
                    <option>Ketchup</option>
                    <option>Relish</option>
                </select>
            </div>

            <div class="form-group" style="margin-right: 30px;">
                학기 :
                <select class="selectpicker">
                    <option>Mustard</option>
                    <option>Ketchup</option>
                    <option>Relish</option>
                </select>
            </div>

            <div class="form-group" style="margin-right: 30px;">
                과목명 :
                <select class="selectpicker">
                    <option>Mustard</option>
                    <option>Ketchup</option>
                    <option>Relish</option>
                </select>
            </div>

        </form>
    </div>
</main>