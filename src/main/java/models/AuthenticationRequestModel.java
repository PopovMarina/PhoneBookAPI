package models;

public class AuthenticationRequestModel {
    private String userName;
    private String password;

    public static AuthenticationRequestModel userName(String userName) {
        return new AuthenticationRequestModel(userName, null);
    }
    public  AuthenticationRequestModel password(String password) {
        this.password = password;
        return this;
    }

    private AuthenticationRequestModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public AuthenticationRequestModel(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }
}
