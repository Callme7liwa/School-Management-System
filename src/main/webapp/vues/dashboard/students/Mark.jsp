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
    <title>Title</title>
    <%@include file="../../includes/Header.jsp" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/3-dashboard.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/9-marks.css"/>
</head>

<body>
<div class="page-acceuil-container">
    <div class="page-acceuil-content"> -->
        <!-- SIDE BARE HERE ...  -->
        <%@include file="../../includes/SideBar.jsp"%>
        <div class="acceuil-content_left content-marks">
            <!-- TOP BARE HERE  -->
            <%@include file="../../includes/Navbar.jsp"%>
            <div class="content-left_medium ">
                <div class="students-years">
                    <c:forEach items="${years}" var="year">
                      <span><a class="student-year"> ${year} </a></span>
                    </c:forEach>
                </div>
                <div class="note-items">
                    <c:forEach items="${marks}" var="mark">
                        <div class="note-item">
                            <span class="note-item-name-image"> ${mark.modul_abbreviation} </span>
                            <span class="note-item-name-text"> ${mark.modul_name} </span>
                            <span class="note-item-value"> ${mark.mark} / 20 </span>
                            <span class="note-item-actions">
                                <a href="${pageContext.request.contextPath}/editMark_modul?student_id=<c:out value='${mark.student_id}' />&modul_id=<c:out value='${mark.modul_id}' />&modul_mark=<c:out value='${mark.mark}'/>&modul_abbreviation=<c:out value='${mark.modul_abbreviation}'/>"> 
                                   <i class="fa fa-refresh"></i> 
                                </a>
                                <a><i class="fa fa-times"></i></a>
                            </span>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

