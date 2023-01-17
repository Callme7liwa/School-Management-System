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
    <title>Professor Informations </title>
    <%@include file="../../includes/Header.jsp" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/3-dashboard.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/6-student.css"/>
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
            <div class="content-left_medium student-content-left_medium" >
                <div class="student-info-container">
                  <!-- {/* Left za3ma right  */} -->
                  <div class="student-info_left">
                    <!-- {/*  */} -->
                    <div class="info-left_top">
                      <div class="left-top_left image-container">
                        <img srcset="${pageContext.request.contextPath}/static/images/abduh.png"/>
                      </div>
                      <div class="left-top_right">
                        <div class="">
                          <span class="student-name">${professor.professor_name}  ${professor.professor_secondName}</span>
                          <span class="student-adress">${professor.professor_adress} </span>
                        </div>
                      </div>
                    </div>
                    <!-- {/*  */} -->
                    <div class="info-left_medium">
                      <div class="left-medium_item-info">
                        <span> ${professor.professor_name}  ${professor.professor_secondName}</span>
                        <span> ${professor.professor_city} </span>
                        <span> ${professor.professor_email} </span>
                        <span> ${professor.professor_cin} </span>
                        <span> ${professor.professor_birthday}</span>
                      </div>
                      <div class="left-medium_item-info left-medim_item-info_second">
                        <span>${professor.professor_modulNumber} moduls</span>
                        <span>${professor.professor_groupNumber} groups </span>
                        <span> ${professor_departementName}</span>
                        <span> IDSIT </span>
                      </div>
                    </div>
                    <!-- {/* Button */} -->
                    <div class="info-left_bottom">
                      <button class=""><i class="fa fa-refresh"></i></button>
                    </div>
                  </div>
                  <!-- {/* Student INFO RIGHT  */} -->
                  <div class="grp-info-right">
                    <div class="line-items">
                       <a class="add-item" href="${pageContext.request.contextPath}/professor_moduls?professor_id=<c:out value='${professor.professor_id}' />&&fn=<c:out value='${professor.professor_name}' />&&sn=<c:out value='${professor.professor_secondName}' />">
                           <div><img src="${pageContext.request.contextPath}/static/images/moduleIcon.png"  height="40px" width="40px"/></div>
                           <div> <span class="title-item">See Modules </span></div>
                           <div><i class="fa fa-eye"></i></div>
                       </a>
                       <a class="add-item" href="${pageContext.request.contextPath}/professor_groups?professor_id=<c:out value='${professor.professor_id}' />">
                           <div><img src="${pageContext.request.contextPath}/static/images/teacher.png" height="40px" width="40px"/></div>
                           <div> <span class="title-item">See Groups </span></div>
                           <div><i class="fa fa-eye"></i></div>
                       </a>
                       <a class="add-item" href="${pageContext.request.contextPath}/professor_personalInformation?professor_id=<c:out value='${professor.professor_id}' />">
                           <div><img src="${pageContext.request.contextPath}/static/images/personalInfo.png" height="40px" width="40px"/></div>
                           <div> <span class="title-item">See Informations </span></div>
                           <div><i class="fa fa-eye"></i></div>
                       </a>
                    </div>
               </div>
                </div>
              </div>
        </div>
    </div>
</div>

</body>
</html>

