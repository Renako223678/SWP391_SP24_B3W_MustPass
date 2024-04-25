package controller;

import dao.OrderDAO;
import dao.OrderDetailDAO;
import dto.Account;
import dto.Order;
import dto.OrderDetail;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Quanglatui
 */
@WebServlet(name = "HistoryOrderController", urlPatterns = {"/HistoryOrderController"})
public class HistoryOrderController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "historyOrder.jsp";
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("LOGIN_USER");
        int userId = account.getUserId();
        String status = request.getParameter("status");
        List<Order> listOrder = new ArrayList<>();
        OrderDAO dao = new OrderDAO();
        if (status == null) {
            listOrder = dao.getOrderByUserIDAndStatus(userId, 1);
            request.setAttribute("listHistoryOrder", listOrder);
            OrderDetailDAO orderDetailDao = new OrderDetailDAO();
            Map<Integer, List<OrderDetail>> orderDetailMap = new HashMap<>();
            for (Order order : listOrder) {
                int orderId = order.getOrderId(); // Lấy OrderID
                List<OrderDetail> listOrderDetail = orderDetailDao.getOrderDetailByOrderIDAndBookName(orderId); // Lấy chi tiết
                orderDetailMap.put(orderId, listOrderDetail); // Thêm vào Map
            }
            request.setAttribute("orderDetailMap", orderDetailMap);
            request.getRequestDispatcher(url).forward(request, response);
        }
        listOrder = dao.getOrderByUserIDAndStatus(userId, Integer.parseInt(status));
        request.setAttribute("listHistoryOrder", listOrder);
        OrderDetailDAO orderDetailDao = new OrderDetailDAO();
        Map<Integer, List<OrderDetail>> orderDetailMap = new HashMap<>();
        for (Order order : listOrder) {
            int orderId = order.getOrderId(); // Lấy OrderID
            List<OrderDetail> listOrderDetail = orderDetailDao.getOrderDetailByOrderIDAndBookName(orderId); // Lấy chi tiết
            orderDetailMap.put(orderId, listOrderDetail); // Thêm vào Map
        }
        request.setAttribute("orderDetailMap", orderDetailMap);
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
