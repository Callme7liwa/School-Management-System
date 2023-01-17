<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 13/11/2022
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title> Groups </title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/3-dashboard.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/10-specialities.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/24-professorGroups.css"/>
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
            <div class="acceuil-left_medium  acceuil-left_medium_specialitieScholar">
                <div class="page-title">
                    <div class="page-title_left">Differents Groups  in Ensias School</div>
                    <div class="page-title_right">
                        <a> <i class="fa fa-search"></i></a>
                        <a href="${pageContext.request.contextPath}/create_group"> <i class="fa fa-plus"></i></a>
                    </div>
                </div>
                <div class="list-moduls-professor">
                    <c:forEach items="${groups}" var="group">
                        <div class="item-modul-professor">
                            <div class="item-modul-header"></div>
                            <div class="item-modul-info">
                              <span class="item-modul-name">${group.group_name}</span>  
                              <div class="item-modul-abbreviationName"> <span>${group.group_abbreviation}</span>  </div>  
                            </div>
                            
                            <div class="item-field-info">
                              <span class="item-modul-fieldName">${group.field.field_name}~${group.group_year}</span>
                              <span class="item-modul-fieldAbbreviation"> ${group.group_creationDate} </span>
                            </div>
                            <div class="item-action">
                              <a href="${pageContext.request.contextPath}/group?group_id=<c:out value='${group.group_id}' />"> <i class="fa fa-arrow-right"></i> dive into  </a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
