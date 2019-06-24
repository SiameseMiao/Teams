package cn.work.service.impl;

import cn.work.controller.request.Accout;
import cn.work.dao.UserDao;
import cn.work.entity.User;
import cn.work.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
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
        Md5Hash md5Hash = new Md5Hash(userPwd, userName);
        User u=new User();
        u.setUserEmail(userEmail);
        u.setUserName(userName);
        u.setUserPhone(userPhone);
        u.setUserPwd(md5Hash.toString());
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
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

}
