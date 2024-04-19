package Controllers;

import dao.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddBookController extends HttpServlet {
    private static final String SUCCESS = "staff.jsp";
    private static final String ERROR = "staff.jsp";

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
        String url = ERROR;
        try {
            BookDAO dao = new BookDAO();
            long bookID = Long.parseLong(request.getParameter("bookID"));
            String bookName = request.getParameter("bookName");
            String description = request.getParameter("description");
            String author = request.getParameter("author");
            String publishingCompany = request.getParameter("publishCom");
            String issuingCompany = request.getParameter("issuingComp");
            String translator = request.getParameter("translator");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            
            String decimalString = request.getParameter("unitPrice");
            BigDecimal unitPrice = new BigDecimal(decimalString);
            
            String dateString = request.getParameter("publishDate");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date publishDate = format.parse(dateString);
            
            byte status = Byte.parseByte(request.getParameter("status"));
            
            boolean checkAdd = dao.addBook(bookID, bookName, description, author, 
                    publishingCompany, issuingCompany, translator, 
                    (java.sql.Date) publishDate, quantity, unitPrice, status);
            if(checkAdd){
                request.setAttribute("ADD_MESSAGE", "Add new book successfully!");
                url = SUCCESS;
            }else{
                request.setAttribute("ADD_ERROR", "Add new book failed!");
                url = ERROR;
            }
        }catch(Exception e){
            
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
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
