package cn.work.dao;

import cn.work.entity.Dict;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DictDao Class
 *
 * @author <b>Siamese_miao</b>, Copyright &#169; 2018
 * @version 1.0, 2019-05-25 0:00
 */
@Repository
public interface DictDao extends CrudRepository<Dict,Integer> {
    /**
     * fetch data from Dict d
     *
     * @param type type
     * @return List<Dict>
     */
    List<Dict> findByTypeOrderBySort(String type);
    /**
     * fetch data from Dict d
     *
     * @return List<Dict>
     */
    List<Dict> findAllByOrderByDictIdAsc();
    /**
     * fetch data from Dict d
     *
     * @param type type
     * @return Dict
     */
    Dict findFirstByTypeOrderBySortDesc(String type);
    //Dict findFirstByOrderBySortDesc();
}
