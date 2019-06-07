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
    /**
     * fetch data from Category
     *
     * @return List<Category>
     */
    @Override
    public List<Category> findAll();
    /**
     * fetch data from Category
     *
     * @param fid fid
     * @return List<Category>
     */
    public List<Category> findCategoriesByFid(int fid);
    /**
     * fetch data from Category
     *
     * @param name name
     * @return List<Category>
     */
    public List<Category> findCategoriesByName(String name);
}
