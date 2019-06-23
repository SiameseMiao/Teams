package cn.work.dao;

import cn.work.entity.RolePremission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RolePremissionDao extends CrudRepository<RolePremission, Integer> {
    @Query(value="SELECT premission_name FROM t_role_premission WHERE role_name=? ",nativeQuery=true)
    List<String> getRolesByUserName(String username);
}
