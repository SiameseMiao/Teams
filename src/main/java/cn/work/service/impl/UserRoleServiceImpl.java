package cn.work.service.impl;

import cn.work.dao.UserRoleDao;
import cn.work.entity.UserRole;
import cn.work.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDao userRoleDao;
    @Override
    public List<String> getRolesByUserName(String username) {
        return userRoleDao.getRolesByUserName(username);
    }

    @Override
    public void insertT(String userName, String roleName) {
        UserRole userRole=new UserRole();
        userRole.setUserName(userName);
        userRole.setRoleName(roleName);
        userRoleDao.save(userRole);
    }

    @Override
    public void updateT(UserRole userRole) {
        userRoleDao.save(userRole);
    }

    @Override
    public void delete(int id) {
        userRoleDao.delete(id);
    }
}
