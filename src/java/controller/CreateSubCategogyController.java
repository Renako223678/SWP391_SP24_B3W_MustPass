/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDAO;
import dao.SubCategoryDAO;
import dto.Category;
import dto.SubCategory;
import java.io.IOException;
import java.io.PrintWriter;
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
public class CreateSubCategogyController extends HttpServlet {

    private final String MANGER_PAGE = "CreateSubCategory.jsp";
     private final String MANGER_P = "ManagerSubCategoryController";
   

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
        HttpSession session = request.getSession();
        CategoryDAO dao = new CategoryDAO();
        List<Category> listItem = dao.getAllListCategory();
            request.setAttribute("categories", listItem);
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
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
            String SubName = request.getParameter("SubName");
            byte[] xSubName = SubName.getBytes("ISO-8859-1");
            SubName = new String(xSubName, "UTF-8");
            
            String Description = request.getParameter("Description");
            byte[] xDescription = Description.getBytes("ISO-8859-1");
            Description = new String(xDescription, "UTF-8");
            
            int Status = Integer.parseInt(request.getParameter("Status"));
            int CategoryId = Integer.parseInt(request.getParameter("CategoryId"));
            SubCategoryDAO Adao = new SubCategoryDAO();
            SubCategory item = new SubCategory(SubName, Description, Status, CategoryId);
            Adao.createSubCategory(item);
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
