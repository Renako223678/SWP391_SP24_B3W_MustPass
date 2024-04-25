/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import dao.OrderDAO;
import dao.OrderRevenueDAO;
import dao.RecipientDAO;
import dto.Account;
import dto.Order;
import dto.OrderRevenue;
import dto.Recipient;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author THUAN
 */
public class ManagerRevenueController extends HttpServlet {

    private final String ERROR = "404.jsp";
    private final String MANAGER_PAGE = "ManagerRevenue.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = MANAGER_PAGE;
        try {
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            
            if (startDate == null || endDate == null || startDate.isEmpty() || endDate.isEmpty()) {
                startDate = "2023-01-01 00:00:00";
                endDate = "2029-01-01 23:59:59";
            }
            
            String txtSearch = request.getParameter("txtSearch");
            if (txtSearch == null) {
                txtSearch = "";
            }
            HttpSession session = request.getSession();
            OrderDAO dao = new OrderDAO();
            List<Order> listItem = dao.getALLOrder();
            request.setAttribute("list", listItem);
            
            
            AccountDAO adao = new AccountDAO();
            List<Account> listItemss = adao.getAllAccount();
            request.setAttribute("aclist", listItemss);
            
            RecipientDAO Rdao = new RecipientDAO();
            List<Recipient> listItemr = Rdao.getAllListRecipient();
            request.setAttribute("rlist", listItemr);
            
            OrderRevenueDAO rdao = new OrderRevenueDAO();
            List<OrderRevenue> revlist = rdao.getTotalRevenueByDateRange(startDate, endDate);
            request.setAttribute("revlist", revlist);
            
            url = MANAGER_PAGE;
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerRevenueController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerRevenueController.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerRevenueController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerRevenueController.class.getName()).log(Level.SEVERE, null, ex);
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
