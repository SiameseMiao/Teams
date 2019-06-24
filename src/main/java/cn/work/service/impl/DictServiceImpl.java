package cn.work.service.impl;

import cn.work.dao.DictDao;
import cn.work.entity.Dict;
import cn.work.service.DictService;
import cn.work.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DictServiceImpl Class
 *
 * @author <b>Zhengchunyu2016012011</b>, Copyright &#169; 2018
 * @version 1.0, 2019-05-25 12:22
 */
@Service
public  class DictServiceImpl implements DictService {
    @Autowired
    DictDao dictDao;
    @Override
    public void insert(String type, String code, String name, float sort, Constants.Status status){
        Dict dict=new Dict();
        dict.setType(type);
        dict.setCode(code);
        dict.setName(name);
        dict.setSort(sort);
        dict.setStatus(status);
        dictDao.save(dict);
    };
    @Override
    public void update(int id,String type, String code, String name, float sort, Constants.Status status){
        Dict dict = getDictById(id);
        dict.setType(type);
        dict.setCode(code);
        dict.setName(name);
        dict.setSort(sort);
        dict.setStatus(status);
        dictDao.save(dict);
    };
    @Override
    public void forbid(int id,  Constants.Status status){
        Dict dict = getDictById(id);
        dict.setStatus(status);
        dictDao.save(dict);
    };
    @Override
    public List<Dict> getDictByType(String type){
        return dictDao.findByTypeOrderBySort(type);
    };
    @Override
    public List<Dict> getDictByTypeAndStatus(String type,Constants.Status status){
        return dictDao.findByTypeAndStatusOrderBySortAsc(type,status);
    };
    @Override
    public List<Dict> getDict(){
        return dictDao.findAllByOrderByTypeAscSortAsc();
    };
    @Override
    public Dict getDictById(int id){
        return dictDao.findOne(id);
    };
    @Override
    public void delete(int id){
        dictDao.delete(id);
    };
    @Override
    public float getMaxSort(String type) {
        Dict dict = dictDao.findFirstByTypeOrderBySortDesc(type);
        if (dict == null) {
            return 0;
        } else {
            return dict.getSort();
        }

    }
}