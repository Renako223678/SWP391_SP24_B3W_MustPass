package dto;

/**
 *
 * @author Quanglatui
 */
public class SubCategory {
    private int subcategoryID;
    private String subName;
    private String description;
    private int status;
    private int categoryId;

    public SubCategory() {
    }

    public SubCategory(int subcategoryID, String subName, String description, int status, int categoryId) {
        this.subcategoryID = subcategoryID;
        this.subName = subName;
        this.description = description;
        this.status = status;
        this.categoryId = categoryId;
    }

    public SubCategory(String subName, String description, int status, int categoryId) {
        this.subName = subName;
        this.description = description;
        this.status = status;
        this.categoryId = categoryId;
    }

    public int getSubcategoryID() {
        return subcategoryID;
    }

    public void setSubcategoryID(int subcategoryID) {
        this.subcategoryID = subcategoryID;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    
}
