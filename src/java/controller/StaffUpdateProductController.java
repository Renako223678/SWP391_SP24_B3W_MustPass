/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BookDAO;
import dao.CategoryDAO;
import dao.SubCategoryDAO;
import dto.Book;
import dto.Category;
import dto.SubCategory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author VU
 */
public class StaffUpdateProductController extends HttpServlet {
private final String MANGER_PAGE = "StaffUpdateProduct.jsp";
private final String MANGER_P = "StaffController";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


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
            BookDAO dao = new BookDAO();
            Book book = dao.getBookID(id);
            request.setAttribute("book", book);

            HttpSession session = request.getSession();
        CategoryDAO adao = new CategoryDAO();
        List<Category> listItem = adao.getAllListCategory();
         request.setAttribute("categories", listItem);
         
         SubCategoryDAO ddao = new SubCategoryDAO();
         List<SubCategory> listItems = ddao.getAllListSubCategory();
         request.setAttribute("subcategories", listItems);
         
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
            int BookId = Integer.parseInt(request.getParameter("BookId"));
            String BookName = request.getParameter("BookName");
            byte[] xBookName = BookName.getBytes("ISO-8859-1");
            BookName = new String(xBookName, "UTF-8");
            
            String Description = request.getParameter("Description");
            byte[] xDescription = Description.getBytes("ISO-8859-1");
            Description = new String(xDescription, "UTF-8");
            
            String AuthorName = request.getParameter("AuthorName");
            byte[] xAuthorName = AuthorName.getBytes("ISO-8859-1");
            AuthorName = new String(xAuthorName, "UTF-8");
            
            String PublishingCompany = request.getParameter("PublishingCompany");
            byte[] xPublishingCompany = PublishingCompany.getBytes("ISO-8859-1");
            PublishingCompany = new String(xPublishingCompany, "UTF-8");
            
            String IssusingCompany = request.getParameter("IssusingCompany");
            byte[] xIssusingCompany = IssusingCompany.getBytes("ISO-8859-1");
            IssusingCompany = new String(xIssusingCompany, "UTF-8");
            
            String TranslatorName = request.getParameter("TranslatorName");
            byte[] xTranslatorName= TranslatorName.getBytes("ISO-8859-1");
            TranslatorName = new String(xTranslatorName, "UTF-8");
            
            int PublishDate = Integer.parseInt(request.getParameter("PublishDate"));
            int Quantity = Integer.parseInt(request.getParameter("Quantity"));
            int SubCategoryId = Integer.parseInt(request.getParameter("SubCategoryId"));
            int UnitPrice = Integer.parseInt(request.getParameter("UnitPrice"));
            int CategoryID = Integer.parseInt(request.getParameter("CategoryID"));
            int Status = Integer.parseInt(request.getParameter("Status"));
            int TotalFeedback = Integer.parseInt(request.getParameter("TotalFeedback"));
            
            BookDAO Adao = new BookDAO();
            Book item = new Book(BookId, BookName, Description, AuthorName, PublishingCompany, IssusingCompany, 
                    TranslatorName, PublishDate, Quantity, SubCategoryId, UnitPrice, CategoryID, Status, TotalFeedback);
            Adao.updateBook(item);
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

}
