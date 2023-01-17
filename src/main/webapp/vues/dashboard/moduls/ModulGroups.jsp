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
    <title>All groups of the modul </title>
    <%@include file="../../includes/Header.jsp" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/3-dashboard.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/7-personalInfomation.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/21-modulGroups.css"/>
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
              <div class="content-personal-information_header"><span>ALL GROUPS </span></div>
              <div class="content-personal-information_body" >
                <div class="body_header">Groups studing  <c:out value="${modulGroups.modul_name}" /> </div>
                <div class="list-group">
                  <c:forEach items="${modulGroups.groups}" var="group" varStatus="status" >
                    <div class="item-group">
                        <span class="group-number"> ${status.index} </span>
                        <span class="group-abbreviation"> ${group.group_abbreviation}</span>
                        <span class="groupField-name"> ${group.group_fieldAbbreviation} </span>
                        <a class="group-action">Dive into <i class="fa fa-arrow-right"></i></a> 
                    </div>
                  </c:forEach>
                </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
