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
    <title>Title</title>
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
              <div class="content-personal-information_header"><span>Update Personal Information</span></div>
              <div class="content-personal-information_body" >
                <div class="body_header">About <c:out value="${student.student_name}" /> </div>
                <form class="body_content" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/students">
                  
                  <input type="text" name="student_id" placeholder="Your id here ..."   value="<c:out value='${student.student_id}' />" hidden/>
                  
                  <div class="personal-infomation-input-container">
                    <label> Name </label>
                    <input type="text" name="student_name" placeholder="Your name here ..."  value="<c:out value='${student.student_name}' />" />
                  </div>
                    <div class="personal-infomation-input-container">
                      <label> Action </label>
                      <input type="text" name="action" placeholder="Your action here ..."   value="update_student_personnal" />
                    </div>
                    <div class="personal-infomation-input-container">
                      <label> Second Name  </label>
                      <input type="text" name="student_secondName" placeholder="Your second name here ..." value="<c:out value='${student.student_secondName}' />"  />
                    </div>
                    <div class="personal-infomation-input-container">
                      <label> Birthday  </label>
                      <input type="date" name="student_birthday" placeholder="Your Birthday  here ..." value="<c:out value='${student.student_birthday}' />" />
                    </div>
                    <div class="personal-infomation-input-container">
                      <label> Gender  </label>
                      <input type="text" name="student_oldGender" placeholder="Your id here ..."   value="<c:out value='${student.student_gender}' />" hidden/>
                      <select name="student_gender">
                        <option value="<c:out value='${student.student_gender}' />"> Current : <span> ${student.student_gender}</span></option>
                        <option> male </option>
                        <option> female </option>
                      </select>
                    </div>
                    <div class="personal-infomation-input-container">
                      <label> Nationality  </label>
                      <input type="text" name="student_nationality" placeholder="Your nationality here ..." value="<c:out value='${student.student_nationality}' />" />
                    </div>
                    <div class="personal-infomation-input-container">
                      <label> CIN  </label>
                      <input type="text" name="student_cin" placeholder="Your Cin here ..." value="<c:out value='${student.student_cin}' />" />
                    </div>
                    <div class="personal-infomation-input-container">
                      <label> Email Adress  </label>
                      <input type="email" name="student_email" placeholder="Your email adress here ..." value="<c:out value='${student.student_email}' />"/>
                    </div>
                    <div class="personal-infomation-input-container">
                      <label> Country  </label>
                      <input type="text" name="student_country" placeholder="Your country here ..."  value="<c:out value='${student.student_country}' />"/>
                    </div>
                    <div class="personal-infomation-input-container">
                      <label> City  </label>
                      <input type="text" name="student_city" placeholder="Your city here ..." value="<c:out value='${student.student_city}' />" />
                    </div>
                    <div class="personal-infomation-input-container">
                      <label> Adress & postal code  </label>
                      <input type="text" name="student_adress" placeholder="Your adress here ..." value="<c:out value='${student.student_adress}' />"/>
                    </div>
                    <div class="personal-infomation-input-container">
                      <label> Phone </label>
                      <input type="text" name="student_phone" placeholder="Your adress here ..." value="<c:out value='${student.student_phone}' />"/>
                    </div>

                    <div class="personnal-information-old-pic">
                      <label> Current Pic </label>
                      <img src="${pageContext.request.contextPath}/static/uploads/${student.student_image}" alt="image description">
                    </div>
              
                    <input type="text" name="student_oldImage" placeholder="Your old image here ..." value="<c:out value='${student.student_image}' />" hidden/>
                    <div class="personal-information-input-container image-upload">
                      <label id="label-upload-pic-personal" for="upload-pic">
                          <img srcset="${pageContext.request.contextPath}/static/images/imageUploadIcon.png"/>
                          <span >upload pic here</span>
                      </label>
                      <input name="student_image" id="upload-pic" type="file" hidden  accept="image/*"/>
                    </div>
                    <div class="personal-infomation-input-container input-submit">
                      <button class="submit-input" value="submit"> Update  <i class="fa fa-long-arrow-right ms-2"></i> </button>
                    </div>
                  </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
