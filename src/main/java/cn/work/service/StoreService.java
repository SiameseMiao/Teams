package cn.work.service;

import cn.work.entity.ResourceStore;

import java.util.List;

public interface StoreService {
       public void insert(String name,int Store,String dexStore,int storageType);
       public void update(int id,String name,int Store,String dexStore,int storageType);
       public List<ResourceStore> getResourceStoreByType(String storageType);
       public List<ResourceStore> getResourceStoreByTypeAndStore(String storageType,int Store);
       public List<ResourceStore>  getResourceStore();
       public ResourceStore getResourceStoreById(int id);
       public void delete(int id);

}
