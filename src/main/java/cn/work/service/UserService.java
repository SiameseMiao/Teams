package cn.work.service;

import cn.work.controller.request.Accout;
import cn.work.entity.User;

import java.util.List;

/**
 *
 * @author 刘畅
 * @version 2019/5/24
 */
public interface UserService {
    public void insertT(String userName,String userPwd,String userPhone,String userEmail);
    public void updateT(User user);
    public User getUserByName(String userName);
    public User getUserById(int id);
    public Accout checkAccount(String username, String password);
    public void delete(int id);
    public List<User> getAllUsers();
}
