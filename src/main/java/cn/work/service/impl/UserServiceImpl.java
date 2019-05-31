package cn.work.service.impl;

import cn.work.controller.request.Accout;
import cn.work.dao.UserDao;
import cn.work.entity.User;
import cn.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author 刘畅
 * @version 2019/5/24
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public void insertT(String userName, String userPwd, String userPhone, String userEmail) {
        User u=new User();
        u.setUserEmail(userEmail);
        u.setUserName(userName);
        u.setUserPhone(userPhone);
        u.setUserPwd(userPwd);
        userDao.save(u);
    }

    @Override
    public void updateT(User user) {
        userDao.save(user);
    }

    @Override
    public User getUserByName(String userName) {
        return userDao.getUserByUserName(userName);
    }

    @Override
    public User getUserById(int id) {
        return userDao.findOne(id);
    }

    @Override
    public Accout checkAccount(String username, String password) {
        User temp=getUserByName(username);
        System.out.println(temp);
        if(temp!=null&&password.equals(temp.getUserPwd())) {
            Accout user=new Accout();
            user.setUserName(username);
            user.setUserPwd(password);
            user.setUserId(temp.getUserId());
            user.setUserEmail(temp.getUserEmail());
            user.setUserPhone(temp.getUserPhone());
            return user;
        }
        return null;
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}
