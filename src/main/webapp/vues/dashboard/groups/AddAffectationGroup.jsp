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
                        <span><img  srcset="${pageContext.request.contextPath}/static/images/studentIcon.png" width="50px"> </span>
                         <span> Add Modul to the group   </span>
                        </div>
                    </div>
                    <form action="${pageContext.request.contextPath}/groups" method="post" class="add-group_body">
                        <div class="add-group-input-container">
                            <label> Group Name</label>
                            <input type="text" name="group_abbreviation" value="<c:out value='${group_abbreviation} ${field_abbreviation}' /> "  disabled/>
                            <input type="text" name="group_id" value="<c:out value='${group_id}' />"  hidden/>
                            <input type="text" name="action" value="add_affectation" hidden />
                        </div>
                        <div class="add-group-input-container">
                            <label> Select Modul    </label>
                            <select  required  name="modul_id">
                                <c:forEach items="${moduls}" var="modul"   >
                                    <option class="professor-option" name="modul_id" value="<c:out value='${modul.modul_id}' />">  ${modul.modul_name} </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="add-group-input-container">
                            <label> Select Professor    </label>
                            <select  required  name="professor_id">
                                <c:forEach items="${professors}" var="professor"   >
                                    <option class="professor-option" name="professor_id" value="<c:out value='${professor.professor_id}' />">  ${professor.professor_name} </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="add-group-input-container">
                            <input type="submit" class="submit-add-group" value="submit" />
                        </div>
                    </form>
                </div>
              </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

