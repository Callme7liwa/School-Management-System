<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 13/11/2022
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>UPDATE FIELD</title>
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
            <div class="content-left_medium  content-add-group">
                <div class="add-group-container">
                    <div class="add-group_header">
                        <div>
                            <span> <img srcset="${pageContext.request.contextPath}/static/images/filiereIcon.png" width="50px"/></span>
                            <span> Update  ${field.field_name}</span>
                        </div>
                    </div>
                    <div class="add-group_body">
                        <input type="number" value='${field.field_id}' hidden/>
                        <div class="add-group-input-container">
                            <label> Speciality Name</label>
                            <input type="text" name="name" placeholder="Speciality name here ... " value='${field.field_name}'/>
                        </div>
                        <div class="add-group-input-container">
                            <label> Speciality Abbreviation</label>
                            <input type="text" name="abbreviation" placeholder="Speciality Abbreviation name here ... "  value='${field.field_abbreviation}' />
                        </div>
                        <div class="add-group-input-container">
                            <label> Creation Date</label>
                            <fmt:formatDate value="${field.field_creationDate}" pattern="yyyy-MM-dd" var="formattedDate"/>
                            <input type="date" name="creationDate" placeholder="Speaciality Creation date ... " value="${formattedDate}"/>
                        </div>
                        <div class="add-group-input-container">
                            <label> Description</label>
                            <textarea name="description" > ${field.field_description} </textarea>
                        </div>
                        <div class="add-group-input-container">
                            <input type="submit" class="submit-add-group" value="submit" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
