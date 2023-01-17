<%-- Created by IntelliJ IDEA. User: MyPC Date: 14/11/2022 Time: 11:26 To change this template use File | Settings |
    File Templates. --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <html>

        <head>
            <title>Add Group </title>
            <link rel="stylesheet" type="text/css"
                href="${pageContext.request.contextPath}/static/css/3-dashboard.css" />
            <link rel="stylesheet" type="text/css"
                href="${pageContext.request.contextPath}/static/css/11-addfield.css" />
            <link rel="stylesheet" type="text/css"
                href="${pageContext.request.contextPath}/static/css/25-event.css" />
            <%@include file="../../includes/Header.jsp" %>
        </head>

        <body>
            <div class="page-acceuil-container">
                <div class="page-acceuil-content"> -->
                    <!-- SIDE BARE HERE ...  -->
                    <%@include file="../../includes/SideBar.jsp" %>
                        <div class="acceuil-content_left">
                            <!-- TOP BARE HERE  -->
                            <%@include file="../../includes/Navbar.jsp" %>
                                <div class="acceuil-left_medium events-container acceuil-left_medium_specialitieScholar">
                                    <div class="events-header">
                                        <div class="event-number"> 191 </div>
                                        <div class="event-header_right">
                                            <div class="header-title">
                                                <span>title</span> ${event.event_title}
                                            </div>
                                            <div class="header-date">
                                                <span>${event.event_date}</span> <span class="on">ON</span>
                                                <span>${event.event_local}</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="events-description">
                                        <div class="event-description_header">
                                            <span>Description</span>
                                        </div>
                                        <div class="event-description_body">
                                            ${event.event_description} 
                                            ${event.event_description} 
                                            ${event.event_description} 
                                        </div>
                                        <div class="page-list-specialities">
                                            <div class="doc-item">
                                                <c:choose>
                                                    <c:when test="${event.event_fileExtension == 'png'}">
                                                        <img class='class-name' src='${pageContext.request.contextPath}/static/uploads/events/${event.event_filePath}'>
                                                    </c:when>
                                                    <c:when test="${event.event_fileExtension == 'jpeg' || event.event_fileExtension == 'jpg'}">
                                                        <img class='class-name' src='${pageContext.request.contextPath}/static/uploads/events/${event.event_filePath}'>
                                                    </c:when>
                                                    <c:when test="${event.event_fileExtension == 'docx'}">
                                                        <img class='class-name' src='${pageContext.request.contextPath}/static/images/docxIcon.png'>
                                                    </c:when>
                                                    <c:when test="${event.event_fileExtension == 'pdf'}">
                                                        <img class='class-name' src='${pageContext.request.contextPath}/static/images/pdfIcon.png'>
                                                    </c:when>
                                                    <c:otherwise>
                                                        Affichage par défaut pour les autres types de documents
                                                    </c:otherwise>
                                                </c:choose>
                                                <a href="${pageContext.request.contextPath}/static/uploads/events/${event.event_filePath}" download> file.${event.event_fileExtension}</a>
                                                <div class="doc-actions">
                                                    <a> <i class="fa fa-trash"></i> </a>
                                                    <a href="${pageContext.request.contextPath}/static/uploads/events/${event.event_filePath}" download> <i class="fa fa-download"></i> </a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="event-actions">
                                            <a class="btn btn-warning" href="${pageContext.request.contextPath}/edit_event?event_id=<c:out value='${event.event_id}' />">
                                                <i class="fa fa-refresh"></i>update
                                            </a>
                                            <a class="btn btn-danger text-white">
                                                <i class="fa fa-times"></i>delete
                                            </a>
                                        </div>
                                    </div>
                                </div>
                        </div>
                </div>
            </div>


        </body>

        </html>