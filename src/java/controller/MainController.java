/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class MainController extends HttpServlet {

    private static final String ERROR = "404.jsp";
    private final String HOME = "index.jsp";
    private final String LOGIN_PAGE = "signin.jsp";
    private final String LOGIN = "LoginController";
    private final String SIGN_UP = "SignupController";

    private final String CREATE = "CreateNewAccountController";
    private final String SHOW_ALL_PRODUCT ="ShowAllProductController";
    
    // Search accounts
    private final String SEARCH = "SearchAccountController";
    
    // function admin
    private final String ADMIN_ACCOUNT = "AdminController";
    private final String ADMIN_UPDATE_ACCOUNT = "AdminUpdateController";
    private final String ADMIN_DELETE_ACCOUNT = "AdminDeleteAccountController";
    
    // function manager 
    private final String MANAGER_ACCOUNT = "ManagerAccountController";
    private final String MANAGER_BLOG = "ManagerBlogController";
    private final String MANAGER_PRODUCT = "ManagerProductController";
    private final String MANAGER_CATEGORY = "ManagerCatogoryController";
    private final String MANAGER_UPDATE_ACCOUNT = "UpdateAccountController";
    private final String CREATE_PRODUCT = "CreateProductController";
    private final String CREATE_CATEGOGY = "CreateCategogyController";
    
    private final String UPDATE_BLOG = "UpdateBlogController";
    private final String UPDATE_PRODUCT = "UpdateProductController";
    
    // function staff
    private final String STAFF_FEEDBACK = "ManagerFeedbackController";
    private final String STAFF_ORDERS = "ManagerOrdersController";
    private final String STAFF_PRODUCT = "StaffController";
    private final String STAFF_UPDATE_ORDERS = "UpdateOrdersController";
    private final String STAFF_UPDATE_PRODUCT = "StaffUpdateProductController";
    
          
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;

        try {
            String button = request.getParameter("btAction");
            if (button == null) {
                url = "404.jsp";
            } else if (button.equals("Login")) {
                url = LOGIN;
                
            } else if (button.equals("Sign up")) {
                url = CREATE;
            } else if (button.equals("Show All Product")) {
                url = SHOW_ALL_PRODUCT;
            }else if (button.equals("ADMIN_ACCOUNT")) {
                url = ADMIN_ACCOUNT;
            }else if (button.equals("UPDATE_ACCOUNT")) {
                url = ADMIN_UPDATE_ACCOUNT;
            }else if (button.equals("MANAGER_UPDATE_ACCOUNT")) {
                url = MANAGER_UPDATE_ACCOUNT;
            }else if (button.equals("Manage Account")) {
                url = MANAGER_ACCOUNT;
            } else if (button.equals("Manage BLogs")) {
                url = MANAGER_BLOG;
            } else if (button.equals("Manage Product")) {
                url = MANAGER_PRODUCT;
            }else if (button.equals("MANAGER_UPDATE_PRODUCT")){
                url = UPDATE_PRODUCT;
            }else if (button.equals("Create Product")) {
                url = CREATE_PRODUCT;
            }else if (button.equals("Create Categogy")) {
                url = CREATE_CATEGOGY;
            }else if (button.equals("Manage Category")){
                url = MANAGER_CATEGORY;
            }else if (button.equals("Staff FeedBack")){
                url = STAFF_FEEDBACK;
            }else if (button.equals("Staff Orders")){
                url = STAFF_ORDERS;
            }else if (button.equals("Staff Product")){
                url = STAFF_PRODUCT;
            }else if (button.equals("STAFF_UPDATE_ORDERS")){
                url = STAFF_UPDATE_ORDERS;
            }else if (button.equals("STAFF_UPDATE_PRODUCTS")){
                url = STAFF_UPDATE_PRODUCT;
            }

        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
