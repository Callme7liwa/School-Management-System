<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 14/11/2022
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Group </title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/3-dashboard.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/11-addfield.css"/>
    <%@include file="../../includes/Header.jsp" %>
</head>
<body>


<div class="page-acceuil-container">
    <div class="page-acceuil-content"> -->
        <!-- SIDE BARE HERE ...  -->
        <%@include file="../../includes/SideBar.jsp"%>
        <div class="acceuil-content_left">
            <!-- TOP BARE HERE  -->
            <%@include file="../../includes/Navbar.jsp"%>
            <div class="content-left_medium content-add-group">
                <div class="add-group-container">
                    <div class="add-group_header">
                        <div>
                            <span> <img srcset="${pageContext.request.contextPath}/static/images/groupIcon2.png" width="50px"/></span>
                             <span> Update Modul </span>
                        </div>
                    </div>
                    <form  method="post" action="${pageContext.request.contextPath}/moduls" class="add-group_body">
                        <div class="add-group-input-container" hidden>
                            <label> Action </label>
                            <input type="text" name="action" value="update_modul" placeholder="Group name here ... " />
                        </div>
                        <div class="add-group-input-container">
                            <label> Modul Name </label>
                            <input type="text" name="modul_name" value="<c:out value='${modul.modul_name}' />" placeholder="Group name here ... " />
                        </div>
                        <div class="add-group-input-container">
                            <label> Modul Abbreviation</label>
                            <input type="text" name="modul_abbreviation" value="<c:out value='${modul.modul_abbreviation}' />" placeholder="Group Abbreviation here ... " />
                        </div>
                        <div class="add-group-input-container">
                            <label> Creation Date</label>
                            <fmt:formatDate value="${modul.modul_creationDate}" pattern="yyyy-MM-dd" var="formattedDate"/>
                            <input type="date" name="modul_creationDate" value="${formattedDate}"/>
                        </div>
                        <div class="add-group-input-container">
                            <input type="submit" class="submit-add-group" value="submit" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
