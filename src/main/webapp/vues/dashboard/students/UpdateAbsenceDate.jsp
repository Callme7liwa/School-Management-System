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
    <title>ADD FIELD</title>
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
                            <span> Update the absence was in ${date_absence} ${absence_hours} </span>
                        </div>
                    </div>
                    <form  method="post"  class="add-group_body">
                        <input type="number" value="<:out value=${modul_id} />" hidden/>
                        <input type="number" value="<:out value=${student_id} />" hidden/>
                        <div class="add-group-input-container">
                            <label> Modul Name</label>
                            <input type="text" name="modul_name" value="${modul_abbreviation}" placeholder="Speciality name here ... " disabled />
                        </div>
                        <div class="add-group-input-container">
                            <label> Absence Date ( the old -> ${date_absence} ) </label>
                            <input type="date" name="date"  placeholder="Date ... " value="'${date_absence}'" />
                        </div>
                        <div class="add-group-input-container">
                            <label> Hours Number </label>
                            <input type="text" name="absence_hours" " placeholder="hours" value="${absence_hours}"/>
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
