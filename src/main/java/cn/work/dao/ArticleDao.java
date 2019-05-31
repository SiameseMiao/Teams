package cn.work.dao;

import cn.work.entity.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 *
 * @author 刘畅
 * @version 2019/5/24
 */
@Repository
public interface ArticleDao extends CrudRepository<Article, Integer> {
    @Query(value="SELECT article_id,article_title,article_img_url,article_sort,article_state,article_rank FROM t_article t WHERE article_title LIKE %?1%",nativeQuery=true)
    public List<Article> getArticleByNameLike(String name);
    public List<Article> findAll();
}
