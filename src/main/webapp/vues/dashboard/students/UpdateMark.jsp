<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 13/11/2022
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> UPDATE MARK  </title>
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/3-dashboard.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/11-addfield.css"/>
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
                            <span> Add Absence  </span>
                        </div>
                    </div>
                    <form  method="post" action="${pageContext.request.contextPath}/students" class="add-group_body">
                        <input type="text" name="action" value="update_mark" hidden/>
                        <input type="text" name="student_id" value="${mark.student_id}"  hidden/>
                        <input type="text" name="modul_id" value="${mark.modul_id}" hidden/>
                        <div class="add-group-input-container">
                            <label> mark Name</label>
                            <input type="text" name="modul_name" value="${mark.modul_abbreviation}" placeholder="Speciality name here ... " disabled />
                        </div>
                        <div class="add-group-input-container">
                            <label>  Mark </label>
                            <input type="text" name="modul_mark" value="${mark.modul_mark}" placeholder="mark of the modul" > 
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
