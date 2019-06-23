package cn.work.dao;

import cn.work.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author 刘畅
 * @version 2019/5/24
 */
@Repository
public interface UserDao extends CrudRepository<User, Integer>{
    public User getUserByUserName(String name);
    public List<User> findAll();
}
