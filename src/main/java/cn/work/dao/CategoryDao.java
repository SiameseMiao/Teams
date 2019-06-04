package cn.work.dao;

import cn.work.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 *
 * @author 刘畅
 * @version 2019/5/24
 */
@Repository
public interface CategoryDao extends CrudRepository<Category, Integer> {
    @Override
    public List<Category> findAll();
}
