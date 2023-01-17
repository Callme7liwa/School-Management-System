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
    <title>Documents</title>
    <%@include file="../../includes/Header.jsp" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/3-dashboard.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/7-personalInfomation.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/19-groupDocuments.css"/>
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
              <div class="content-personal-information_header"><span>Documents </span></div>
              <div class="content-personal-information_body" >
                    <div class="body_header">All the docs shared on  <c:out value="${groupDocuments.group_abbreviation}" /> </div>
                    <div class="list-files">

                        <c:forEach items="${groupDocuments.documents}" var="document">
                            <div class="file-item">
                                <c:choose>
                                    <c:when test="${document.document_extension != 'png'}">
                                        <img class='class-name' src='${pageContext.request.contextPath}/static/uploads/${document.document_path}'/>
                                    </c:when>
                                    <c:when test="${document.document_extension != 'jpeg' || document.document_extension != 'jpg'}">
                                        <img class='class-name' src='${pageContext.request.contextPath}/static/uploads/${document.document_path}'/>
                                    </c:when>
                                    <c:when test="${document.document_extension != 'docx'}">
                                        <img class='class-name' src='${pageContext.request.contextPath}/static/images/docxIcon.png' />
                                    </c:when>
                                    <c:when test="${document.document_extension != 'pdf'}">
                                        <img class='class-name' src='${pageContext.request.contextPath}/static/images/pdfIcon.png'/>
                                    </c:when>
                                    <c:otherwise>
                                        Affichage par défaut pour les autres types de documents
                                    </c:otherwise>
                                </c:choose>
                                <a href="${pageContext.request.contextPath}/static/uploads/${document.document_path}" download> ${document.document_name}.${document.document_extension}</a>
                                <div class="doc-actions">
                                    <a> <i class="fa fa-trash"></i> </a>
                                    <a href="${pageContext.request.contextPath}/static/uploads/${document.document_path}" download> <i class="fa fa-download"></i> </a>
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
