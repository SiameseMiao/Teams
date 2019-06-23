package cn.work.service;


import cn.work.entity.RolePremission;

import java.util.List;

public interface RolePremissionService {
    List<String> getRolesByRoleName(String roleName);
    public void insertT(String roleName,String premissionName);
    public void updateT(RolePremission userRole);
    public void delete(int id);
}
