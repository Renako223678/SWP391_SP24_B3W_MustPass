package dto;

import java.math.BigDecimal;
import java.sql.Date;

public class BookDTO {
    private long bookId;
    private String bookName;
    private String description;
    private String author;
    private String publishingCompany;
    private String issuingCompany;
    private String translator;
    private Date publishDate;
    private int quantity;
    private BigDecimal unitPrice;
    private int categoryId;
    private byte status;
    private int totalFeedback;

    public BookDTO() {
    }

    public BookDTO(long bookId, String bookName, String description, String author, String publishingCompany, String issuingCompany, String translator, Date publishDate, int quantity, BigDecimal unitPrice, int categoryId, byte status, int totalFeedback) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.description = description;
        this.author = author;
        this.publishingCompany = publishingCompany;
        this.issuingCompany = issuingCompany;
        this.translator = translator;
        this.publishDate = publishDate;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.categoryId = categoryId;
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

    public String getIssuingCompany() {
        return issuingCompany;
    }

    public void setIssuingCompany(String issuingCompany) {
        this.issuingCompany = issuingCompany;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
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

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
                + "\nAuthor: " + author + "\nPublishing Company=" + publishingCompany 
                + "\nIssuing Company: " + issuingCompany + "\nTtranslator: " + translator 
                + "\nPublish Date: " + publishDate + "\nQuantity: " + quantity 
                + "\nUnit Price: " + unitPrice + "\nCategoryId: " + categoryId 
                + "\nStatus: " + status + "\nTotal Feedback: " + totalFeedback;
    }
    
}
