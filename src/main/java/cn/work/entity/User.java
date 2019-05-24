package cn.work.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * User Class
         *
         * @author 刘畅
        * @version 2019/5/24
        */

@Entity
@Table(name = "T_USER")
public class User {
    @Id
    @Column(name = "user_id")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")//定于主键的生成策略
    @GeneratedValue(generator = "system-uuid")
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_pwd")
    private String userPwd;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_email")
    private String userEmail;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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
