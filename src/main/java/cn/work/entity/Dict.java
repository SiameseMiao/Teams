package cn.work.entity;

import cn.work.util.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Dict Class
 *
 * @author <b>Siamese_miao</b>, Copyright &#169; 2018
 * @version 1.0, 2019-05-24 23:39
 */
@Entity
@Table(name = "t_dict")
public class Dict {
    @Id
    @Column(name = "dict_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int dictId;
    @Column(name = "dict_type")
    private String type;
    @Column(name = "dict_code")
    private String code;
    @Column(name = "dict_name")
    private String name;
    @Column(name = "dict_sort")
    private float sort;
    @Column(name = "dict_status")
    private Constants.Status status = Constants.Status.DISABLE;

    public int getDictId() {
        return dictId;
    }

    public void setDictId(int dictId) {
        this.dictId = dictId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSort() {
        return sort;
    }

    public void setSort(float sort) {
        this.sort = sort;
    }

    public Constants.Status getStatus() {
        return status;
    }

    public void setStatus(Constants.Status status) {
        this.status = status;
    }
}
