import dao.OrderDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteOrder")
public class deleteOrderController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get order ID parameter from request
        long orderId = Long.parseLong(request.getParameter("orderId"));
        
        // Initialize DAO
        OrderDAO orderDAO = new OrderDAO();
        
        try {
            // Delete order
            boolean success = orderDAO.deleteOrder(orderId);
            
            // Check if the deletion was successful
            if (success) {
                response.sendRedirect("orders.jsp"); // Redirect to orders page or any other appropriate page
            } else {
                // Handle unsuccessful deletion
                response.getWriter().println("Failed to delete order.");
            }
        } catch (SQLException e) {
            // Handle database-related errors
            e.printStackTrace();
            response.getWriter().println("Database error occurred.");
        }
    }
}
