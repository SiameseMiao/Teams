package cn.work.service;

import cn.work.entity.Category;
import cn.work.util.Constants;

import java.util.List;
/**
 *
 * @author 刘畅
 * @version 2019/5/24
 */
public interface CategoryService {
    public void insertT( String name, int fid, Constants.Status status);
    public void updateT(int id,String name,Constants.Status status);
    public void forbid(int id, Constants.Status status);
    public void deleteById(int id);
    public Category getCategory(int id);
    public List<Category> getAllCategorys();
    public List<Category> getCategoriesByFid(int fid);
    //public List<Category> getCategoriesByName(String name);
}
