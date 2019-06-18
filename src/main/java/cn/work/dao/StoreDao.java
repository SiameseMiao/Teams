package cn.work.dao;

import cn.work.entity.ResourceStore;
import cn.work.entity.ResourceStore;
import cn.work.util.Constants;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StoreDao extends CrudRepository<ResourceStore,Integer> {
    /**
     * fetch data from ResourceStore d
     *
     * @return List<ResourceStore>
     */
    @Override
    List<ResourceStore> findAll();
    /**
     * fetch data from ResourceStore d
     *
     * @param id pkId
     * @return ResourceStore
     */
    ResourceStore findOneByPkID(int id);
    /**
     * fetch data from ResourceStore d
     *
     * @param type storageType
     * @return List<ResourceStore>
     */
    List<ResourceStore> findByTypeOrderBySort(String type);
    /**
     * fetch data from ResourceStore d
     *
     * @param type storageType
     * @param store store
     * @return List<ResourceStore>
     */
    List<ResourceStore> findByTypeAndStoreOrderBySortAsc(String type, int store);
    /**
     * fetch data from ResourceStore d
     *
     * @return List<ResourceStore>
     */
    List<ResourceStore> findAllByOrderByResourceStoreIdAsc();
    /**
     * fetch data from ResourceStore d
     *
     * @param type storageType
     * @return ResourceStore
     */
    ResourceStore findFirstByTypeOrderBySortDesc(String type);
}
