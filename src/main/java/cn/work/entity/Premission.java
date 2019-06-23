package cn.work.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_premission")
public class Premission {
    @Id
    @Column(name = "premission_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "premission_name")
    private String premissionName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermissionName() {
        return premissionName;
    }

    public void setPermissionName(String permissionName) {
        this.premissionName = permissionName == null ? null : permissionName.trim();
    }

}