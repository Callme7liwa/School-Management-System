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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/8-absence.css"/>
</head>

<body>
<div class="page-acceuil-container">
    <div class="page-acceuil-content"> -->
        <!-- SIDE BARE HERE ...  -->
        <%@include file="../../includes/SideBar.jsp"%>
        <div class="acceuil-content_left">
          
            <!-- TOP BARE HERE  -->
            <%@include file="../../includes/Navbar.jsp"%>

            <div class="students-years">
              <c:forEach items="${years}" var="year">
                <span><a class="student-year"> ${year} </a></span>
              </c:forEach>
            </div>

            <div class="content-left_medium student-content-left_medium content-left-absences" >

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
                  
                  <!-- {/* Student INFO RIGHT => ABSENCE   */} -->
                  <div class="student-info_right">
             
                    <c:forEach items="${absences}" var="absence">

                      <div class="absence-item-container">
                        <div class="abscence-item_top">
                          <span class="item-top-name-image">${absence.modul_abbreviation}</span>
                          <span class="item-top-name-text">${absence.modul_name}</span>
                        </div>
                        <div class="abscence-item_medium">
                          <table>
                            <tr>
                              <th>   <img style="width: 30px" srcset="${pageContext.request.contextPath}/static/images/dateIcon.png"/></th>
                              <th>  <img style="width: 30px"  srcset="${pageContext.request.contextPath}/static/images/hourIcon.png"/></th>
                              <th>  <img style="width: 30px" srcset="${pageContext.request.contextPath}/static/images/dateIcon.png"/></th>
                            </tr>
                            <c:forEach items="${absence.absenceDates}" var="date">
                              <tr>
                                  <td class="absence-value">${date.absence_date}</td> 
                                  <td class="">${date.absence_hour}</td> 
                                  <td> 
                                    <a href="${pageContext.request.contextPath}/editAbsence_modul?si=<c:out value='${absence.student_id}' />&mi=<c:out value='${absence.modul_id}' />&mb=<c:out value='${absence.modul_abbreviation}' />&ah=<c:out value='${date.absence_hour}'/>&da=<c:out value='${date.absence_date}'/>">
                                      <i class="fa fa-refresh"></i>  
                                    </a>
                                    <form method="post" action="${pageContext.request.contextPath}/students">
                                      <input type="text" name="action" value="delete_absence" hidden>
                                      <input name="student_id" value="${absence.student_id}"   hidden />
                                      <input name="modul_id" value="${absence.modul_id}"   hidden />
                                      <input name="absence_date" value="${date.absence_date}"   hidden />
                                      <button type="submit"><i class="fa fa-times"></i></button>
                                    </form>
                                  </td>
                              </tr>
                            </c:forEach>
                          </table>
                        </div>
                        <div class="abscence-item_footer">
                          <a href="${pageContext.request.contextPath}/addAbsence_modul?si=<c:out value='${absence.student_id}' />&mi=<c:out value='${absence.modul_id}' />&mb=<c:out value='${absence.modul_abbreviation}' />"></a>
                        </div>
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

