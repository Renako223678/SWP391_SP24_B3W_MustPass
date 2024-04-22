<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from askbootstrap.com/preview/osahan-eat/theme-sidebar/signup.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Oct 2022 05:04:58 GMT -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" type="image/png" href="img/logo1.png">
        <title>BMOS </title>
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="css/osahan.css" rel="stylesheet">
        <link href="font/stylesheet.css" rel="stylesheet">
        <link href="vendor/mdi-icons/css/materialdesignicons.min.css" rel="stylesheet">
        <link href="css/custom.css" rel="stylesheet">
    </head>
    <body id="page-top">
        <div class="row osahan-login m-0">
            <div class="col-md-3  px-10">
            </div>
            <!-- 
            //Create account
            -->
            <div class="col-md-6 d-flex justify-content-center flex-column px-0">
                <br /><br /><br />
                <div class="col-lg-6 mx-auto">
                    <h1 class="mb-1" style="color: red">TẠO TÀI KHOẢN</h1>
                    <p class="mb-5">Vui lòng tạo một tài khoản để tiếp tục sử dụng dịch vụ của chúng tôi</p>
                    <form action="MainController" method="post">
                        <c:set var="errors" value="${requestScope.CREATE_ERROR}"/>
                        <div class="d-flex align-items-center mb-4">
                            <div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="mdi mdi-email-outline"></i></i></div>
                            <div class="w-100">
                                <p class="mb-0 small font-weight-bold text-dark">TÊN ĐĂNG NHẬP* (6-20 chars)</p>
                                <input type="text" name="txtEmail" class="form-control form-control-sm p-0 border-input border-0 rounded-0" placeholder="Nhập email">
                            </div>
                        </div>
                        <c:if test="${not empty errors.emailLengthErr}">
                            <font color='red'>
                            ${errors.emailLengthErr}
                            </font><br/>
                        </c:if>
                        <c:if test="${not empty errors.emailExisted}">
                            <font color='red'>
                            ${errors.emailExisted}
                            </font><br/>
                        </c:if>
                        <div class="d-flex align-items-center mb-4">
                            <div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="mdi mdi-form-textbox-password"></i></div>
                            <div class="w-100">
                                <p class="mb-0 small font-weight-bold text-dark">MẬT KHẨU* (6-20 chars)</p>
                                <input type="password" class="form-control form-control-sm p-0 border-input border-0 rounded-0" placeholder="Nhập mật khẩu" name="txtPassword">
                            </div>
                        </div>
                        <c:if test="${not empty errors.passwordLengthErr}">
                            <font color='red'>
                            ${errors.passwordLengthErr}
                            </font><br/>
                        </c:if>
                        <div class="d-flex align-items-center mb-4">
                            <div class="mr-3 bg-light rounded p-2 osahan-icon"><i class="mdi mdi-form-textbox"></i></div>
                            <div class="w-100">
                                <p class="mb-0 small font-weight-bold text-dark">TÊN ĐẦY ĐỦ (2-50 chars)</p>
                                <input type="text" name="txtFullname" class="form-control form-control-sm p-0 border-input border-0 rounded-0" placeholder="Enter Your Fullname">
                            </div>
                        </div>
                        <c:if test="${not empty errors.fullnameLengthErr}">
                            <font color='red'>
                            ${errors.fullnameLengthErr}
                            </font><br/>
                        </c:if>
                            <input type="submit" class="btn btn-primary" name="btAction" value="Sign up"/>




                        <div class="mb-3">
                            <p class="text-center">BẠN ĐÃ CÓ TÀI KHOẢN ? <a href="signin.jsp" class="text-danger text-decoration-none">ĐĂNG NHẬP</a></p>
                            <p class="text-center">VỀ <a href="index.jsp" class="text-danger text-decoration-none">TRANG CHỦ</a>
                        </div>


                        <%--
                        <c:if test="${not empty errors.errorMsg}">
                            <font color='red'>
                            ${errors.errorMsg}
                            </font><br/>
                        </c:if>
                        --%>
                    </form>
                </div>
            </div>
        </div>

        <script src="vendor/jquery/jquery.min.js" type="105ae87169facef54e7f3cf4-text/javascript"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js" type="105ae87169facef54e7f3cf4-text/javascript"></script>
        <script src="vendor/jquery-easing/jquery.easing.min.js" type="105ae87169facef54e7f3cf4-text/javascript"></script>
        <script src="js/osahan.min.js" type="105ae87169facef54e7f3cf4-text/javascript"></script>
        <script src="js/rocket-loader.min.js" data-cf-settings="105ae87169facef54e7f3cf4-|49" defer=""></script><script defer src="https://static.cloudflareinsights.com/beacon.min.js/v652eace1692a40cfa3763df669d7439c1639079717194" integrity="sha512-Gi7xpJR8tSkrpF7aordPZQlW2DLtzUlZcumS8dMQjwDHEnw9I7ZLyiOj/6tZStRBGtGgN6ceN6cMH8z7etPGlw==" data-cf-beacon='{"rayId":"75c6f94d7bbf7eba","version":"2022.10.3","r":1,"token":"dd471ab1978346bbb991feaa79e6ce5c","si":100}' crossorigin="anonymous"></script>
    </body>

    <!-- Mirrored from askbootstrap.com/preview/osahan-eat/theme-sidebar/signup.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Oct 2022 05:04:58 GMT -->
</html>