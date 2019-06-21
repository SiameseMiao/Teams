package cn.work.service.impl;

import cn.work.dao.CategoryDao;
import cn.work.entity.Category;
import cn.work.service.CategoryService;
import cn.work.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * CategoryServiceImpl Class
 *
 * @author <b>Siamese_miao</b>, Copyright &#169; 2018
 * @version 1.0, 2019-06-04 13:22
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Override
    public void insertT(String name, int fid, Constants.Status status) {
        Category category = new Category();
        category.setName(name);
        category.setFid(fid);
        category.setStatus(status);
        categoryDao.save(category);
    }

    @Override
    public void updateT(int id, String name, Constants.Status status) {
        Category category = getCategory(id);
        category.setName(name);
        category.setStatus(status);
        categoryDao.save(category);
    }

    @Override
    public void forbid(int id, Constants.Status status) {
        Category category = getCategory(id);
        category.setStatus(status);
        categoryDao.save(category);
    }

    ;

    @Override
    public void deleteById(int id) {
        categoryDao.delete(id);
    }

    @Override
    public Category getCategory(int id) {
        return categoryDao.findOne(id);
    }

    @Override
    public List<Category> getAllCategorys() {
        return categoryDao.findAll();
    }

    @Override
    public List<Category> getCategoriesByFid(int fid) {
        return categoryDao.findCategoriesByFid(fid);
    }

    @Override
    public List<Category> findCategoriesByFidAndStatus(int fid, Constants.Status status) {
        return categoryDao.findCategoriesByFidAndStatus(fid, status);
    }

}
