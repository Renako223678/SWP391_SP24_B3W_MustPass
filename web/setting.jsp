<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from askbootstrap.com/preview/osahan-eat/theme-sidebar/settings.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Oct 2022 05:04:57 GMT -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" type="image/png" href="img/logo1.png">

        <title>BMOS Setting</title>

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
                        <span>Trang Chủ</span></a>
                </li>


                <li class="nav-item">
                    <a class="nav-link" href="#HistoryOrderController?username=${sessionScope.username}">
                        <i class="mdi mdi-book-open"></i>
                        <span>Lịch Sử</span></a>
                </li>



                <li class="nav-item">
                    <a class="nav-link" href="setting.jsp">
                        <i class="mdi mdi-cog"></i>
                        <span>Cài Đặt</span></a>
                </li>


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
                                    <li><a href="#"><i class="fa fa-user-o"></i><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
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
                                        </svg><span class="ml-2">Đăng Nhập</span>
                                    </a>
                                </li>

                                <li class="nav-item dropdown no-arrow mx-2 osahan-t-loc">
                                    <a class="nav-link dropdown-toggle text-dark" href="signup.jsp" >
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-in-up" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd" d="M3.5 10a.5.5 0 0 1-.5-.5v-8a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 .5.5v8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 0 0 1h2A1.5 1.5 0 0 0 14 9.5v-8A1.5 1.5 0 0 0 12.5 0h-9A1.5 1.5 0 0 0 2 1.5v8A1.5 1.5 0 0 0 3.5 11h2a.5.5 0 0 0 0-1h-2z"/>
                                        <path fill-rule="evenodd" d="M7.646 4.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 5.707V14.5a.5.5 0 0 1-1 0V5.707L5.354 7.854a.5.5 0 1 1-.708-.708l3-3z"/>
                                        </svg><span class="ml-2">Đăng Ký</span>
                                    </a>
                                </li>
                            </c:if>

                            <li class="nav-item dropdown no-arrow mx-2 osahan-t-pu">
                                <a class="nav-link dropdown-toggle text-dark" href="index.jsp">
                                    <i class="mdi mdi-shopping text-danger"></i><span class="ml-2">Pick up</span>
                                </a>
                            </li>

                            <li class="nav-item dropdown no-arrow mx-2 osahan-t-bd">
                                <a class="nav-link dropdown-toggle text-dark" data-toggle="modal" data-target="#mycoupansModal" href="#">
                                    <i class="mdi mdi-sack-percent text-warning"></i><span class="ml-2">Best Deals</span>
                                </a>
                            </li>
                        </ul>
                    </nav>


                    <div class="container-fluid pb-4">

                        <div class="d-flex align-items-center justify-content-between mb-3 mt-2">
                            <h5 class="mb-0">Settings</h5>
                        </div>
                      
                        <p class="mb-2">General</p>
                        <a href="#GetAccInfoController?cusername=${sessionScope.username}" class="text-decoration-none text-dark d-flex align-items-center rounded bg-white shadow-sm p-3 mb-1">
                            <p class="mb-0 h5 text-primary"><i class="mdi mdi-account-outline"></i></p>
                            <p class="ml-3 mb-0">THÔNG TIN CÁC NHÂN</p>
                            <p class="mb-0 h5 ml-auto"><i class="mdi mdi-chevron-right"></i></p>
                        </a>


                        <p class="mt-4 mb-2">Other</p>
                        <a class="text-decoration-none text-dark d-flex align-items-center rounded bg-white shadow-sm p-3 mb-1" data-toggle="modal" data-target="#supportModal">
                            <p class="mb-0 h5 text-primary"><i class="mdi mdi-progress-question"></i></p>
                            <p class="ml-3 mb-0">HỖ TRỢ</p>
                            <p class="mb-0 h5 ml-auto"><i class="mdi mdi-chevron-right"></i></p>
                        </a>


                        <a class="text-decoration-none text-dark d-flex align-items-center rounded bg-white shadow-sm p-3 mb-1" data-toggle="modal" data-target="#discountsModal">
                            <p class="mb-0 h5 text-warning"><i class="mdi mdi-currency-usd-circle"></i></p>
                            <p class="ml-3 mb-0">GIẢM GIÁ</p>
                            <p class="mb-0 h5 ml-auto"><i class="mdi mdi-chevron-right"></i></p>
                        </a>



                        <a href="LogoutController" class="text-decoration-none text-dark d-flex align-items-center rounded bg-white shadow-sm p-3 mb-1" >
                            <p style="text-align: center" class="ml-3 h8 mb-0">ĐĂNG XUẤT</p>
                        </a>

                    </div>
                </div>


                <footer class="sticky-footer bg-white">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>BMOS &copy; HCM,VIETNAME</span>
                        </div>
                    </div>
                </footer>

            </div>
        </div>



        <div class="modal fade" id="supportModal" tabindex="-1" aria-labelledby="" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel" style="color: brown">HỖ TRỢ</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="d-flex align-items-center mb-3">
                            <div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="mdi mdi-email-outline"></i></i>
                            </div>
                            <div>
                                <p class="small font-weight-bold text-dark mb-0" style="color: brown">CHAT TRỰC TIẾP</p>
                                <P class="mb-0 small">Waiting time: <span class="font-weight-bold text-dark">5 min</span></P>
                            </div>
                        </div>

                        <div class="d-flex align-items-center mb-3">
                            <div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="mdi mdi-email-outline"></i></i>
                            </div>
                            <div>
                                <p class="small font-weight-bold text-dark mb-0" style="color: brown">EMAIL</p>
                                <P class="mb-0 small">bmos@gmail.com</P>
                            </div>
                        </div>

                        <div class="d-flex align-items-center mb-3">
                            <div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="mdi mdi-book-open"></i></div>
                            <div>
                                <p class="small font-weight-bold text-dark mb-0" style="color: brown"> ĐỊA CHỈ</p>
                                <P class="mb-0 small">Q9, HCM, Vietnam</P>
                            </div>
                        </div>
                        <div class="d-flex align-items-center mb-3">
                            <div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="fas fa-phone-alt"></i></div>
                            <div>
                                <p class="small font-weight-bold text-dark mb-0" style="color: brown">SDT LIÊN HỆ</p>
                                <P class="mb-0 small">+84 333 888 257</P>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer border-0">
                        <button data-dismiss="modal" aria-label="Close" class="btn btn-primary btn-block">THANKS YOU!!</button>
                    </div>
                </div>
            </div>
        </div>


        <div class="modal fade" id="discountsModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel" style="color: brown; text-align: center">GIẢM GIÁ</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="bg-light rounded border d-flex justify-content-between align-items-center flex-column px-4 py-3 mb-2">
                            <h1 class="text-primary mb-0">FANPAGE</h1>
                            <P class="mb-0 smal"> <a href="https://www.facebook.com/profile.php?id=100093038830955">LINK FANPAGE</a></P>
                        </div>
                        <div class="bg-light rounded border d-flex justify-content-between align-items-center flex-column px-4 py-3 mb-2">
                            <h1 class="text-primary mb-0">TIKTOK-SHOP</h1>
                            </br>
                            <P class="mb-0 smal">Following shop để cập nhật giá tốt nhât !!</P>
                            <P class="mb-0 smal">18H - Mỗi ngày!!</P>
                        </div>
                    </div>
                    <div class="modal-footer border-0">
                        <button data-dismiss="modal" aria-label="Close" class="btn btn-primary btn-block">THANKS YOU!!</button>
                    </div>
                </div>
            </div>
        </div>






        <script data-cfasync="false" src="js/email-decode.min.js"></script><script src="vendor/jquery/jquery.min.js" type="2e4121bc3a5953068db435fa-text/javascript"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js" type="2e4121bc3a5953068db435fa-text/javascript"></script>
        <script src="vendor/jquery-easing/jquery.easing.min.js" type="2e4121bc3a5953068db435fa-text/javascript"></script>
        <script src="js/osahan.min.js" type="2e4121bc3a5953068db435fa-text/javascript"></script>
        <script src="js/rocket-loader.min.js" data-cf-settings="2e4121bc3a5953068db435fa-|49" defer=""></script><script defer src="https://static.cloudflareinsights.com/beacon.min.js/v652eace1692a40cfa3763df669d7439c1639079717194" integrity="sha512-Gi7xpJR8tSkrpF7aordPZQlW2DLtzUlZcumS8dMQjwDHEnw9I7ZLyiOj/6tZStRBGtGgN6ceN6cMH8z7etPGlw==" data-cf-beacon='{"rayId":"75c6f9410bc57d56","version":"2022.10.3","r":1,"token":"dd471ab1978346bbb991feaa79e6ce5c","si":100}' crossorigin="anonymous"></script>
    </body>

    <!-- Mirrored from askbootstrap.com/preview/osahan-eat/theme-sidebar/settings.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Oct 2022 05:04:57 GMT -->
</html>