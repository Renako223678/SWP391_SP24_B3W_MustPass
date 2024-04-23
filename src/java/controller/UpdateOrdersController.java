/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrderDAO;
import dao.OrderDetailDAO;
import dto.Order;
import dto.OrderDetail;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author THUAN
 */
public class UpdateOrdersController extends HttpServlet {
 
    private final String MANGER_PAGE = "StaffUpdateOrders.jsp";
    private final String MANGER_P = "ManagerOrdersController";

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
             String url = MANGER_PAGE;
        try {
            String id = request.getParameter("ID");
            OrderDAO dao = new OrderDAO();
            Order user = dao.detailOrders(id);
            request.setAttribute("book", user);

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
        String ul = MANGER_P;
        try (PrintWriter out = response.getWriter()) {
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            String description = request.getParameter("description");
            Date orderDate = Date.valueOf(request.getParameter("orderDate"));
            float shipFee = Float.parseFloat(request.getParameter("shipFee"));
            int usedLotusBub = Integer.parseInt(request.getParameter("usedLotusBub"));
            float totalPrice = Float.parseFloat(request.getParameter("totalPrice"));
            float finalPrice = Float.parseFloat(request.getParameter("finalPrice"));
            int userId = Integer.parseInt(request.getParameter("userId"));
            int recipientId = Integer.parseInt(request.getParameter("recipientId"));
            int status = Integer.parseInt(request.getParameter("status"));
       
            OrderDAO Adao = new OrderDAO();
            Order item = new Order(orderId, description, orderDate, shipFee, usedLotusBub, totalPrice, finalPrice, status, userId, recipientId);
            Adao.updateOrders(item);
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

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
