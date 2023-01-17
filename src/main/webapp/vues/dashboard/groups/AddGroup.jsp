<%-- Created by IntelliJ IDEA. User: MyPC Date: 14/11/2022 Time: 11:26 To change this template use File | Settings |
    File Templates. --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>

        <head>
            <title>Add Group </title>
            <link rel="stylesheet" type="text/css"
                href="${pageContext.request.contextPath}/static/css/3-dashboard.css" />
            <link rel="stylesheet" type="text/css"
                href="${pageContext.request.contextPath}/static/css/11-addfield.css" />
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
                                <div className="acceuil-left_medium  acceuil-left_medium_specialitieScholar">
                                    <div className="events-header">
                                        <div className="event-number"> 191 </div>
                                        <div className="event-header_right">
                                            <div className="header-title">
                                                <span>title</span> Conference for web developement and new
                                                technologies{" "}
                                            </div>
                                            <div className="header-date">
                                                <span>2020-11-01</span> <span className="on">ON</span>{" "}
                                                <span>amphi conference ensias school</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="events-description">
                                        <div className="event-description_header">
                                            <span>Description</span>
                                        </div>
                                        <div className="event-description_body">
                                            Contrary to popular belief, Lorem Ipsum is not simply random
                                            text. It has roots in a piece of classical Latin literature
                                            from 45 BC, making it over 2000 years old. Richard McClintock,
                                            a Latin professor at Hampden-Sydney College in Virginia,
                                            looked up one of the more obscure Latin words, consectetur,
                                            from a Lorem Ipsum passage, and going through the cites of the
                                            word in classical literature, discovered the undoubtable
                                            source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of
                                            "de Finibus Bonorum et Malorum" (The Extremes of Good and
                                            Evil) by Cicero, written in 45 BC. This book is a treatise on
                                            the theory of ethics, very popular during the Renaissance. The
                                            first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..",
                                            comes from a line in section 1.10.32. The standard chunk of
                                            Lorem Ipsum used since the 1500s is reproduced below for those
                                            interested. Sections 1.10.32 and 1.10.33 from "de Finibus
                                            Bonorum et Malorum" by Cicero are also reproduced in their
                                            exact original form, accompanied by English versions from the
                                            1914 translation by H. Rackham.
                                            Contrary to popular belief, Lorem Ipsum is not simply random
                                            text. It has roots in a piece of classical Latin literature
                                            from 45 BC, making it over 2000 years old. Richard McClintock,
                                            a Latin professor at Hampden-Sydney College in Virginia,
                                            looked up one of the more obscure Latin words, consectetur,
                                            from a Lorem Ipsum passage, and going through the cites of the
                                            word in classical literature, discovered the undoubtable
                                            source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of
                                            "de Finibus Bonorum et Malorum" (The Extremes of Good and
                                            Evil) by Cicero, written in 45 BC. This book is a treatise on
                                            the theory of ethics, very popular during the Renaissance. The
                                            first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..",
                                            comes from a line in section 1.10.32. The standard chunk of
                                            Lorem Ipsum used since the 1500s is reproduced below for those
                                            interested. Sections 1.10.32 and 1.10.33 from "de Finibus
                                            Bonorum et Malorum" by Cicero are also reproduced in their
                                            exact original form, accompanied by English versions from the
                                            1914 translation by H. Rackham.
                                        </div>
                                        <div className="page-list-specialities">
                                            <div className="doc-item">
                                                <img src={Images.documentIcon} />
                                                <a href=""> Hello.pdf </a>
                                                <div className="doc-actions">
                                                    <a> <i className="fa fa-trash"></i> </a>
                                                    <a> <i className="fa fa-download"></i> </a>
                                                </div>
                                            </div>
                                        </div>
                                        <div className="event-actions">
                                            <a className="btn btn-warning">
                                                <i className="fa fa-refresh"></i>update
                                            </a>
                                            <a className="btn btn-danger text-white">
                                                <i className="fa fa-times"></i>delete
                                            </a>
                                        </div>
                                    </div>
                                </div>
                        </div>
                </div>
            </div>


        </body>

        </html>