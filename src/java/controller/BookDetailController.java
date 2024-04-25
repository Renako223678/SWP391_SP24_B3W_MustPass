package controller;

import dao.AccountDAO;
import dao.BookDAO;
import dao.FeedbackDAO;
import dto.Account;
import dto.Book;
import dto.Feedback;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "BookDetailController", urlPatterns = {"/BookDetailController"})
public class BookDetailController extends HttpServlet {

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
        String url = "bookDetail.jsp";
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        dao.BookDAO dao = new BookDAO();
        Book book = dao.getBookByID(bookId);
        AccountDAO accountDao = new AccountDAO();
        
        List<Account> listAccount = new ArrayList<>();
        FeedbackDAO feedbackDao = new FeedbackDAO();
        List<Feedback> listFeedback = new ArrayList<>();
        listFeedback = feedbackDao.getALLFeedbackByBookID(bookId);
        for (Feedback feedback : listFeedback) {
            Account account = new Account();
            try {
                account =accountDao.detailAccountInt(feedback.getUserId());
                listAccount.add(account);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BookDetailController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(BookDetailController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        request.setAttribute("book", book);
        request.setAttribute("listFeedback", listFeedback);
        request.setAttribute("listAccount", listAccount);
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
