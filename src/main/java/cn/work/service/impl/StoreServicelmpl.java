package cn.work.service.impl;
import cn.work.dao.StoreDao;
import cn.work.entity.ResourceStore;
import cn.work.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 *
 * @author cj
 * @version 2019/6/18
 */
@Service
public class StoreServicelmpl implements StoreService {
    @Autowired
     StoreDao storeDao;
    @Override
    public void insert(String name,int Store,String dexStore,int storageType){
     ResourceStore store=new ResourceStore();
     store.setDesStore(dexStore);
     store.setName(name);
     store.setStorageType(storageType);
     store.setStore(Store);
     storeDao.save(store);
    }
    @Override
    public void update(int id,String name,int Store,String dexStore,int storageType){
     ResourceStore store=getResourceStoreById(id);
     store.setName(name);
     store.setStore(Store);
     store.setDesStore(dexStore);
     store.setStorageType(storageType);
     storeDao.save(store);
    }
    @Override
    public List<ResourceStore> getResourceStoreByType(String storageType){
       return storeDao.findByStorageType(storageType);
    }
    @Override
    public ResourceStore getResourceStoreByStore(int Store){
        return storeDao.findByStore(Store);
    }
    @Override
    public List<ResourceStore>  getResourceStore(){
          return storeDao.findAllByOrderByPkIDAsc();
    }
    @Override
    public ResourceStore getResourceStoreById(int pkID){
         return storeDao.findOne(pkID);
    }
    @Override
    public void delete(int pkID){
         storeDao.delete(pkID);
    }


}
