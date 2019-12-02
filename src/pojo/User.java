package pojo;

public class User {
    private String userId;
    private String userPassword;
    private String userName;
    private String userIDCard;
    private String phoneNumber;
    private String userType;
    public User(){}

    public User(String userId, String userPassword, String userName, String userIDCard, String phoneNumber, String userType) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userIDCard = userIDCard;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
    }

    public User(String id, String password){this.userId = id;this.userPassword=password;}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIDCard() {
        return userIDCard;
    }

    public void setUserIDCard(String userIDCard) {
        this.userIDCard = userIDCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
