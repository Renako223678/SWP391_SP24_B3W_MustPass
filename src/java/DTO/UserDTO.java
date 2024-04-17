package dto;

public class UserDTO {
    private long userId;
    private String email;
    private String password;
    private String fullname;
    private int numberLotus;
    private long roleId;

    public UserDTO() {
    }
    
    public UserDTO(long userId, String email, String password, String fullname, int numberLotus, long roleId) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.numberLotus = numberLotus;
        this.roleId = roleId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
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

    public int getNumberLotus() {
        return numberLotus;
    }

    public void setNumberLotus(int numberLotus) {
        this.numberLotus = numberLotus;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
    
    @Override
    public String toString() {
        return "UserId: " + userId + "\nEmail: " + email 
                + "\nPassword: " + password + "\nFullname: " + fullname 
                + "\nNumber of Lotus: "+ numberLotus + "\nRoleId: " + roleId;
    }
    
}
