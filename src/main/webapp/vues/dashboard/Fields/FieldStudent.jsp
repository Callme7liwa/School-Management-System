<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 12/11/2022
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Students of the field </title>
    <%@include file="../../includes/Header.jsp" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/3-dashboard.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/4-students.css"/>
</head>

<body>

<div class="page-acceuil-container">
    <div class="page-acceuil-content"> -->
        <!-- SIDE BARE HERE ...  -->
        <%@include file="../../includes/SideBar.jsp"%>
        <div class="acceuil-content_left">
            <!-- TOP BARE HERE  -->
            <%@include file="../../includes/Navbar.jsp"%>
            <div class="content-left_medium content-left_student" >
                <div class="medium-top">
                  <a href=""><i class="fa fa-search"></i></a>
                  <a href="${pageContext.request.contextPath}/create_student"><i class="fa fa-plus"></i></a>
                </div>
                <div class="medium-medium">
                  <c:forEach items="${students}" var="student">
                    <div class="card-student-container">
                      <div class="image-container">
                        <img srcset="${pageContext.request.contextPath}/static/images/abduh.png"/>
                      </div>
                      <div class="student-info">
                        <span>${student.student_name} Seddiki</span>
                        <span>${student.student_email}</span>
                      </div>
                      <div class="card-student-footer">
                       <a href="${pageContext.request.contextPath}/student?id=<c:out value='${student.student_id}' />" ><i class="fa fa-long-arrow-right"></i></a> 
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

