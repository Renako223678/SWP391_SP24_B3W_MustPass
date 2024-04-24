package controller;

import cart.Cart;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import dto.Account;
import dto.Book;
import dto.Order;
import dto.OrderDetail;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddOrderController", urlPatterns = {"/AddOrderController"})
public class AddOrderController extends HttpServlet {

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
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("CART");
        Account account = (Account) session.getAttribute("LOGIN_USER");

        try {
            // Tạo đối tượng Order
            Order order = new Order();
//            order.setOrderDate(new Date(0)); // Ngày tạo đơn hàng hiện tại
            order.setTotalPrice(cart.getTotalMoney()); // Tổng giá trị từ giỏ hàng
            // Đặt các giá trị khác nếu cần thiết (ví dụ: userId, shipFee, v.v.)
            order.setShipFee(50000);
            order.setStatus(1);
            LocalDate today = LocalDate.now();

            Date sqlDate = Date.valueOf(today);

            order.setOrderDate(sqlDate);
            order.setFinalPrice(cart.getTotalMoney() + order.getShipFee());
            OrderDAO orderDAO = new OrderDAO();
            int orderId = orderDAO.createOrder(order, account.getUserId()); // Tạo Order và lấy ID

            // Tạo các OrderDetail từ giỏ hàng
            OrderDetailDAO orderDetailDAO = new OrderDetailDAO();

            for (Book book : cart.getCart().values()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderId(orderId);
                orderDetail.setBookId(book.getBookId()); // Chuyển đổi ID thành int
                orderDetail.setQuantity(book.getQuantity());
                orderDetail.setUnitPrice(book.getUnitPrice());
                orderDetail.setTotalPrice(book.getQuantity() * book.getUnitPrice());
                // Đặt các giá trị khác nếu cần thiết

                orderDetailDAO.createOrderDetail(orderDetail); // Tạo OrderDetail
            }

            // Xóa giỏ hàng sau khi đặt hàng
            session.setAttribute("CART", null);

            // Chuyển hướng hoặc thông báo thành công
            request.getRequestDispatcher("HomeController").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
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
