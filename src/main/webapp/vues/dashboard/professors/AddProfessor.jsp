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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/5-addstudent.css"/>
</head>

<body>
<div class="page-acceuil-container">
    <div class="page-acceuil-content"> -->
        <!-- SIDE BARE HERE ...  -->
        <%@include file="../../includes/SideBar.jsp"%>
        <div class="acceuil-content_left">
            <!-- TOP BARE HERE  -->
            <%@include file="../../includes/Navbar.jsp"%>
            <div class="content-left_medium content-personal-information">
                <div class="content-personal-information_header"><span>Add New Professor</span></div>
                <div class="content-personal-information_body">
                    <div class="body_header">About the Professor  </div>
                    <div class="body_content">
                        <div class="personal-infomation-input-container">
                            <label> Name </label>
                            <input type="text" name="name" placeholder="Your name here ..." />
                        </div>
                        <div class="personal-infomation-input-container">
                            <label> Second Name  </label>
                            <input type="text" name="secondName" placeholder="Your second name here ..." />
                        </div>
                        <div class="personal-infomation-input-container">
                            <label> Birthday  </label>
                            <input type="date" name="birthday" placeholder="Your Birthday  here ..." />
                        </div>
                        <div class="personal-infomation-input-container">
                            <label> Gender  </label>
                            <select>
                                <option> M </option>
                                <option> F </option>
                            </select>
                        </div>
                        <div class="personal-infomation-input-container">
                            <label> Nationality  </label>
                            <input type="text" name="nationalite" placeholder="Your nationality here ..." />
                        </div>
                        <div class="personal-infomation-input-container">
                            <label> Cin  </label>
                            <input type="text" name="cin" placeholder="Your cin here ..." />
                        </div>

                        <div class="personal-infomation-input-container">
                            <label> Cne  </label>
                            <input type="text" name="cin" placeholder="Your cne here ..." />
                        </div>

                        <div class="personal-infomation-input-container">
                            <label> Email Adress  </label>
                            <input type="email" name="email" placeholder="Your email adress here ..." />
                        </div>
                        <div class="personal-infomation-input-container">
                            <label> Country  </label>
                            <input type="text" name="country" placeholder="Your country here ..." />
                        </div>
                        <div class="personal-infomation-input-container">
                            <label> City  </label>
                            <input type="text" name="city" placeholder="Your city here ..." />
                        </div>
                        <div class="personal-infomation-input-container">
                            <label> Adress & postal code  </label>
                            <input type="text" name="adress" placeholder="Your adress here ..." />
                        </div>

                        <div class="personal-infomation-input-container">
                            <label> Field  </label>
                            <select>
                                <option> IDSIT </option>
                                <option> GL </option>
                            </select>
                        </div>

                        <div class="personal-infomation-input-container input-submit input-add-student w-100">
                            <button class="submit-input" value="submit">Submit <i class="fa fa-long-arrow-right ms-2"></i> </button>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
