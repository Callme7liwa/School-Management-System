<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 13/11/2022
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>FIELDS </title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/3-dashboard.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/10-specialities.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/10-specialities1.css"/>
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

                <div class="acceuil-left_medium  acceuil-left_medium_specialitieScholar">
                    <div class="page-title">
                        <div class="page-title_left">Differents Specialities in Ensias School</div>
                        <div class="page-title_right">
                            <a> <i class="fa fa-search"></i></a>
                            <a href="${pageContext.request.contextPath}/create_field"> <i class="fa fa-plus"></i></a>
                        </div>
                    </div>
                    <div class="list-specialities">
                        <c:forEach items="${fields}" var="field" varStatus="status">
                            <div class="item-speciality-container">
                                <div class="item-speciality-content">
                                  <span class="item-number"> ${status.index}  </span>
                                  <div class="speciality-information">
                                    <div class="field-abbreviation"><span>${field.field_abbreviation}</span></div>
                                    <div class="field-name"><span>${field.field_name} </span></div>
                                    <div class="field-creationDate"><span> 2020-11-01 </span></div>
                                  </div>
                                  <div class="item-action">
                                    <a href="${pageContext.request.contextPath}/field?field_id=<c:out value='${field.field_id}' />">
                                      div into <i class="fa fa-arrow-right"></i> 
                                    </a>
                                  </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>

