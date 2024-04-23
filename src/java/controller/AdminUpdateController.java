/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import dto.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author THUAN
 */
public class AdminUpdateController extends HttpServlet {
     private final String ADMIN_PAGE = "adminUpdateAccount.jsp";
    private final String ADMIN_P = "AdminController";

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
            response.setContentType("text/html;charset=UTF-8");
        String url = ADMIN_PAGE;
        try {
            String id = request.getParameter("ID");
            AccountDAO dao = new AccountDAO();
            Account user = dao.detailAccount(id);
            request.setAttribute("user", user);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
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
            response.setContentType("text/html;charset=UTF-8");
        String ul = ADMIN_P;
        try (PrintWriter out = response.getWriter()) {
            int _userId = Integer.parseInt(request.getParameter("txt_userId"));
            String _email = request.getParameter("txt_email");
            String _password = request.getParameter("txt_password");
            String _fullname = request.getParameter("txt_fullName");
            int _numberOfLotus = Integer.parseInt(request.getParameter("txt_numberOfLotus"));
            int _roleID = Integer.parseInt(request.getParameter("txt_roleID"));
            int _status = Integer.parseInt(request.getParameter("txt_status"));
            AccountDAO Adao = new AccountDAO();
            Account item = new Account(_userId, _email, _password, _fullname, _numberOfLotus, _roleID, _status);
            Adao.updateAccount(item);
            RequestDispatcher rd = request.getRequestDispatcher(ul);
            rd.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
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
