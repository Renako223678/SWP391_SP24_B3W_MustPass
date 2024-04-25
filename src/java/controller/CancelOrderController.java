package controller;

import dao.BookDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import dto.Book;
import dto.Order;
import dto.OrderDetail;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Quanglatui
 */
@WebServlet(name = "CancelOrderController", urlPatterns = {"/CancelOrderController"})
public class CancelOrderController extends HttpServlet {

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
        String orderID = request.getParameter("orderId");
        OrderDAO dao = new OrderDAO();
        dao.cancelOrders(Integer.parseInt(orderID));
        List<OrderDetail> listOrderDetail = new ArrayList<>();
        OrderDetailDAO orderDetailDao = new OrderDetailDAO();
        listOrderDetail = orderDetailDao.getOrderDetailByOrderID(Integer.parseInt(orderID));
        BookDAO bookdao = new BookDAO();
        Book bookOriginal = new Book();
        for (OrderDetail orderDetail : listOrderDetail) {
            bookOriginal =bookdao.getBookByID(orderDetail.getBookId());
            int addedQuantity = bookOriginal.getQuantity() + orderDetail.getQuantity(); 
            bookOriginal.setQuantity(addedQuantity);
            bookdao.updateBook(bookOriginal);
            }
        request.getRequestDispatcher("HistoryOrderController").forward(request, response);
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
