/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author DELL
 */
public class CreateAccountError {
    String emailExisted;
    String emailLengthErr;
    String fullnameLengthErr;
    String passwordLengthErr;
    public CreateAccountError(){
        
    }

    public CreateAccountError(String emailExisted, String emailLengthErr, String fullnameLengthErr, String passwordLengthErr) {
        this.emailExisted = emailExisted;
        this.emailLengthErr = emailLengthErr;
        this.fullnameLengthErr = fullnameLengthErr;
        this.passwordLengthErr = passwordLengthErr;
    }

    public String getEmailExisted() {
        return emailExisted;
    }

    public void setEmailExisted(String emailExisted) {
        this.emailExisted = emailExisted;
    }

    public String getEmailLengthErr() {
        return emailLengthErr;
    }

    public void setEmailLengthErr(String emailLengthErr) {
        this.emailLengthErr = emailLengthErr;
    }

    public String getFullnameLengthErr() {
        return fullnameLengthErr;
    }

    public void setFullnameLengthErr(String fullnameLengthErr) {
        this.fullnameLengthErr = fullnameLengthErr;
    }

    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }
    
    
}
