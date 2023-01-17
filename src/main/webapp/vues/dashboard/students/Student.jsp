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
    <title>Title</title>
    <%@include file="../../includes/Header.jsp" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/3-dashboard.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/6-student.css"/>
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
                          <span class="student-name">Ayoub Seddiki</span>
                          <span class="student-adress">30 rue hay salam bourkaiz fes , maroc </span>
                        </div>
                      </div>
                    </div>
                    <!-- {/*  */} -->
                    <div class="info-left_medium">
                      <div class="left-medium_item-info">
                        <span> Ayoub seddiki </span>
                        <span> fés </span>
                        <span> Elamatadoyoub@gmail.com </span>
                        <span> CD269360 </span>
                        <span> 12/04/2020</span>
                      </div>
                      <div class="left-medium_item-info left-medim_item-info_second">
                        <span> 2020/2021</span>
                        <span> 2eme annee </span>
                        <span> IDSIT </span>
                        <span> N139149171 </span>
                      </div>
                    </div>
                    <!-- {/* Button */} -->
                    <div class="info-left_bottom">
                      <button class=""><i class="fa fa-refresh"></i></button>
                    </div>
                  </div>
                  <!-- {/* Student INFO RIGHT  */} -->
                  <div class="student-info_right">
                    <div class="student-info-right_item">
                      <div class="image-container">
                        <img srcset="${pageContext.request.contextPath}/static/images/absIcon.png"/>
                      </div>
                      <span class="item-title"> Abscence </span>
                      <a href="${pageContext.request.contextPath}/absences?id=<c:out value='${student.student_id}' /> "><i class="fa fa-long-arrow-right"></i></a>
                    </div>
                    <div class="student-info-right_item">
                      <div class="image-container">
                        <img srcset="${pageContext.request.contextPath}/static/images/markIcon.png"/>
                      </div>
                      <span class="item-title"> Notes </span>
                      <a href="${pageContext.request.contextPath}/marks?id=<c:out value='${student.student_id}' /> "><i class="fa fa-long-arrow-right"></i></a>
                    </div>
                    <div class="student-info-right_item">
                      <div class="image-container">
                        <img srcset="${pageContext.request.contextPath}/static/images/personalInfo.png"/>
                      </div>
                      <span class="item-title"> Personal Information </span>
                      <a href="${pageContext.request.contextPath}/personal_information?id=<c:out value='${student.student_id}' /> "><i class="fa fa-long-arrow-right"></i></a>
                    </div>
                    <div class="student-info-right_item">
                      <div class="image-container">
                        <img srcset="${pageContext.request.contextPath}/static/images/scholarInfo.png"/>
                      </div>
                      <span class="item-title"> Scholar Information </span>
                      <a href="${pageContext.request.contextPath}/scholar_information?id=<c:out value='${student.student_id}' /> "><i class="fa fa-long-arrow-right"></i></a>
                    </div>
                  </div>
                </div>
              </div>
        </div>
    </div>
</div>

</body>
</html>

