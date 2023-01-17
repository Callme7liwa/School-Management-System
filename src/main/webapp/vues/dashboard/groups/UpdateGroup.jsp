<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 14/11/2022
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Group </title>
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
            <div class="content-left_medium content-add-group">
                <div class="add-group-container">
                    <div class="add-group_header">
                        <div>
                            <span> <img srcset="${pageContext.request.contextPath}/static/images/groupIcon2.png" width="50px"/></span>
                             <span> Add new group </span>
                        </div>
                    </div>
                    <div class="add-group_body">
                        <div class="add-group-input-container">
                            <label> Group Name</label>
                            <input type="text" name="name" placeholder="Group name here ... " />
                        </div>
                        <div class="add-group-input-container">
                            <label> Field Name</label>
                            <select>
                                <option value="IDSIT" type="text" name="field" > IDSIT </option>
                                <option value="IDSIT" type="text" name="field" > GL </option>
                                <option value="IDSIT" type="text" name="field" > SSI </option>
                            </select>
                        </div>
                        <div class="add-group-input-container">
                            <label> Group Level </label>
                            <select>
                                <option value="IDSIT" type="text" name="field" > 1A </option>
                                <option value="IDSIT" type="text" name="field" > 2A </option>
                                <option value="IDSIT" type="text" name="field" > 3A </option>
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


</body>
</html>
