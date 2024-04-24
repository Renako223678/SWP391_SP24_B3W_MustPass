/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BookDAO;
import dto.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author THUAN
 */
public class CreateProductController extends HttpServlet {

    private final String CREATE_NEW_PRODUCT= "ManagerCreateProduct.jsp";
    private final String PRODUCT_PAGE = "CreateProductController";

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
            byte[] txt_bookName = BookName.getBytes("ISO-8859-1");
            BookName = new String(txt_bookName, "UTF-8");
            String Description = request.getParameter("Description");
            byte[] txt_description = Description.getBytes("ISO-8859-1");
            Description = new String(txt_description, "UTF-8");
            String AuthorName = request.getParameter("AuthorName");
            byte[] txt_authorName = AuthorName.getBytes("ISO-8859-1");
            AuthorName = new String(txt_authorName, "UTF-8");
            String PublishingCompany = request.getParameter("PublishingCompany");
            byte[] txt_publishingCompany = PublishingCompany.getBytes("ISO-8859-1");
            PublishingCompany = new String(txt_publishingCompany, "UTF-8");
            String IssusingCompany = request.getParameter("IssusingCompany");
            byte[] txt_issusingCompany = IssusingCompany.getBytes("ISO-8859-1");
            IssusingCompany = new String(txt_issusingCompany, "UTF-8");
            String TranslatorName = request.getParameter("TranslatorName");
            byte[] txt_translatorName = TranslatorName.getBytes("ISO-8859-1");
            TranslatorName = new String(txt_translatorName, "UTF-8");
            Date PublishDate = Date.valueOf(request.getParameter("PublishDate"));
            int Quantity = Integer.parseInt(request.getParameter("Quantity"));
            int SubCategoryId = Integer.parseInt(request.getParameter("SubCategoryId"));
            float UnitPrice = Float.parseFloat(request.getParameter("UnitPrice"));
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
