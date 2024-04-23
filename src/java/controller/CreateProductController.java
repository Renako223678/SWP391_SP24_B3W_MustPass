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
            String _bookName = request.getParameter("txt_bookName");
            byte[] txt_bookName = _bookName.getBytes("ISO-8859-1");
            _bookName = new String(txt_bookName, "UTF-8");
            
            String _description = request.getParameter("txt_description");
            byte[] txt_description = _description.getBytes("ISO-8859-1");
            _description = new String(txt_description, "UTF-8");
            
            String _authorName = request.getParameter("txt_authorName");
            byte[] txt_authorName = _authorName.getBytes("ISO-8859-1");
            _authorName = new String(txt_authorName, "UTF-8");
            
            String _publishingCompany = request.getParameter("txt_publishingCompany");
            byte[] txt_publishingCompany = _publishingCompany.getBytes("ISO-8859-1");
            _publishingCompany = new String(txt_publishingCompany, "UTF-8");
            
            String _issusingCompany = request.getParameter("txt_issusingCompany");
            byte[] txt_issusingCompany = _issusingCompany.getBytes("ISO-8859-1");
            _issusingCompany = new String(txt_issusingCompany, "UTF-8");
            
            String _translatorName = request.getParameter("txt_translatorName");
            byte[] txt_translatorName = _translatorName.getBytes("ISO-8859-1");
            _translatorName = new String(txt_translatorName, "UTF-8");
            
            Date _publishDate = Date.valueOf(request.getParameter("txt_publishDate"));
            int _quantity = Integer.parseInt(request.getParameter("txt_quantity"));
            int _subCategoryId = Integer.parseInt(request.getParameter("txt_subCategoryId"));
            float _unitPrice = Float.parseFloat(request.getParameter("txt_unitPrice"));
            int _categoryId = Integer.parseInt(request.getParameter("txt_categoryId"));
            int _status = Integer.parseInt(request.getParameter("txt_status"));
            int _totalFeedback = Integer.parseInt(request.getParameter("txt_totalFeedback"));
            BookDAO Adao = new BookDAO();
            Book item = new Book(_bookName, _description, _authorName, _publishingCompany, _issusingCompany, _translatorName, _publishDate, _quantity, _subCategoryId, _unitPrice, _categoryId, _status, 0);
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
