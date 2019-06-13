package cn.work.entity;

import cn.work.util.Constants;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Competition Class
 *
 * @author <b>Siamese_miao</b>, Copyright &#169; 2018
 * @version 1.0, 2019-06-04 12:38
 */
@Entity
@Table(name = "t_competition")
public class Competition {
    @Column(name = "competition_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pkId;
    @Column(name = "competition_title")
    private String name;
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String content;
    @Column(name = "competition_status")
    private Constants.Status status = Constants.Status.UNDERWAY;
    @ManyToOne(targetEntity = Category.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category rank;
    @Column(name = "competition_createTime",columnDefinition="datetime")
    private String createTime=LocalDateTime.now().toString().replace("T"," ");
    @Column(name = "competition_updateTime",columnDefinition="datetime")
    private String updateTime=LocalDateTime.now().toString().replace("T"," ");

    public int getPkId() {
        return pkId;
    }

    public void setPkId(int pkId) {
        this.pkId = pkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Constants.Status getStatus() {
        return status;
    }

    public void setStatus(Constants.Status status) {
        this.status = status;
    }

    public Category getRank() {
        return rank;
    }

    public void setRank(Category rank) {
        this.rank = rank;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}