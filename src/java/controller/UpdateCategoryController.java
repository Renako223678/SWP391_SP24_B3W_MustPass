/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDAO;
import dto.Category;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author THUAN
 */
public class UpdateCategoryController extends HttpServlet {

    private final String MANGER_PAGE = "ManagerUpdateCategory.jsp";
    private final String MANGER_P = "ManagerCatogoryController";

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
            CategoryDAO dao = new CategoryDAO();
            Category user = dao.detailCategory(id);
            request.setAttribute("user", user);
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
            int ID = Integer.parseInt(request.getParameter("ID"));
            
            String CategoryName = request.getParameter("CategoryName");
            byte[] xCategoryName = CategoryName.getBytes("ISO-8859-1");
            CategoryName = new String(xCategoryName, "UTF-8");
            
            int Status = Integer.parseInt(request.getParameter("Status"));
            CategoryDAO Adao = new CategoryDAO();
            Category item = new Category(ID, CategoryName, Status);
            Adao.updateCategory(item);
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
