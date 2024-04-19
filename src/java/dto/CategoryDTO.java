package dto;

public class CategoryDTO {

    private int categoryId;
    private String categoryName;
    private int subId;
    private int status;

    public CategoryDTO() {
    }

    public CategoryDTO(int categoryId, String categoryName, int subId, int status) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.subId = subId;
        this.status = status;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Category Id: " + categoryId + "\nCategory Name: " + categoryName
                + "\nSub Category Id: " + subId + "\nStatus: " + status;
    }

}
