package cn.work.service;

import cn.work.entity.Category;
import cn.work.util.Constants;

import java.util.List;
/**
 * CategoryServiceClass
 *
 * @author <b>Siamese_miao</b>, Copyright &#169; 2018
 * @version 1.0, 2019-06-04 13:20
 */
public interface CategoryService {
    public void insertT( String name, int fid, Constants.Status status);
    public void updateT(int id,String name,Constants.Status status);
    public void forbid(int id, Constants.Status status);
    public void deleteById(int id);
    public Category getCategory(int id);
    public List<Category> getAllCategorys();
    public List<Category> getCategoriesByFid(int fid);
    public List<Category> findCategoriesByFidAndStatus(int fid, Constants.Status status);

}
