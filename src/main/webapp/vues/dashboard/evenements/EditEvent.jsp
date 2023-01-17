<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 13/11/2022
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Add New Event</title>
    <%@include file="../../includes/Header.jsp" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/3-dashboard.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/7-personalInfomation.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/26-documentFile.css"/>

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
              <div class="content-personal-information_header"><span> Add New Event </span></div>
              <div class="content-personal-information_body" >
                <form class="body_content" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/events">
                    <!--  -->
                    <div class="event-information-input-container personal-infomation-input-container">
                      <label> Event name   </label>
                      <input name="event_title" type="text" placeholder="event name "   value="<c:out value='${event.event_title}'/>"/>
                      <input name="action" type="text"  value="update_event" hidden/>
                      <input name="event_id" type="text"  value="<c:out value='${event.event_id}' />" hidden/>
                    </div>
                    <!--  -->
                    <div class="event-information-input-container personal-infomation-input-container">
                      <label> Event Date   </label>
                      <fmt:formatDate value="${event.event_date}" pattern="yyyy-MM-dd" var="formattedDate"/>
                      <input type="date" name="event_date" value="${formattedDate}"/>
                    </div>
                    <!--  -->
                    <div class="event-information-input-container personal-infomation-input-container">
                      <label> Event Local  </label>
                      <input name="event_local" type="text" placeholder="event local"   value="<c:out value='${event.event_local}'/>"/>
                    </div>
                     
                    <div class="event-information-input-container personal-infomation-input-container">
                      <label> Drop a file  </label>
                      <input  name="event_filePath" type="text" value="<c:out value='${event.event_filePath}' />" placeholder="Event File" hidden />
                      <input  name="event_fileExtension" type="text" value="<c:out value='${event.event_fileExtension}' />" placeholder="Event File" hidden/>
                      <input  name="file" type="file" placeholder="Event File" />
                      
                        <c:if test="${not empty event.event_filePath}">
                            <div class="page-list-specialities mt-2">
                                <div class="doc-item">
                                      <c:choose>
                                        <c:when test="${event.event_fileExtension == 'png'}">
                                            <img class='class-name'
                                                src='${pageContext.request.contextPath}/static/uploads/events/${event.event_filePath}'>
                                        </c:when>
                                        <c:when test="${event.event_fileExtension == 'jpeg' || event.event_fileExtension == 'jpg'}">
                                            <img class='class-name'
                                                src='${pageContext.request.contextPath}/static/uploads/events/${event.event_filePath}'>
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
                                    <a href="${pageContext.request.contextPath}/static/uploads/events/${event.event_filePath}" download>
                                        file${event.event_fileExtension}</a>
                                    <div class="doc-actions">
                                        <a
                                            href="${pageContext.request.contextPath}/delete_Eventfile?event_id=<c:out value='${event.event_id}' />"><i
                                                class="fa fa-trash"></i> </a>
                                        <a href="${pageContext.request.contextPath}/static/uploads/events/${event.event_filePath}" download> <i
                                                class="fa fa-download"></i> </a>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </div> 
                    <!--  -->
                 
                    <div class="event-information-textarea-container personal-infomation-input-container">
                      <label> Event Description </label>
                      <textarea  name="event_description" type="text"  >${event.event_description} </textarea>
                    </div>
                    <!--  -->
                    <div class="personal-infomation-input-container input-submit">
                      <button class="submit-input" value="submit"> Update  <i class="fa fa-long-arrow-right ms-2"></i> </button>
                    </div>
                   
                  </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
