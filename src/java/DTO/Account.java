/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.regex.Pattern;

/**
 *
 * @author ADMIN
 */
public class Account {
    private int userid;
    private String email;
    private String password;
    private String fullname;
    private int Number_of_Lotus;
    private int roleid;

    public Account(int userid, String email, String password, String fullname, int Number_of_Lotus, int roleid) {
        this.userid = userid;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.Number_of_Lotus = Number_of_Lotus;
        this.roleid = roleid;
    }
    
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getEmail() {
        
        return email;
    }

    public void setEmail(String email) {
       
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getNumber_of_Lotus() {
        return Number_of_Lotus;
    }

    public void setNumber_of_Lotus(int Number_of_Lotus) {
        this.Number_of_Lotus = Number_of_Lotus;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }
    
}
