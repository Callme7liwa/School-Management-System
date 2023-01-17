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
    <title> ADD STUDENT TO THE GROUP </title>
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
                        <span><img  srcset="${pageContext.request.contextPath}/static/images/studentIcon.png" width="50px"> </span>
                         <span> Add student to the group   </span>
                        </div>
                    </div>
                    <div class="add-group_body">
                        <div class="add-group-input-container">
                        <label> Group Name</label>
                        <input type="text" name="group_name" value="<c:out value='${group_abbreviation}' />"  disabled/>
                        </div>
                        <div class="add-group-input-container">
                        <input type="text" name="group_name" value="<c:out value='${group_id}' />"  hidden/>
                        </div>
                        <div class="add-group-input-container">
                            <label> Select Student    </label>
                            <select  required  name="student_id">
                                <c:forEach items="${students}" var="student"   >
                                    <option name="student_id"  value="<c:out value='${student.student_id}' />"> ${student.student_name} </option>
                                </c:forEach>
                            </select>
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

