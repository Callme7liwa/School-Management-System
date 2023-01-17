<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 13/11/2022
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Professors</title>
    <%@include file="../../includes/Header.jsp" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/3-dashboard.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/7-personalInfomation.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/22-modulProfessors.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/23-GroupModuls.css"/>
</head>
<body>

  <div class="page-acceuil-container">
    <div class="page-acceuil-content"> -->
        <!-- SIDE BARE HERE ...  -->
        <%@include file="../../includes/SideBar.jsp"%>
        <div class="acceuil-content_left">
            <!-- TOP BARE HERE  -->
            <%@include file="../../includes/Navbar.jsp"%>
            <div class="content-left_medium content-personal-information"  >
                <div class="content-personal-information_header"><span>All Moduls</span></div>
                <div class="content-personal-information_body" >
                    <div class="body_header"> Moduls covered by <c:out value="${professor_name}${professor_secondName}" /> </div>
                    <div class="list-professors">
                        <c:forEach items="${moduls}" var="modul" varStatus="status" >
                            <a class="item-professor-modul">
                                <span class="item-number"> ${status.index}</span>
                                <div class="professor-information">
                                    <span>  ${modul.modul_abbreviation} </span>
                                    <span> ${modul.modul_name} </span>
                                </div>
                                <i class="fa fa-long-arrow-right"></i> 
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
