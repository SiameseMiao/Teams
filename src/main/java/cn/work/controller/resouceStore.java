package cn.work.controller;

public class resouceStore {
    private int  pkID;
    private  String name;
    private  String store;
    private  String desStore;
    private  String storageType;

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDesStore(String desStore) {
        this.desStore = desStore;
    }

    public String getDesStore() {
        return desStore;
    }

    public void setPkID(int pkID) {
        this.pkID = pkID;
    }

    public int getPkID() {
        return pkID;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getStore() {
        return store;
    }

}
