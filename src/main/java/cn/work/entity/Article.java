package cn.work.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 刘畅
 * @version 2019/5/24
 */
@Entity
@Table(name = "t_article")
public class Article {
    @Column(name = "article_id")
    @Id
    private  int pkId;
    @Column(name = "article_title")
    private  String name;
    @Column(name = "article_sort")
    private  String sort;
    @Column(name = "article_state")
    private  String state;
    @Column(name = "article_img_url")
    private  String imgUrl;
    @Column(name="article_rank")
    private String rank;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSort() {
        return sort;
    }

    public int getPkId() {
        return pkId;
    }

    public void setPkId(int pkId) {
        this.pkId = pkId;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Article{" +
                "pkId=" + pkId +
                ", name='" + name + '\'' +
                ", sort='" + sort + '\'' +
                ", state='" + state + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
