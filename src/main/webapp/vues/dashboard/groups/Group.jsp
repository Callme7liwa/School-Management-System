<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 14/11/2022
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Group Inforamtions </title>
    <%@include file="../../includes/Header.jsp" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/3-dashboard.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/14-groupInformation.css"/>
</head>
<body>


<div class="page-acceuil-container">
    <div class="page-acceuil-content"> -->
        <!-- SIDE BARE HERE ...  -->
        <%@include file="../../includes/SideBar.jsp"%>
        <div class="acceuil-content_left">
            <!-- TOP BARE HERE  -->
            <%@include file="../../includes/Navbar.jsp"%>
            <div class="content-left_medium_groupinfo">
                <div class="grp-info-left">
                    <div class="group-info-content">
                        <div class="group-info-content_header">
                            <!-- <div>${group.group_abbreviation}</div> -->
                            <div>
                                <div class="content-left">
                                    <img src="${pageContext.request.contextPath}/static/images/groupIcon.png" />
                                </div>
                                <div class="content-right"> ${group.group_abbreviation} </div>
                            </div>
                        </div>
                        <div class="group-info-content_body">
                            <span> ${field.field_abbreviation}  </span>
                            <span> ${group.group_year} </span>
                            <span> ${professorsNumber} professors </span>
                            <span> ${modulsNumber} moduls  </span>
                            <span> ${studentsNumber} students  </span>
                        </div>
                        <div class="group-info-content_footer">
                            <i class="fa fa-refresh"></i>
                        </div>
                    </div>
                </div>
                <div class="grp-info-right">
                     <div class="line-items">
                        <a class="add-item" href="${pageContext.request.contextPath}/group_addModul?group_id=<c:out value='${group.group_id}' />&&ga=<c:out value='${group.group_abbreviation}' />">
                            <div><img src="${pageContext.request.contextPath}/static/images/moduleIcon.png"  height="40px" width="40px"/></div>
                            <div> <span class="title-item">New Module </span></div>
                                <div><i class="fa fa-plus"></i></div>
                        </a>
                        <a class="add-item" href="${pageContext.request.contextPath}/group_addProfessor?group_id=<c:out value='${group.group_id}' />">
                            <div><img src="${pageContext.request.contextPath}/static/images/teacher.png" height="40px" width="40px"/></div>
                            <div> <span class="title-item">New Teacher </span></div>
                            <div><i class="fa fa-plus"></i></div>
                        </a>
                        <a class="add-item" href="${pageContext.request.contextPath}/group_addStudent?group_id=<c:out value='${group.group_id}' />">
                            <div><img src="${pageContext.request.contextPath}/static/images/studentIcon.png" height="40px" width="40px"/></div>
                            <div> <span class="title-item">New Student </span></div>
                            <div><i class="fa fa-plus"></i></div>
                        </a>
                        <a class="add-item" href="${pageContext.request.contextPath}/group_addDocuments?group_id=<c:out value='${group.group_id}'/>&&group_abbreviation=<c:out value='${group.group_abbreviation}' />&&field_abbreviation=<c:out value='${field.field_abbreviation}'/>">
                            <div><img src="${pageContext.request.contextPath}/static/images/docIcon.png" height="40px" width="40px"/></div>
                            <div> <span class="title-item">New Doc </span></div>
                            <div><i class="fa fa-plus"></i></div>
                        </a>
                        <a class="add-item" href="${pageContext.request.contextPath}/affectation_group_modul?group_id=<c:out value='${group.group_id}'/>&&group_abbreviation=<c:out value='${group.group_abbreviation}' />&&field_abbreviation=<c:out value='${field.field_abbreviation}'/>">
                            <div><img src="${pageContext.request.contextPath}/static/images/docIcon.png" height="40px" width="40px"/></div>
                            <div> <span class="title-item">Modul Affectation </span></div>
                            <div><i class="fa fa-plus"></i></div>
                        </a>
                    </div>
                    <div class="line-items">
                        <a class="add-item" href="${pageContext.request.contextPath}/group_moduls?group_id=<c:out value='${group.group_id}' />">
                            <div><img src="${pageContext.request.contextPath}/static/images/moduleIcon.png"  height="40px" width="40px"/></div>
                            <div> <span class="title-item">See Modules </span></div>
                            <div><i class="fa fa-eye"></i></div>
                        </a>
                        <a class="add-item" href="${pageContext.request.contextPath}/group_professors?group_id=<c:out value='${group.group_id}' />">
                            <div><img src="${pageContext.request.contextPath}/static/images/teacher.png" height="40px" width="40px"/></div>
                            <div> <span class="title-item">See Teachers </span></div>
                            <div><i class="fa fa-eye"></i></div>
                        </a>
                        <a class="add-item" href="${pageContext.request.contextPath}/group_students?group_id=<c:out value='${group.group_id}' />">
                            <div><img src="${pageContext.request.contextPath}/static/images/studentIcon.png" height="40px" width="40px"/></div>
                            <div> <span class="title-item">See Students </span></div>
                            <div><i class="fa fa-eye"></i></div>
                        </a>
                        <a class="add-item" href="${pageContext.request.contextPath}/group_documents?group_id=<c:out value='${group.group_id}' />">
                            <div><img src="${pageContext.request.contextPath}/static/images/docIcon.png" height="40px" width="40px"/></div>
                            <div> <span class="title-item">See docs </span></div>
                            <div><i class="fa fa-eye"></i></div>
                        </a>
                        <a class="add-item" href="${pageContext.request.contextPath}/getAffectation_moduls?group_id=<c:out value='${group.group_id}' />">
                            <div><img src="${pageContext.request.contextPath}/static/images/docIcon.png" height="40px" width="40px"/></div>
                            <div> <span class="title-item">See Affectation </span></div>
                            <div><i class="fa fa-eye"></i></div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



</body>
</html>
