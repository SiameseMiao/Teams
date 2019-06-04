package cn.work.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 刘畅 @version 2019/5/24
 */
@Entity
@Table(name = "T_MANNAGE")
public class Manage {
    @Id
    private int pkId;
    private String name;
    private String alias;
    private String code;
    private String sort;
    private String state;
    private String priId;
    private String orgCode;

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public String getState() {
        return state;
    }

    public String getSort() {
        return sort;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getPriId() {
        return priId;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPriId(String priId) {
        this.priId = priId;
    }

    public int getPkId() {
        return pkId;
    }

    public void setPkId(int pkId) {
        this.pkId = pkId;
    }
}
