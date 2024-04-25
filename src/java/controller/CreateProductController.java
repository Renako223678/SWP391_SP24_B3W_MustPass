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
import java.time.LocalDate;
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
public class CreateProductController extends HttpServlet {

    private final String CREATE_NEW_PRODUCT= "ManagerCreateProduct.jsp";
    private final String PRODUCT_PAGE = "ManagerProductController";

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        CategoryDAO adao = new CategoryDAO();
        List<Category> listItem = adao.getAllListCategory();
         request.setAttribute("categories", listItem);
         
         SubCategoryDAO dao = new SubCategoryDAO();
         List<SubCategory> listItems = dao.getAllListSubCategory();
         request.setAttribute("subcategories", listItems);
         
        String url = CREATE_NEW_PRODUCT;
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ul = PRODUCT_PAGE;
         try (PrintWriter out = response.getWriter()) {
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
            byte[] xTranslatorName = TranslatorName.getBytes("ISO-8859-1");
            TranslatorName = new String(xTranslatorName, "UTF-8");
        
            int PublishDate = Integer.parseInt(request.getParameter("PublishDate"));
            int Quantity = Integer.parseInt(request.getParameter("Quantity"));
            int SubCategoryId = Integer.parseInt(request.getParameter("SubCategoryId"));
            int UnitPrice = Integer.parseInt(request.getParameter("UnitPrice"));
            int CategoryID = Integer.parseInt(request.getParameter("CategoryID"));
            int Status = Integer.parseInt(request.getParameter("Status"));
            int TotalFeedback = Integer.parseInt(request.getParameter("TotalFeedback"));
            BookDAO Adao = new BookDAO();
            Book item = new Book(BookName, Description, AuthorName, PublishingCompany, IssusingCompany, TranslatorName, PublishDate, Quantity, SubCategoryId, UnitPrice, CategoryID, Status, TotalFeedback);
            Adao.createBook(item);
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
