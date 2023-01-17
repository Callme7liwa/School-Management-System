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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/18-modul.css"/>

</head>

<body>

    <div class="page-acceuil-container">
      <div class="page-acceuil-content">
        <%@include file="../../includes/SideBar.jsp"%>
        <div class="acceuil-content_left">
            <!-- TOP BARE HERE  -->
            <%@include file="../../includes/Navbar.jsp"%>
          <div class="content-left_medium student-content-left_medium" >
            <div class="student-info-container">
              <!-- {/* Left za3ma right  */} -->
              <div class="student-info_left">
                <!-- {/* CE QUI EST EN HAUT OF THE CARD  */} -->
                <div class="info-left_top">
                  <div class="left-top_left image-container bg-red">
                    <span>${modul.modul_abbreviation}</span>
                  </div>
                  <div class="left-top_right">
                    <div class="">
                      <span class="student-name">${modul.modul_name}</span>
                      <span class="student-adress">The modul does  not contain any description</span>
                    </div>
                  </div>
                </div>
                <!-- {/* INFORMATIONS */} -->
                <div class="info-left_medium">
                  <!-- {/*  */} -->
                  <div class="left-medium-info_modul info_1">
                    <div class="image-container-item">
                      <img srcset="${pageContext.request.contextPath}/static/images/studentIcon.png" />
                    </div>
                    <div> <span>${modul.professor_numbers} professors</span> </div>
                  </div>
                  <!-- {/*  */} -->
                  <div class="left-medium-info_modul ">
                    <div class="image-container-item">
                      <img  srcset="${pageContext.request.contextPath}/static/images/groupIcon2.png" width="30px" />
                    </div>
                    <div> <span class="info_2">${modul.groups_number} groups</span> </div>
                  </div>
                  <!-- {/*  */} -->
                  <div class="left-medium_item-info left-medim_item-info_modul">
                    <c:forEach items="${modul.fields}" var="field">
                      <span> ${field.field_abbreviation}</span>
                    </c:forEach>
                  </div>
                </div>
                <!-- {/* Button */} -->
                <div class="info-left_bottom">
                  <button class=""><i class="fa fa-refresh"></i></button>
                </div>
              </div>
              <!-- {/* Student INFO RIGHT  */} -->
              <div class="student-info_right">
                <a class="student-info-right_item" href="${pageContext.request.contextPath}/get_fields?modul_id=<c:out value='${modul.modul_id}' />">
                  <div class="image-container">
                    <img  srcset="${pageContext.request.contextPath}/static/images/filiereIcon.png"  />
                  </div>
                  <span class="item-title"> Fields </span>
                  <span><i class="fa fa-long-arrow-right"></i></span>
                </a>
                <a class="student-info-right_item"  href="${pageContext.request.contextPath}/get_groups?modul_id=<c:out value='${modul.modul_id}' />">
                  <div class="image-container">
                    <img src="${pageContext.request.contextPath}/static/images/absIcon.png" srcset="${pageContext.request.contextPath}/static/images/groupIcon2.png" />
                  </div>
                  <span class="item-title"> Groups </span>
                  <span><i class="fa fa-long-arrow-right"></i></span>
                </a>
                <a class="student-info-right_item"  href="${pageContext.request.contextPath}/get_professors?modul_id=<c:out value='${modul.modul_id}' />">
                  <div class="image-container">
                    <img src="${pageContext.request.contextPath}/static/images/teacher.png" srcset="${pageContext.request.contextPath}/static/images/teacher.png" />
                  </div>
                  <span class="item-title"> Professors </span>
                  <span><i class="fa fa-long-arrow-right"></i></span>
                </a>
                <a class="student-info-right_item"  href="${pageContext.request.contextPath}/edit_modul?modul_id=<c:out value='${modul.modul_id}' />">
                  <div class="image-container">
                    <img srcset="${pageContext.request.contextPath}/static/images/personalInfo.png"/>
                  </div>
                  <span class="item-title">  Informations </span>
                  <span><i class="fa fa-long-arrow-right"></i></span>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

</body>
</html>

