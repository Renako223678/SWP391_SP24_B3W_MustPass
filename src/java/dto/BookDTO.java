package dto;

import java.math.BigDecimal;
import java.sql.Date;

public class BookDTO {
    private long bookId;
    private String bookName;
    private String description;
    private String author;
    private String publishingCompany;
    private String issusingCompany;
    private String translator;
    private String genre;
    private Date publishDate;
    private int quantity;
    private BigDecimal unitPrice;
    private byte status;
    private int totalFeedback;

    public BookDTO() {
    }

    public BookDTO(long bookId, String bookName, String description, String author, 
            String publishingCompany, String issusingCompany, String translator, 
            String genre, Date publishDate, int quantity, BigDecimal unitPrice, 
            byte status, int totalFeedback) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.description = description;
        this.author = author;
        this.publishingCompany = publishingCompany;
        this.issusingCompany = issusingCompany;
        this.translator = translator;
        this.genre = genre;
        this.publishDate = publishDate;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.status = status;
        this.totalFeedback = totalFeedback;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public String getIssusingCompany() {
        return issusingCompany;
    }

    public void setIssusingCompany(String issusingCompany) {
        this.issusingCompany = issusingCompany;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public int getTotalFeedback() {
        return totalFeedback;
    }

    public void setTotalFeedback(int totalFeedback) {
        this.totalFeedback = totalFeedback;
    }

    @Override
    public String toString() {
        return "BookId: " + bookId + "\nBook Name: " + bookName + "\nDescription: " + description 
                + "\nAuthor: " + author + "\nPublishing Company: " + publishingCompany 
                + "\nIssusing Company: " + issusingCompany + "\nTranslator: " + translator 
                + "\nGenre: " + genre + "\nPublish Date: " + publishDate + "\nQuantity: " + quantity 
                + "\nUnit Price: " + unitPrice + "\nStatus: " + status + "\nTotal Feedback:" + totalFeedback;
    }
    
}
