package cn.work.entity;

import cn.work.util.Constants;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Competition Class @author <b>Siamese_miao</b>, Copyright &#169; 2018 @version 1.0, 2019-06-04 12:38
 */
@Entity
@Table(name = "t_competition")
public class Competition {
    @Column(name = "competition_id")
    @Id
    private int pkId;
    @Column(name = "competition_title")
    private String name;
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String content;
    @Column(name = "competition_status")
    private Constants.Status status = Constants.Status.UNDERWAY;
    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private int rank;
    @Column(name = "competition_createTime")
    private LocalDateTime createTime;
    @Column(name = "competition_updateTime")
    private LocalDateTime updateTime;

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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}