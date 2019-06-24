package cn.work.controller.request;



import javax.validation.constraints.NotEmpty;


public class Accout {
    private int userId;
    @NotEmpty
    private String userName;
    @NotEmpty
    private String userPwd;
    private String userPhone;
    private String userEmail;
    private boolean rememberMe;

    public boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean isRememberMe) {
        this.rememberMe = isRememberMe;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
