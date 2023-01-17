<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 11/11/2022
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/3-dashboard.css"/>
    <%@include file="../includes/Header.jsp" %>
</head>
<body>

<div class="page-acceuil-container">
    <div class="page-acceuil-content"> -->
        <!-- SIDE BARE HERE ...  -->
        <%@include file="../includes/SideBar.jsp"%>
        <div class="acceuil-content_left">
            <!-- TOP BARE HERE  -->
            <%@include file="../includes/Navbar.jsp"%>
            <div class="content-left_medium" >
                <div class="items-dashboard-container">
                        <div class="item-dashboard-container">
                            <div class="item-image-container">
                                <img srcset="${pageContext.request.contextPath}/static/images/studentIcon.png" />
                            </div>
                            <div class="item-info">
                                <span> The school contains 21 students </span>
                            </div>
                            <a href="${pageContext.request.contextPath}/students" class="item-action"><i class="fa fa-long-arrow-right "></i></a>
                        </div>
                        <div class="item-dashboard-container">
                            <div class="item-image-container">
                                <img srcset="${pageContext.request.contextPath}/static/images/teacher.png"/>
                            </div>
                            <div class="item-info">
                                <span> The school contains 21 teachers </span>
                            </div>
                            <a href="${pageContext.request.contextPath}/professors" class="item-action"><i class="fa fa-long-arrow-right "></i></a>
                        </div>
                        <div class="item-dashboard-container">
                            <div class="item-image-container">
                                <img  srcset="${pageContext.request.contextPath}/static/images/filiereIcon.png" />
                            </div>
                            <div class="item-info">
                                <span> The school contains 21 fields </span>
                            </div>
                            <a href="${pageContext.request.contextPath}/fields" class="item-action"><i class="fa fa-long-arrow-right "></i></a>
                        </div>
                        <div class="item-dashboard-container">
                            <div class="item-image-container">
                                <img  srcset="${pageContext.request.contextPath}/static/images/classesIcon.png"/>
                            </div>
                            <div class="item-info">
                                <span> The school contains 21 levels </span>
                            </div>
                            <a href="${pageContext.request.contextPath}/levels" class="item-action"><i class="fa fa-long-arrow-right "></i></a>
                        </div>
                        <div class="item-dashboard-container">
                            <div class="item-image-container">
                                <img srcset="${pageContext.request.contextPath}/static/images/moduleIcon.png"/>
                            </div>
                            <div class="item-info">
                                <span> The school contains 21 Modules </span>
                            </div>
                            <a href="${pageContext.request.contextPath}/moduls" class="item-action"><i class="fa fa-long-arrow-right "></i></a>
                        </div>
                        <div class="item-dashboard-container">
                            <div class="item-image-container">
                                <img srcset="${pageContext.request.contextPath}/static/images/groupIcon2.png"/>
                            </div>
                            <div class="item-info">
                                <span> The school contains 21 Groups </span>
                            </div>
                            <a href="${pageContext.request.contextPath}/groups" class="item-action"><i class="fa fa-long-arrow-right "></i></a>
                        </div>
                        <div class="item-dashboard-container">
                            <div class="item-image-container">
                                <img srcset="${pageContext.request.contextPath}/static/images/groupIcon2.png"/>
                            </div>
                            <div class="item-info">
                                <span> The school contains 21 Groups </span>
                            </div>
                            <a href="${pageContext.request.contextPath}/groups" class="item-action"><i class="fa fa-long-arrow-right "></i></a>
                        </div>
                        <div class="item-dashboard-container">
                            <div class="item-image-container">
                                <img srcset="${pageContext.request.contextPath}/static/images/iconEvent.png"/>
                            </div>
                            <div class="item-info">
                                <span> Events </span>
                            </div>
                            <a href="${pageContext.request.contextPath}/events" class="item-action"><i class="fa fa-long-arrow-right "></i></a>
                        </div>
                    </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
