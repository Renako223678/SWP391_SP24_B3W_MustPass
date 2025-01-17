package controller;

import dao.CategoryDAO;
import dao.SubCategoryDAO;
import dto.Category;
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

/**
 *
 * @author Quanglatui
 */
@WebServlet(name = "SubCateController", urlPatterns = {"/SubCateController"})
public class SubCateController_1 extends HttpServlet {

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
        dao.CategoryDAO cateDao = new CategoryDAO();
        dao.SubCategoryDAO subDao = new  SubCategoryDAO();
        List<Category> listCategory = new ArrayList<>();
        listCategory = cateDao.getAllListCategory();
        request.setAttribute("listCategory", listCategory);
        List<SubCategory> listSubCate = new ArrayList<>();
        listSubCate = subDao.getAllListSubCategory();
        request.setAttribute("listSubCategory", listSubCate);
        
        
        String url = "subcategory.jsp";
        String cateId = request.getParameter("cateId");
        List<SubCategory> subList = new ArrayList<>();
        SubCategoryDAO dao = new SubCategoryDAO();
        subList =dao.getListSubCategoryByCategoryId(Integer.parseInt(cateId));
        request.setAttribute("subList", subList);
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
