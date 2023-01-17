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
    <title>Professors</title>
    <%@include file="../../includes/Header.jsp" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/3-dashboard.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/7-personalInfomation.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/22-modulProfessors.css"/>
</head>
<body>

  <div class="page-acceuil-container">
    <div class="page-acceuil-content"> -->
        <!-- SIDE BARE HERE ...  -->
        <%@include file="../../includes/SideBar.jsp"%>
        <div class="acceuil-content_left">
            <!-- TOP BARE HERE  -->*
            <%@include file="../../includes/Navbar.jsp"%>
            <div class="content-left_medium content-personal-information"  >
              <div class="content-personal-information_header"><span>All Professors</span></div>
              <div class="content-personal-information_body" >
                <div class="body_header">Affectation of <c:out value="${affectations.group_name}" /> </div>
                <div class="list-professors">
                  <c:forEach items="${affectations.moduls_professors}" var="affectation" varStatus="status" >
                      <div class="item-professor-modul">
                        <img srcset="${pageContext.request.contextPath}/static/images/abduh.png"/>
                        <div class="professor-information">
                          <span> ${affectation.professor_name} ${affectation.professor_secondName}  </span>
                          <span> ${affectation.modul_name} </span>
                        </div>
                         <i class="fa fa-long-arrow-right"></i> 
                      </div>
                  </c:forEach>
                </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
