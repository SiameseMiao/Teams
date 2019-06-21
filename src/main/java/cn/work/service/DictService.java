package cn.work.service;

import cn.work.entity.Dict;
import cn.work.util.Constants;

import java.util.List;

/**
 * DictService Class
 *
 * @author <b>Zhengchunyu2016012011</b>, Copyright &#169; 2018
 * @version 1.0, 2019-05-25 0:01
 */
public  interface DictService {
    public void insert(String type, String code, String name, float sort, Constants.Status status);
    public void update(int id,String type, String code, String name, float sort, Constants.Status status);
    public void forbid(int id, Constants.Status status);
    public List<Dict> getDictByType(String type);
    public List<Dict> getDictByTypeAndStatus(String type,Constants.Status status);
    public List<Dict> getDict();
    public Dict getDictById(int id);
    public void delete(int id);
    public float getMaxSort(String type);
}
