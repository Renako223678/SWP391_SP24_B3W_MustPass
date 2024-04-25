package controller;

import cart.Cart;
import dao.BookDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import dto.Account;
import dto.Book;
import dto.Order;
import dto.OrderDetail;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        BookDAO bookdao = new BookDAO();
        Book bookOriginal = new Book();
        boolean notEnough = false;

        for (Book book : cart.getCart().values()) {
            bookOriginal = bookdao.getBookByID(book.getBookId()); // Lấy thông tin sách từ ID
            int remainingQuantity = bookOriginal.getQuantity() - book.getQuantity(); // Số lượng còn lại sau khi trừ đi số lượng đặt hàng

            if (remainingQuantity < 0) { // Nếu số lượng còn lại nhỏ hơn 0, nghĩa là không đủ
                request.setAttribute("errorMessage", "Sản phẩm này chỉ còn:"+ bookOriginal.getQuantity());
                notEnough = true; // Đánh dấu rằng không đủ số lượng
                break; // Dừng vòng lặp vì đã tìm thấy ít nhất một sản phẩm không đủ
            }
        }

        if (notEnough) { // Nếu có ít nhất một sản phẩm không đủ số lượng
            request.getRequestDispatcher("ViewCartController").forward(request, response); 
            return;
        }
        Account account = (Account) session.getAttribute("LOGIN_USER");
        String recipientID = request.getParameter("recipientID");
        try {
            // Tạo đối tượng Order
            Order order = new Order();
            LocalDateTime today = LocalDateTime.now();
            Timestamp sqlDate =Timestamp.valueOf(today);
            order.setOrderDate(sqlDate);
            order.setShipFee(50000);
            order.setTotalPrice(cart.getTotalMoney()); 
            order.setFinalPrice(cart.getTotalMoney() + order.getShipFee());
            order.setStatus(1);
            order.setRecipientId(Integer.parseInt(recipientID));
            OrderDAO orderDAO = new OrderDAO();
            int orderId = orderDAO.createOrder(order, account.getUserId()); 

            // Tạo các OrderDetail từ giỏ hàng
            OrderDetailDAO orderDetailDAO = new OrderDetailDAO();

            for (Book book : cart.getCart().values()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderId(orderId);
                orderDetail.setBookId(book.getBookId()); // Chuyển đổi ID thành int
                int quantity = bookOriginal.getQuantity() - book.getQuantity();
                bookOriginal.setQuantity(quantity);
                bookdao.updateBook(bookOriginal);
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
