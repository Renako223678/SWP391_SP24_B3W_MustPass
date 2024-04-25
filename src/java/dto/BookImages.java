/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author THUAN
 */
public class BookImages {
    private int ImageId;
    private String Url;
    private int Status;
    private int BookId;

    public BookImages() {
    }

    public BookImages(int ImageId, String Url, int Status, int BookId) {
        this.ImageId = ImageId;
        this.Url = Url;
        this.Status = Status;
        this.BookId = BookId;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int ImageId) {
        this.ImageId = ImageId;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int BookId) {
        this.BookId = BookId;
    }
    
}
