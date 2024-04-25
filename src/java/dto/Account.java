/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

/**
 *
 * @author VU
 */
public class Account {
    private int userId;
    private String email;
    private String password;
    private String fullname;
    private int numberOfLotus;
    private int roleId;
    private int status;

    public Account() {
    }

    public Account(int userId, String email, String password, String fullname, int numberOfLotus, int roleId, int status) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.numberOfLotus = numberOfLotus;
        this.roleId = roleId;
        this.status = status;
    }
    public Account( String email, String password, String fullname, int numberOfLotus, int roleId, int status) {
      
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.numberOfLotus = numberOfLotus;
        this.roleId = roleId;
        this.status = status;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getNumberOfLotus() {
        return numberOfLotus;
    }

    public void setNumberOfLotus(int numberOfLotus) {
        this.numberOfLotus = numberOfLotus;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    
    
    
}
