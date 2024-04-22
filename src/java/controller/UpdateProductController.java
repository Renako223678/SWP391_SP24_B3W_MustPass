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
public class UpdateProductController extends HttpServlet {
private final String MANGER_PAGE = "ManagerUpdateProduct.jsp";
private final String MANGER_P = "ManagerProductController";


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
            int _bookId = Integer.parseInt(request.getParameter("txt_bookId"));
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
            Book item = new Book(_bookId, _bookName, _description, _authorName, _publishingCompany, _issusingCompany, _translatorName, _publishDate, _quantity, _subCategoryId, _unitPrice, _categoryId, _status, _totalFeedback);
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
