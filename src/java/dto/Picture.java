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
public class Picture {
    int PicID;
    String filename;
    String imgUrl;
    public Picture(){
        
    }

    public Picture(int PicID, String filename, String imgUrl) {
        this.PicID = PicID;
        this.filename = filename;
        this.imgUrl = imgUrl;
    }

    public int getPicID() {
        return PicID;
    }

    public void setPicID(int PicID) {
        this.PicID = PicID;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    
}
