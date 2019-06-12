package cn.work.entity;

public class ResourceStore {
    private int  pkID;
    private  String name;
    private  String store;
    private  String desStore;
    private  String storageType;

    public String getStore() {
        return store;
    }

    public int getPkID() {
        return pkID;
    }

    public String getDesStore() {
        return desStore;
    }

    public String getName() {
        return name;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public void setPkID(int pkID) {
        this.pkID = pkID;
    }

    public void setDesStore(String desStore) {
        this.desStore = desStore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

}
