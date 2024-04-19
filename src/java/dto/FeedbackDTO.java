/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author ADMIN
 */
public class FeedbackDTO {
    private int Feedbackid;
    private int star;
    private String description;
    private int userid ;
    private int bookid;

    public FeedbackDTO() {
    }

    public FeedbackDTO(int Feedbackid, int star, String description, int userid, int bookid) {
        this.Feedbackid = Feedbackid;
        this.star = star;
        this.description = description;
        this.userid = userid;
        this.bookid = bookid;
    }

    public int getFeedbackid() {
        return Feedbackid;
    }

    public void setFeedbackid(int Feedbackid) {
        this.Feedbackid = Feedbackid;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
    
}
