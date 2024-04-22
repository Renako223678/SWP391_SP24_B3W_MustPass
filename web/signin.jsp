<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from askbootstrap.com/preview/osahan-eat/theme-sidebar/signin.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Oct 2022 05:04:58 GMT -->
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
    <body id="page-top" style="background: whitesmoke">


        <div class="row osahan-login m-0" >
            <div class="col-md-3  px-10">
            </div>
            <div class="col-md-6 d-flex justify-content-center flex-column px-0 w-100" >
                <div class="col-lg-6 mx-auto">
                    <h1 class="mb-2 w-100" style="margin-top: 50%; color: #120851 ">CHÀO MỪNG ĐẾN VỚI BMOS</h1>
                    <p class="mb-5" style="color: red">Đăng nhập vào tài khoản của bạn để tiếp tục</p>
                    <form action="LoginController" method="post">
                        <div class="d-flex align-items-center mb-4">
                            <div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="mdi mdi-email-outline"></i></div>
                            <div class="w-100">
                                <p class="mb-0 small font-weight-bold text-dark">TÊN TÀI KHOẢN</p>
                                <input type="text" class="form-control form-control-sm p-0 border-input border-0 rounded-0" placeholder="Enter Your Usename" name="txtUsername">
                            </div>
                        </div>
                        <div class="d-flex align-items-center mb-4">
                            <div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="mdi mdi-form-textbox-password"></i></div>
                            <div class="w-100">
                                <p class="mb-0 small font-weight-bold text-dark">MẬT KHẨU</p>
                                <input type="password" class="form-control form-control-sm p-0 border-input border-0 rounded-0" placeholder="Enter Password" name="txtPassword">
                            </div>
                        </div>

                        <c:if test="${not empty requestScope.LOGIN_ERROR.errorMsg}">
                            <font color='red'>
                            ${requestScope.LOGIN_ERROR.errorMsg}
                            </font> 
                        </c:if> <br></br>


                        <div class="pt-1 mb-4">
                            <button class="btn btn-dark btn-lg btn-block" type="submit" name="btAction" value="Login">ĐĂNG NHẬP</button>
                        </div>


                        <p class="text-center">
                            <a href="forgot.jsp" class="text-red">QUÊN MẬT KHẨU ?</a>
                            <a href="index.jsp" class="text-red" >&nbsp&nbsp&nbsp&nbsp TRANG CHỦ</a>
                        </p>
                        <p class="text-center">
                            <a href="signup.jsp" class="btn btn-light btn-block mb-2">TẠO TÀI KHOẢN</a>
                        </p>

                </div>
                </form>
            </div>
        </div>
    </div>

    <script src="vendor/jquery/jquery.min.js" type="b91dad79aa96a1edb6837dad-text/javascript"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js" type="b91dad79aa96a1edb6837dad-text/javascript"></script>
    <script src="vendor/jquery-easing/jquery.easing.min.js" type="b91dad79aa96a1edb6837dad-text/javascript"></script>
    <script src="js/osahan.min.js" type="b91dad79aa96a1edb6837dad-text/javascript"></script>
    <script src="js/rocket-loader.min.js" data-cf-settings="b91dad79aa96a1edb6837dad-|49" defer=""></script><script defer src="https://static.cloudflareinsights.com/beacon.min.js/v652eace1692a40cfa3763df669d7439c1639079717194" integrity="sha512-Gi7xpJR8tSkrpF7aordPZQlW2DLtzUlZcumS8dMQjwDHEnw9I7ZLyiOj/6tZStRBGtGgN6ceN6cMH8z7etPGlw==" data-cf-beacon='{"rayId":"75c6f94c39d87d56","version":"2022.10.3","r":1,"token":"dd471ab1978346bbb991feaa79e6ce5c","si":100}' crossorigin="anonymous"></script>
</body>

<!-- Mirrored from askbootstrap.com/preview/osahan-eat/theme-sidebar/signin.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Oct 2022 05:04:58 GMT -->
</html>