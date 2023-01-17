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
    <title> ADD PROFESSOR TO THE GROUP </title>
    <%@include file="../../includes/Header.jsp" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/3-dashboard.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/16-addStudentGroup.css"/>
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
                        <span><img  srcset="${pageContext.request.contextPath}/static/images/docIcon.png" width="50px"> </span>
                         <span> Add Document  to the group   </span>
                        </div>
                    </div>
                    <form method="post"  enctype="multipart/form-data" action="${pageContext.request.contextPath}/groups" class="add-group_body">
                        <div class="add-group-input-container">
                            <label> Group Name</label>
                            <%
                                String group_abbreviation= request.getParameter("group_abbreviation");
                                String field_abbreviation=request.getParameter("field_abbreviation");
                                String fullname = group_abbreviation + " => "+ field_abbreviation;
                            %>
                            <input type="text" name="group_fullName" value="<%= fullname %>"  disabled/>
                            <input type="text" name="group_abbreviation" value="<c:out value='${group_abbreviation}' />"  hidden/>
                            <input type="text" name="group_id" value="<c:out value='${group_id}' />"  hidden/>
                            <input type="text" name="action" value="upload_documents"  hidden/>
                        </div>
                        <div class="add-group-input-container">
                            <label> Select File   </label>
                            <input type="file" name="file"  />
                        </div>
                        <div class="add-group-input-container">
                            <label> File Name   </label>
                            <input type="text" name="file_name"  />
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
</div>

</body>
</html>

