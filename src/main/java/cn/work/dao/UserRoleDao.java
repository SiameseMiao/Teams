package cn.work.dao;

import cn.work.entity.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRoleDao extends CrudRepository<UserRole, Integer> {
    @Query(value="SELECT role_name FROM t_user_role WHERE user_name=? ",nativeQuery=true)
    List<String> getRolesByUserName(String username);
}
