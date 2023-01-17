<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 11/11/2022
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="acceuil-content_right">
    <div class="content-right_space">
        <i class="fa fa-user"></i>
        <i class="fa fa-ellipsis-v"></i>
    </div>
    <div class="content-right_top">
        <div class="image-container">
            <img  srcset="${pageContext.request.contextPath}/static/images/abduh.png" />
        </div>
        <div class="user-name-connected"><span> Hello Ayoub  </span></div>
        <div class="email-connected"><span> ayoubseddiki@gmail.com  </span></div>
    </div>
    <div class="content-right_medium">
        <div class="list-items">
            <a class="item">  <img srcset="${pageContext.request.contextPath}/static/images/dashboardIcon.png"/> <span>Dashboard</span>  <span class="item-number"> 1 </span> <i class="fa fa-angle-right"></i> </a>
            <a class="item">  <img srcset="${pageContext.request.contextPath}/static/images/classesIcon.png" /> <span>Classes</span>  <span class="item-number"> 2 </span> <i class="fa fa-angle-right"></i> </a>
            <a class="item">  <img srcset="${pageContext.request.contextPath}/static/images/studentIcon.png"/> <span>Students</span>  <span class="item-number"> 3 </span> <i class="fa fa-angle-right"></i> </a>
            <a class="item">  <img srcset="${pageContext.request.contextPath}/static/images/teacher.png"/> <span>Teachers</span>  <span class="item-number"> 4 </span> <i class="fa fa-angle-right"></i> </a>
            <a class="item">  <img srcset="${pageContext.request.contextPath}/static/images/messagesIcon.png" /> <span>Messages</span>  <span class="item-number"> 5 </span> <i class="fa fa-angle-right"></i> </a>
        </div>
    </div>
</div>

