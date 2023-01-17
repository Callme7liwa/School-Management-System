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
    <title>Add New Event</title>
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
              <div class="content-personal-information_header"><span> Add New Event </span></div>
              <div class="content-personal-information_body" >
                <form class="body_content" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/events">
                    <!--  -->
                    <div class="event-information-input-container personal-infomation-input-container">
                      <label> Event name   </label>
                      <input name="event_name" type="text" placeholder="event name "   />
                      <input name="action" type="text"  value="post_event" hidden/>
                    </div>
                    <!--  -->
                    <div class="event-information-input-container personal-infomation-input-container">
                      <label> Event Date   </label>
                      <input name="event_date" type="date" placeholder="event date"   />
                    </div>
                    <!--  -->
                    <div class="event-information-input-container personal-infomation-input-container">
                      <label> Event Local  </label>
                      <input name="event_local" type="text" placeholder="event local"  />
                    </div>
                    <!--  -->
                    <div class="event-information-input-container personal-infomation-input-container">
                      <label> Drop a file  </label>
                      <input  name="event_file" type="file" placeholder="Student Field "  />
                    </div>
                    <!--  -->
                    <!--  -->
                    <div class="event-information-textarea-container personal-infomation-input-container">
                      <label> Event Description </label>
                      <textarea  name="event_description" type="text" placeholder="Student Field "  > </textarea>
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
