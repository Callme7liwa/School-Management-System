<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 14/11/2022
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/3-dashboard.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/17-moduls.css"/>
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
                <div class="content-left_medium" >
                  <div class="items-dashboard-container">
                    <div class="dashboard-actions">
                      <a href="${pageContext.request.contextPath}/create_modul"> <i class="fa fa-plus"></i></a>
                    </div>
                    <c:forEach  items="${moduls}" var="modul" >
                      <div class="card-item-container">
                          <div class="card-item-header">
                              <span> ${modul.modul_abbreviation} </span>
                          </div>
                          <div class="card-item-body">
                              <div class="item-modul">
                                  <span class="modul-name">${modul.modul_name}</span> 
                              </div>
                              <div class="item-modul">
                                <div class="item-modul-fields">
                                    <div><span>Fields</span></div> 
                                    <div class="modul-list-field">
                                      <c:choose>
                                          <c:when test = "${fn:length(modul.fields) gt 0}">
                                            <c:forEach  items="${modul.fields}" var="field">
                                              <a class="field"> ${field.field_abbreviation}</a>
                                            </c:forEach >
                                          </c:when>
                                          <c:otherwise>
                                            <a class="field">No field</a>
                                          </c:otherwise>
                                       </c:choose>
                                    </div>
                                </div>
                              </div>
                              <div class="item-modul">
                                <div class="item-modul-fields">
                                    <div><span>Informations</span></div> 
                                    <div class="modul-list-field">
                                        <a class="field"> ${modul.groups_number} groups</a>
                                        <a class="field"> ${modul.professor_numbers} professors</a>
                                        <a class="field"> ${modul.modul_creationDate} </a>
                                    </div>
                                </div>
                              </div>
                              <div class="item-info-action">
                                <a class="button-action" href="${pageContext.request.contextPath}/modul?modul_id=<c:out value='${modul.modul_id}' />" >
                                  <span> discover </span>
                                  <span> <i class="fa fa-long-arrow-right"></i></span>
                                </a>
                              </div>
                          </div>
                      </div>
                    </c:forEach >
                  </div>
                </div>
            </div>
        </div>
    </div>


</body>
</html>
