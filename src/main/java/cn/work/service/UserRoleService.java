package cn.work.service;

import cn.work.entity.UserRole;

import java.util.List;

public interface UserRoleService {
    List<String> getRolesByUserName(String username);
    public void insertT(String userName,String roleName);
    public void updateT(UserRole userRole);
    public void delete(int id);

}
