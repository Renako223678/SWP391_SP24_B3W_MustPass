/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.AccountDAO;
import dao.BookDAO;
import dao.SubCategoryDAO;
import dto.Book;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author DELL
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        dao.SubCategoryDAO daoo = new SubCategoryDAO();
        dao.BookDAO daooo= new BookDAO();
        System.out.println(daoo.getListSubCategoryByCategoryId(2));
    }}

    

