/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author VU
 */
public class Feedback {
    private int FeedBackId;
    private int Star;
    private String Description;
    private int UserId;
    private int BookId;

    public Feedback() {
    }

    public Feedback(int FeedBackId, int Star, String Description, int UserId, int BookId) {
        this.FeedBackId = FeedBackId;
        this.Star = Star;
        this.Description = Description;
        this.UserId = UserId;
        this.BookId = BookId;
    }

    public Feedback(int Star, String Description, int UserId, int BookId) {
        this.Star = Star;
        this.Description = Description;
        this.UserId = UserId;
        this.BookId = BookId;
    }

    public int getFeedBackId() {
        return FeedBackId;
    }

    public void setFeedBackId(int FeedBackId) {
        this.FeedBackId = FeedBackId;
    }

    public int getStar() {
        return Star;
    }

    public void setStar(int Star) {
        this.Star = Star;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int BookId) {
        this.BookId = BookId;
    }

    
    
}
