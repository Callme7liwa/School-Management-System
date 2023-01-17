<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 13/11/2022
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../../includes/Header.jsp" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/3-dashboard.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/7-personalInfomation.css"/>
</head>
<body>

  <div class="page-acceuil-container">
    <div class="page-acceuil-content"> -->
        <!-- SIDE BARE HERE ...  -->
        <%@include file="../../includes/SideBar.jsp"%>
        <div class="acceuil-content_left">
            <!-- TOP BARE HERE  -->
            <%@include file="../../includes/Navbar.jsp"%>
            <div class="content-left_medium content-personal-information"  >
              <div class="content-personal-information_header"><span> Scholar Information</span></div>
              <div class="content-personal-information_body" >
                <div class="body_header">About ${student.student_name} </div>
                <div class="body_content" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/students">
                    <!--  -->
                    <div class="personal-infomation-input-container">
                      <label> Name  </label>
                      <input name="student_name" placeholder="student name "  value="<c:out value='${student.student_name}' />" disabled />
                    </div>
                    <!--  -->
                    <div class="personal-infomation-input-container">
                      <label> Second Name  </label>
                      <input name="student_secondName" placeholder="student second Name "  value="<c:out value='${student.student_secondName}' />" disabled/>
                    </div>
                    <!--  -->
                    <div class="personal-infomation-input-container">
                      <label> Cne  </label>
                      <input name="student_cne" placeholder="student cne "  value="<c:out value='${student.student_cne}' />" disabled/>
                    </div>
                    <!--  -->
                    <div class="personal-infomation-input-container">
                      <label> List Of Group  </label>
                      <select name="groups">
                        <c:forEach items="${student.groups}" var="group">
                          <option> ${group.group_name} ${group.group_level} </option>
                        </c:forEach>
                      </select>
                    </div>
                    <!--  -->
                    <div class="personal-infomation-input-container">
                      <label> Field  </label>
                      <input type="text" name="student_field" placeholder="Student Field " value="<c:out value='${student.student_field}' />" disabled />
                    </div>
                    <!--  -->
                    <div class="personal-infomation-input-container">
                      <label> Inscription Date   </label>
                      <input type="text" name="student_field" placeholder="Student Field " value="<c:out value='${student.student_field}' />" disabled />
                    </div>
                   
                  </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
