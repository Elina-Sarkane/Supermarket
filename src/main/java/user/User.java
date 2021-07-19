package user;

public class User {
    private UserType userType;
    private String userName;
    private String userEmail;
    private String userPassword;
    private double userBalance;

    public User(UserType userType, String userName, String userEmail, String userPassword, double userBalance) {
        this.userType = userType;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userBalance = userBalance;
    }

    public User(){

    }

    public User(UserType userType, double userBalance) {
        this.userType = userType;
        this.userBalance = userBalance;
    }

    public User(UserType userType){
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(double userBalance) {
        this.userBalance = userBalance;
    }
}
