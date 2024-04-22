<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from askbootstrap.com/preview/osahan-eat/theme-sidebar/404.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Oct 2022 05:04:58 GMT -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" type="image/png" href="img/logo1.png">
        <title>BMOS</title>

        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="css/osahan.css" rel="stylesheet">
        <link href="font/stylesheet.css" rel="stylesheet">
        <link href="vendor/mdi-icons/css/materialdesignicons.min.css" rel="stylesheet">
        <link href="css/custom.css" rel="stylesheet">
    </head>
    <body id="page-top">

        <div id="wrapper">

            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <a class="sidebar-brand d-flex align-items-center" href="index.jsp">
                    <div class="sidebar-brand-icon">
                        <img src="img/logo1.png" class="img-fluid">
                    </div>
                </a>

                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">
                        <i class="mdi mdi-home-variant-outline"></i>
                        <span>TRANG CHỦ</span></a>
                </li>


                <li class="nav-item">
                    <a class="nav-link" href="#HistoryOrderController?username=${sessionScope.username}">
                        <i class="mdi mdi-book-open"></i>
                        <span>History Orders</span></a>
                </li>


                <li class="nav-item">
                    <a class="nav-link" href="setting.jsp">
                        <i class="mdi mdi-cog"></i>
                        <span>Settings</span></a>
                </li>





                <hr class="sidebar-divider d-none d-md-block">

                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>
            </ul>


            <div id="content-wrapper" class="d-flex flex-column">

                <div id="content">

                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow-sm osahan-nav-top">

                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <style>
                            .dropdown-menu a {
                                font-size: 15px;

                            }
                            .caret {
                                font-size: 15px;

                            }
                        </style>
                        <c:set var="name" value="${sessionScope.username}" />
                        <c:if test="${not empty name}">
                            <li class="dropdown">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle user-action"><svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                    <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                                    </svg>  <b class="caret"> ${sessionScope.username} </b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="AccountInfoController"><i class="fa fa-user-o"></i><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                                            <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z"/>
                                            </svg> Profile</a></li>
                                    <li><a href="settings.jsp"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-sliders" viewBox="0 0 16 16">
                                            <path fill-rule="evenodd" d="M11.5 2a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zM9.05 3a2.5 2.5 0 0 1 4.9 0H16v1h-2.05a2.5 2.5 0 0 1-4.9 0H0V3h9.05zM4.5 7a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zM2.05 8a2.5 2.5 0 0 1 4.9 0H16v1H6.95a2.5 2.5 0 0 1-4.9 0H0V8h2.05zm9.45 4a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zm-2.45 1a2.5 2.5 0 0 1 4.9 0H16v1h-2.05a2.5 2.5 0 0 1-4.9 0H0v-1h9.05z"/>
                                            </svg>  Settings</a></li>
                                    <li class="divider"></li>
                                    <li><a href="LogoutController"><i class="material-icons">&#xE8AC;</i> Logout</a></li>
                                </ul>
                            </li>  
                        </c:if>



                        <ul class="navbar-nav">

                            <li class="nav-item dropdown no-arrow d-sm-none">
                                <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-search fa-fw"></i>
                                </a>

                                <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                                    <form class="form-inline mr-auto w-100 navbar-search">
                                        <div class="input-group">
                                            <input type="text" class="form-control bg-light" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary" type="button">
                                                    <i class="mdi mdi-magnify"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </li>

                            <c:if test="${ empty name}">              
                                <li class="nav-item dropdown no-arrow mx-2 osahan-t-loc">
                                    <a class="nav-link dropdown-toggle text-dark" href="signin.jsp" >
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd" d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z"/>
                                        <path fill-rule="evenodd" d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
                                        </svg><span class="ml-2">Sign in</span>
                                    </a>
                                </li>

                                <li class="nav-item dropdown no-arrow mx-2 osahan-t-loc">
                                    <a class="nav-link dropdown-toggle text-dark" href="signup.jsp" >
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-in-up" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd" d="M3.5 10a.5.5 0 0 1-.5-.5v-8a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 .5.5v8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 0 0 1h2A1.5 1.5 0 0 0 14 9.5v-8A1.5 1.5 0 0 0 12.5 0h-9A1.5 1.5 0 0 0 2 1.5v8A1.5 1.5 0 0 0 3.5 11h2a.5.5 0 0 0 0-1h-2z"/>
                                        <path fill-rule="evenodd" d="M7.646 4.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 5.707V14.5a.5.5 0 0 1-1 0V5.707L5.354 7.854a.5.5 0 1 1-.708-.708l3-3z"/>
                                        </svg><span class="ml-2">Sign up</span>
                                    </a>
                                </li>
                            </c:if>


                            <li class="nav-item dropdown no-arrow mx-2 osahan-t-bd">
                                <a class="nav-link dropdown-toggle text-dark" data-toggle="modal" data-target="#mycoupansModal" href="#">
                                    <i class="mdi mdi-sack-percent text-warning"></i><span class="ml-2">Best Sale</span>
                                </a>
                            </li>

                            <li class="nav-item dropdown no-arrow mx-2 osahan-t-pu">
                                <a class="nav-link dropdown-toggle text-dark" href="listBlog.jsp">
                                    <i class="mdi mdi-shopping text-danger"></i><span class="ml-2">BLOG</span>
                                </a>
                            </li>


                            <li class="nav-item dropdown no-arrow mx-2 osahan-t-pu">
                                <a class="nav-link dropdown-toggle text-dark" href="contact.jsp">
                                    <i class="mdi mdi-shopping text-danger"></i><span class="ml-2">Liên Hệ</span>
                                </a>
                            </li>



                        </ul>
                    </nav>

                    <c:set var="cust" value="${requestScope.username}" />
                    <c:if test="${empty sessionScope.username}">
                        <div class="container-fluid">

                            <div class="text-center py-5 my-lg-5">
                                <p class="text-grey-500 mb-0">You need to sign in to see Personal Information...</p>
                                <a href="signin.jsp">&larr; Sign in</a>
                            </div>
                        </div>
                    </c:if>



                    <c:if test="${not empty sessionScope.username}">
                        <form action="UpdateAccountController" method="post">
                            <c:set var="errors" value="${requestScope.UPDATE_ERROR}"/>
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">THÔNG TIN CÁ NHÂN</h5>
                                   
                                </div>
                                <div class="modal-body">
                                    <p class="text-dark mb-2 small">Chi Tiết Thông Tin Cá Nhân</p>
                                    <div class="d-flex align-items-center mb-3">
                                        <div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="mdi mdi-account-outline"></i></div>
                                        <div class="w-100">
                                            <p class="mb-0 small font-weight-bold text-dark">TÊN TÀI KHOẢN</p>
                                            <p class="form-control form-control-sm p-0 border-input border-0 rounded-0">${cust.username}</p>
                                            <input name="txtUsername" type="hidden" value="${cust.username}" class="form-control form-control-sm p-0 border-input border-0 rounded-0">
                                        </div>
                                    </div>
                                    <div class="d-flex align-items-center mb-3">
                                        <div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="mdi mdi-account-outline"></i></div>
                                        <div class="w-100">
                                            <p class="mb-0 small font-weight-bold text-dark">MẬT KHẨU</p>
                                            <input name="txtPassword" type="password" value="${cust.password}" class="form-control form-control-sm p-0 border-input border-0 rounded-0" ">
                                        </div>
                                    </div>
                                    <c:if test="${not empty errors.passwordLengthErr}">
                                        <font color='red'>
                                        ${errors.passwordLengthErr}
                                        </font><br/>
                                    </c:if>
                                    <div class="d-flex align-items-center mb-3">
                                        <div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="fas fa-phone-alt"></i></div>
                                        <div class="w-100">
                                            <p class="mb-0 small font-weight-bold text-dark">SỐ ĐIỆN THOẠI</p>
                                            <input name="txtPhoneNum" type="text" value="${cust.phoneNum}" class="form-control form-control-sm p-0 border-input border-0 rounded-0"">
                                        </div>
                                    </div>
                                    <c:if test="${not empty errors.phoneNumLengthErr}">
                                        <font color='red'>
                                        ${errors.phoneNumLengthErr}
                                        </font><br/>
                                    </c:if>
                                    <div class="d-flex align-items-center mb-3">
                                        <div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="mdi mdi-account-outline"></i></div>
                                        <div class="w-100">
                                            <p class="mb-0 small font-weight-bold text-dark">TÊN ĐẦY ĐỦ</p>
                                            <input name="txtCustName" type="text" value="${cust.custName}" class="form-control form-control-sm p-0 border-input border-0 rounded-0"">
                                        </div>
                                    </div>
                                    <c:if test="${not empty errors.fullnameLengthErr}">
                                        <font color='red'>
                                        ${errors.fullnameLengthErr}
                                        </font><br/>
                                    </c:if>
                                    <div class="d-flex align-items-center mb-3">
                                        <div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="mdi mdi-email-outline"></i></i>
                                        </div>
                                        <div class="w-100">
                                            <p class="mb-0 small font-weight-bold text-dark">Email</p>
                                            <input name="txtEmail" type="text" value="${cust.email}" class="form-control form-control-sm p-0 border-input border-0 rounded-0" ">
                                        </div>

                                    </div>
                                    <c:if test="${not empty errors.emailSyntaxErr}">
                                        <font color='red'>
                                        ${errors.emailSyntaxErr}
                                        </font><br/>
                                    </c:if>
                                    <div class="d-flex align-items-center mb-3">
                                        <div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="mdi mdi-email-outline"></i></i>
                                        </div>
                                        <div class="w-100">
                                            <p class="mb-0 small font-weight-bold text-dark">ĐỊA CHỈ</p>
                                            <input name="txtAddress" type="text" value="${cust.address}" class="form-control form-control-sm p-0 border-input border-0 rounded-0" >
                                        </div>
                                    </div>

                                </div>
                                <c:if test="${not empty errors.errorMsg}">
                                    <font color='red'>
                                    ${errors.errorMsg}
                                    </font><br/>
                                </c:if>
                                <div class="modal-footer border-0">
                                    <input type="submit" value="Update profile" name="" data-dismiss="modal" aria-label="Close" class="btn btn-primary btn-block" onclick="showConfirmation()"/>
                                </div>

                            </div>
                        </form>
                    </c:if> 

                </div>


                <footer class="sticky-footer bg-light" >
                    <div class="container my-auto ">
                        <div class="copyright text-center my-auto " style="color: #093b29" >
                            <span >EMAIL: BMOS@gmail.com&copy;</span></br></br>
                            <span>ADDRES:  Q9, HCM, VIET NAM&copy;</span></br></br>
                            <span>HOTLINE: 0931 8888 991&copy;</span>
                        </div>
                    </div>
                </footer>

            </div>

        </div>
        <script>
            function showConfirmation() {
                if (confirm("Are you sure you want to update your profile?")) {
                    // Proceed with the update
                    return true;
                } else {
                    // Cancel the update
                    return false;
                }
            }
        </script>
        <script data-cfasync="false" src="js/email-decode.min.js"></script><script src="vendor/jquery/jquery.min.js" type="8bd97d5fb2c788a96f12455b-text/javascript"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js" type="8bd97d5fb2c788a96f12455b-text/javascript"></script>
        <script src="vendor/jquery-easing/jquery.easing.min.js" type="8bd97d5fb2c788a96f12455b-text/javascript"></script>
        <script src="js/osahan.min.js" type="8bd97d5fb2c788a96f12455b-text/javascript"></script>
        <script src="js/rocket-loader.min.js" data-cf-settings="8bd97d5fb2c788a96f12455b-|49" defer=""></script><script defer src="https://static.cloudflareinsights.com/beacon.min.js/v41822dd307194b3da394f30c241f676d1666031766862" integrity="sha512-p2y/qevlt9/jsokMhKfWLFecGlsaCdYbXFjxQvewNGBVDvrmsBMZ9VN4J2PdUvCrW0PGR9t9+m6eeQhcmRQ6lQ==" data-cf-beacon='{"rayId":"75c6f948bbac7eba","version":"2022.10.3","r":1,"token":"dd471ab1978346bbb991feaa79e6ce5c","si":100}' crossorigin="anonymous"></script>
    </body>

    <!-- Mirrored from askbootstrap.com/preview/osahan-eat/theme-sidebar/404.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Oct 2022 05:04:58 GMT -->
</html>