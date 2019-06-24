package cn.work.service.impl;

import cn.work.dao.RolePremissionDao;
import cn.work.entity.RolePremission;
import cn.work.service.RolePremissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePremissionServiceImpl implements RolePremissionService {
    @Autowired
    private RolePremissionDao rolePremissionDao;
    @Override
    public List<String> getRolesByRoleName(String roleName) {
        return rolePremissionDao.getRolesByUserName(roleName);
    }

    @Override
    public void insertT(String roleName, String premissionName) {
        RolePremission rolePremission=new RolePremission();
        rolePremission.setPremissionName(premissionName);
        rolePremission.setRoleName(roleName);
        rolePremissionDao.save(rolePremission);
    }

    @Override
    public void updateT(RolePremission userRole) {
        rolePremissionDao.save(userRole);
    }

    @Override
    public void delete(int id) {
        rolePremissionDao.delete(id);
    }
}
