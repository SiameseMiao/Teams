package cn.work.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_store")
public class ResourceStore {
    @Id
    @Column(name="Store_pkID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  pkID;
    @Column(name="Store_name")
    private  String name;
    @Column(name="Store_store")
    private  int store;
    @Column(name="Store_desStore")
    private  String desStore;
    @Column(name="Store_storageType")
    private  int storageType;

    public int getPkID() {
        return pkID;
    }

    public void setPkID(int pkID) {
        this.pkID = pkID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public String getDesStore() {
        return desStore;
    }

    public void setDesStore(String desStore) {
        this.desStore = desStore;
    }

    public int getStorageType() {
        return storageType;
    }

    public void setStorageType(int storageType) {
        this.storageType = storageType;
    }
}
