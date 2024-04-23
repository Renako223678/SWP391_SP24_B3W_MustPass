/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.AccountDAO;
import dto.Account;
import dto.CreateAccountError;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author THUAN
 */
public class CreateNewAccountController extends HttpServlet {

    private final String CREATE_NEW_ACCOUNT_ERROR = "signup.jsp";
    private final String LOGIN_PAGE = "signin.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //  PrintWriter out = response.getWriter();
        String url = CREATE_NEW_ACCOUNT_ERROR;
        try {
            boolean checkValidation = true;
            AccountDAO dao = new AccountDAO();
            String email = request.getParameter("txtEmail");
            String password = request.getParameter("txtPassword");
            String fullname = request.getParameter("txtFullname");
            CreateAccountError cusError = new CreateAccountError();
            if (fullname.length() > 50 || email.length() < 2) {
                cusError.setFullnameLengthErr("Độ dài họ và tên phải từ 6-20 kí tự!");
                checkValidation = false;
                if (fullname == "") {
                    cusError.setFullnameLengthErr("Họ và tên không được để trống!");
                }
            }
            if (password.length() < 6 || password.length() >20) {
                cusError.setPasswordLengthErr("Mật khẩu nên dài từ 6-20 kí tự!");
                checkValidation = false;
                if (password == "") {
                    cusError.setPasswordLengthErr("Mật khẩu không được để trống");
                }
            }
            if (email.length() < 6 || email.length() >20) {
                cusError.setEmailLengthErr("Email nên dài từ 8 kí tự trở lên");
                checkValidation = false;
                if (email == "") {
                    cusError.setEmailLengthErr("Email không được để trống");
                }
            }
            if (dao.findAccount(email) != null) {
                cusError.setEmailExisted("Email bị trùng");
                checkValidation = false;
            }
            if(checkValidation){
                Account ac = new Account(email, password, fullname, 0, 3,1);
                dao.createAccount(ac);
                url = LOGIN_PAGE;
            } else{
                request.setAttribute("CREATE_ERROR", cusError);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
