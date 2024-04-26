<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Khai Tam Book Store - Sign In</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
            background-image: url('https://images.unsplash.com/photo-1481627834876-b7833e8f5570?q=80&w=1856&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'); /* Background image URL */
            background-size: cover;
            background-position: center;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: rgba(255, 255, 255, 0.9); /* Semi-transparent white background */
            border-radius: 10px;
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1);
            padding: 30px;
            max-width: 350px;
            width: 100%;
            text-align: center;
        }

        .logo {
            width: 100px;
            margin-bottom: 20px;
        }

        h1 {
            font-size: 24px;
            margin-bottom: 20px;
            color: #120851;
        }

        p {
            font-size: 14px;
            margin-bottom: 20px;
            color: #333;
        }

        input[type="text"],
        input[type="password"] {
            width: calc(100% - 40px);
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 14px;
            box-sizing: border-box;
        }

        .btn-primary {
            width: calc(100% - 40px);
            padding: 12px;
            background-color: #120851;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
            transition: background-color 0.3s;
        }

        .btn-primary:hover {
            background-color: #0a0542;
        }

        .signup-link {
            color: #120851;
            text-decoration: none;
        }

        .signup-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <img src="img/logo.jpg" alt="Bookstore Logo" class="logo" style="width: 120px;"> <!-- Adjust the width to your desired size -->

        <h1>Đăng Nhập</h1>
        <p>Đăng nhập vào tài khoản của bạn để tiếp tục</p>
        <form action="LoginController" method="post">
            <div class="mb-2">
                <input type="text" name="txtUsername" placeholder="Tên Tài Khoản" required>
            </div>
            <div class="mb-2">
<input type="password" name="txtPassword" placeholder="Mật Khẩu" required>
            </div>
            <c:if test="${not empty requestScope.LOGIN_ERROR.errorMsg}">
                <p style="color: red;">${requestScope.LOGIN_ERROR.errorMsg}</p>
            </c:if>
            <button class="btn-primary" type="submit" name="btAction" value="Login">Đăng Nhập</button>
        </form>
        <p>
            <a href="forgot.jsp" class="signup-link">Quên Mật Khẩu?</a>
            <a href="index.jsp" class="signup-link">Trang Chủ</a>
        </p>
        <p>
            <a href="signup.jsp" class="btn btn-light mb-2">Tạo Tài Khoản</a>
        </p>
    </div>
</body>
</html>