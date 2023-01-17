<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 11/11/2022
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/login.css"/>
</head>
<body>
        <div class="page-login-container">
            <div class="page-login-content">
                <img srcset="${pageContext.request.contextPath}/static/images/student.png"  alt="Image Login Acceuil "/>
                <p> Lorem ipsum dolor sit , veniam quae?  hic provident velit non totam? Eius, dolore? Pariatur saepe ipsam quos hic nisi accusamus nihil, adipisci magnam laboriosam quam, modi numquam fugiat aliquam? Asperiores.  </p>
            </div>
            <div class="page-login-content_second">
                <form class="card-login-container" method="POST" action="${pageContext.request.contextPath}/authentication">

                    <div class="card-login-header"><img srcset="${pageContext.request.contextPath}/static/images/learningIcon.png" /><h1>E-Lear<span>ning</span> </h1></div>
                    <!--  -->
                    <div class="card-login-content">
                        <div class="login-content_header">
                            <span> <img srcset="${pageContext.request.contextPath}/static/images/loginIcon.png"/> Welcome  Back </span>
                            <span>  Login to Continue  </span>
                        </div>
                        <div class="login-content_body">
                            <input type="text" name="action" placeholder="action" hidden value="authenticate" />
                            <input type="text" name="type_user" placeholder="type_user"  value='<%=request.getAttribute("type_user")%>' hidden  />
                            <div class="login-input-container">
                                <label>Login</label>
                                <input type="text" name="email" placeholder="Your Login Here ..." />
                            </div>
                            <div class="login-input-container">
                                <label>Password</label>
                                <input type="password" name="password" placeholder="Your Password Here ..." />
                            </div>
                            <div class="login-input-container">
                                <input class="input-submit" type="submit" value="Login" />
                            </div>
                        </div>
                        <div class="card-login-footer">
                            <span class=""> Did u forgot your password ? <a>tape here !</a> </span>
                        </div>
                    </div>
                </form>
            </div>
        </div>
</body>
</html>
