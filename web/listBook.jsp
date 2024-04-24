<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <!--Mirrored from askbootstrap.com/preview/osahan-eat/theme-sidebar/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Oct 2022 05:04:56 GMT--> 
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" type="image/png" href="img/logo1.png">    
        <title>BMOS PAGE</title>
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="css/osahan.css" rel="stylesheet">
        <link href="font/stylesheet.css" rel="stylesheet">
        <link href="vendor/mdi-icons/css/materialdesignicons.min.css" rel="stylesheet">
        <link href="css/custom.css" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="path/to/materialize.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="assets/imgs/theme/favicon.svg">
        <!-- Template CSS -->
        <link rel="stylesheet" href="assets/css/main.css?v=3.4">
    </head>
    <body id="page-top">
        <div id="wrapper">
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
                <a class="sidebar-brand d-flex align-items-center" href="HomeController">
                    <div class="sidebar-brand-icon">
                        <img src="img/logo1.png" width="50" class="img-fluid">
                    </div>
                </a>
                <li class="nav-item active">
                    <a class="nav-link" href="HomeController">
                        <i class="mdi mdi-home-variant-outline"></i>
                        <span>Trang Chủ</span></a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="HistoryOrderController">
                        <i class="mdi mdi-book-open"></i>
                        <span>Lịch Sử Đặt Hàng</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="setting.jsp">
                        <i class="mdi mdi-cog"></i>
                        <span>Cài Đặt</span></a>
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
                                    <li><a href="LogoutController"><i class="material-icons">&#xE8AC;</i>Logout</a></li>
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
                                <a class="nav-link dropdown-toggle text-dark" href="contact.jsp">
                                    <i class="mdi mdi-shopping text-danger"></i><span class="ml-2">Liên Hệ</span>
                                </a>
                            </li>
                        </ul>
                        <div class="ml-auto">
                            <form class="d-none d-sm-inline-block form-inline mx-2 my-2 my-md-0 mw-100 navbar-search" action="MainController">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light text-dark font-weight-bold" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2" name="txtSearchValue" value="">
                                    <div class="input-group-append">
                                        <input class="btn btn-primary" type="submit" value="Find Product" name="btAction" >
                                    </div>
                                </div>
                            </form>
                            <a href="ViewCartController" class="btn btn-outline-dark">
                                <i class="bi-cart-fill me-1"></i>
                                Cart
                                <%
                                    cart.Cart cart = (cart.Cart) session.getAttribute("CART"); // Lấy đối tượng Cart từ session
                                    int totalQuantity = 0; // Khởi tạo tổng số lượng

                                    // Kiểm tra xem giỏ hàng có tồn tại không
                                    if (cart != null) {
                                        totalQuantity = cart.getTotalQuantity(); // Gọi phương thức getTotalQuantity để lấy tổng số lượng sản phẩm
                                    }
                                %>
                                <span class="badge bg-dark text-white ms-1 rounded-pill"><%= totalQuantity%></span> <!-- Hiển thị tổng số lượng -->
                            </a>
                        </div>
                    </nav>




                    <!-- 
                                 //SHOW THONG TIN CAC LOAI SACH
                                 //SHOW CAC LOAI SACH + THONG TIN CHI TIET LOAI SACH + ...    
                    -->  



                    <div class="main-menu main-menu-padding-1 main-menu-lh-2 d-none d-lg-block">
                        <nav>
                            <ul>
                                <c:forEach var="category" items="${listCategory}">
                                    <li>
                                        <a href="SubCateController?cateId=${category.categoryID}">${category.categoryName} <i class="fi-rs-angle-down"></i></a>
                                        <ul class="sub-menu">
                                            <c:forEach var="subCategory" items="${listSubCategory}">
                                                <c:if test="${subCategory.categoryId == category.categoryID}">
                                                    <li>
                                                        <a href="ListBookController?cateId=${category.categoryID}&subId=${subCategory.subcategoryID}">
                                                            ${subCategory.subName}
                                                        </a>
                                                    </li>
                                                </c:if>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                </c:forEach>
                            </ul>
                        </nav>
                    </div>

                    <div class="container-fluid">
                        <div class="row">
                            <div class="container-fluid">
                                <div class="d-flex align-items-center justify-content-between mb-3 mt-2">
                                    <h5 class="mb-0">TẤT CẢ SÁCH</h5>
                                </div>
                            </div>
                            <div class="container">
                                <div class="row d-flex justify-content-around"> <!-- Đảm bảo mỗi hàng chứa 4 thẻ sách -->
                                    <c:forEach var="book" items="${bookList}">
                                        <div class="col-xl-3 col-md-4 mb-4"> <!-- Chia mỗi hàng 4 cuốn sách -->
                                            <a href="BookDetailController?bookId=${book.bookId}" class="text-decoration-none">
                                                <div class="card h-100"> <!-- Chiều cao cố định cho mỗi thẻ -->
                                                    <img class="card-img-top" src="https://product.hstatic.net/200000017360/product/hh_nhungkhucnhac_hayvade_b1_10ed9b36960e4f44946fc10f9b8e520d_compact.jpg" alt="Hình minh họa" style="height: 200px; object-fit: cover;"> <!-- Chiều cao hình ảnh đồng đều -->
                                                    <div class="card-body d-flex flex-column justify-content-between"> <!-- Sử dụng Flex để đảm bảo nội dung đồng đều -->
                                                        <p class="card-text">${book.bookName}</p> <!-- Tên sách -->
                                                        <p class="card-text text-danger font-weight-bold">${book.unitPrice}đ</p> <!-- Giá sách màu đỏ -->
                                                    </div>
                                                </div>
                                            </a>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>



                        </div>
                    </div>


                    <!-- 
                        Show thêm các Sản Phẩm nổi bật
                    -->       

                    <!-- 
                
                //SHOW THUC AN THEO LOAI 
                    -->  

                </div>                       









                <!-- 
                 //FOOTER                
                -->   
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





        <!-- Vendor JS-->
        <script src="assets/js/vendor/modernizr-3.6.0.min.js"></script>
        <script src="assets/js/vendor/jquery-3.6.0.min.js"></script>
        <script src="assets/js/vendor/jquery-migrate-3.3.0.min.js"></script>
        <script src="assets/js/vendor/bootstrap.bundle.min.js"></script>
        <script src="assets/js/plugins/slick.js"></script>
        <script src="assets/js/plugins/jquery.syotimer.min.js"></script>
        <script src="assets/js/plugins/wow.js"></script>
        <script src="assets/js/plugins/jquery-ui.js"></script>
        <script src="assets/js/plugins/perfect-scrollbar.js"></script>
        <script src="assets/js/plugins/magnific-popup.js"></script>
        <script src="assets/js/plugins/select2.min.js"></script>
        <script src="assets/js/plugins/waypoints.js"></script>
        <script src="assets/js/plugins/counterup.js"></script>
        <script src="assets/js/plugins/jquery.countdown.min.js"></script>
        <script src="assets/js/plugins/images-loaded.js"></script>
        <script src="assets/js/plugins/isotope.js"></script>
        <script src="assets/js/plugins/scrollup.js"></script>
        <script src="assets/js/plugins/jquery.vticker-min.js"></script>
        <!-- Template  JS -->
        <script src="./assets/js/main.js?v=3.4"></script>
        <script src="./assets/js/shop.js?v=3.4"></script>                            
        <script data-cfasync="false" src="js/email-decode.min.js"></script>
        <script src="vendor/jquery/jquery.min.js" type="e83057937dd4e85910db8985-text/javascript"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js" type="e83057937dd4e85910db8985-text/javascript"></script>
        <script src="vendor/jquery-easing/jquery.easing.min.js" type="e83057937dd4e85910db8985-text/javascript"></script>
        <script src="js/osahan.min.js" type="e83057937dd4e85910db8985-text/javascript"></script>
        <script src="js/rocket-loader.min.js" data-cf-settings="e83057937dd4e85910db8985-|49" defer=""></script><script defer src="https://static.cloudflareinsights.com/beacon.min.js/v652eace1692a40cfa3763df669d7439c1639079717194" integrity="sha512-Gi7xpJR8tSkrpF7aordPZQlW2DLtzUlZcumS8dMQjwDHEnw9I7ZLyiOj/6tZStRBGtGgN6ceN6cMH8z7etPGlw==" data-cf-beacon='{"rayId":"75c6f93a1e227d56","version":"2022.10.3","r":1,"token":"dd471ab1978346bbb991feaa79e6ce5c","si":100}' crossorigin="anonymous"></script>
        <script src="path/to/your/bundle.js"></script>

    </body>

    <!-- Mirrored from askbootstrap.com/preview/osahan-eat/theme-sidebar/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Oct 2022 05:04:56 GMT -->
</html>
