/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.RecipientDAO;
import dto.Account;
import dto.Order;
import dto.OrderDetail;
import dto.Recipient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author VU
 */
public class DetailsOrdersController extends HttpServlet {

    private final String MANGER_PAGE = "StaffDetailsOrders.jsp";


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = MANGER_PAGE;
        try {
            String id = request.getParameter("ID");
            OrderDetailDAO dao = new OrderDetailDAO();
            List<OrderDetail> user = dao.getOrderDetailByOrderIDs(id);
            request.setAttribute("book", user);
            
            RecipientDAO Rdao = new RecipientDAO();
            List<Recipient> listItemr = Rdao.getAllListRecipient();
            request.setAttribute("rlist", listItemr);

            AccountDAO adao = new AccountDAO();
            List<Account> listItemss = adao.getAllAccount();
            request.setAttribute("aclist", listItemss);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
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
