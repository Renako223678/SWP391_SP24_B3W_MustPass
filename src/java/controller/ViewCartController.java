package controller;

import cart.Cart;
import dao.CategoryDAO;
import dao.RecipientDAO;
import dao.SubCategoryDAO;
import dto.Account;
import dto.Category;
import dto.Recipient;
import dto.SubCategory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ViewCartController", urlPatterns = {"/ViewCartController"})
public class ViewCartController extends HttpServlet {

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
        String url = "viewCart.jsp";
        dao.CategoryDAO cateDao = new CategoryDAO();
        dao.SubCategoryDAO subDao = new SubCategoryDAO();
        List<Category> listCategory = new ArrayList<>();
        listCategory = cateDao.getAllListCategory();
        request.setAttribute("listCategory", listCategory);
        List<SubCategory> listSubCate = new ArrayList<>();
        listSubCate = subDao.getAllListSubCategory();
        request.setAttribute("listSubCategory", listSubCate);

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("CART");
        if (cart == null) {
            cart = new Cart(); // Nếu giỏ hàng chưa được khởi tạo, tạo mới
            session.setAttribute("CART", cart); // Đặt giỏ hàng vào session
        }
        Account user = (Account)session.getAttribute("LOGIN_USER");
        List<Recipient> listRecipient = new ArrayList<>();
        RecipientDAO reDao = new RecipientDAO();
        listRecipient = reDao.getRecipientByUserID(user.getUserId());
        request.setAttribute("listRecipient", listRecipient);

// Chuyển đối tượng Cart vào JSP
        request.setAttribute("cart", cart);
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
