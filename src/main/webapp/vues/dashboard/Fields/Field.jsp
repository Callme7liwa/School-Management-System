<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 13/11/2022
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Field Information </title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/3-dashboard.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/12-informationField.css"/>
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
                <div class="field-container">
                    <div class="field-content">
                        <div class="field-content_header">
                            <img srcset="${pageContext.request.contextPath}/static/images/filiereIcon.png"/>
                            <span> ${fieldInfo.field.field_name} </span>
                        </div>
                        <div class="field-content_body">
                            <div class="content-body-item">
                                <div> Abbreviation   </div>
                                <div> <span>${fieldInfo.field.field_abbreviation} </span></div>
                            </div>
                            <div class="content-body-item">
                                <div> Students </div>
                                <div> <a href="${pageContext.request.contextPath}/field_students?field_id=<c:out value='${fieldInfo.field.field_id}' />" class="item-field-action"> <span>${fieldInfo.student_number}</span>    <i class="fa fa-chevron-circle-right"></i></a></div>
                            </div>
                            <div class="content-body-item"> 
                                <div> Groups </div>
                                <div> <a href="${pageContext.request.contextPath}/field_groups?field_id=<c:out value='${fieldInfo.field.field_id}' />" class="item-field-action"> <span>${fieldInfo.group_number}  </span> <i class="fa fa-chevron-circle-right"></i></a></div>
                            </div>
                            <div class="content-body-item">
                                <div> Creation Date   </div>
                                <div>  20/11/2022   </div>
                            </div>

                        </div>
                        <div class="field-content_footer">
                            <a href="${pageContext.request.contextPath}/edit_field?field_id=<c:out value='${fieldInfo.field.field_id}'/>"> <i class="fa fa-refresh"></i> </a>
                        </div>
                    </div>
                </div>
            </div>
    </div>
</div>

</body>
</html>
