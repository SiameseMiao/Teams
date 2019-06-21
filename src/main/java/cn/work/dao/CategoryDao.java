package cn.work.dao;

import cn.work.entity.Category;
import cn.work.util.Constants;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * CategoryDao Class
 *
 * @author <b>Siamese_miao</b>, Copyright &#169; 2018
 * @version 1.0, 2019-06-04 13:16
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
     * @param fid fid
     * @param status status
     * @return List<Category>
     */
    public List<Category> findCategoriesByFidAndStatus(int fid, Constants.Status status);
}
