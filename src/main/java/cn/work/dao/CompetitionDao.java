package cn.work.dao;

import cn.work.config.orm.PlatformRepository;
import cn.work.entity.Category;
import cn.work.entity.Competition;
import cn.work.util.Constants;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CompetitionDao Class
 *
 * @author <b>Siamese_miao</b>, Copyright &#169; 2018
 * @version 1.0, 2019-06-04 13:27
 */
@Repository
public interface CompetitionDao extends PlatformRepository<Competition,Integer> {
    /**
     * fetch data from Competition c
     *
     * @return List<Competition>
     */
    List<Competition> findAllByOrderByCreateTimeDesc();
    /**
     * fetch data from Competition c
     *
     * @param status status
     * @return List<Competition>
     */
    public List<Competition> getCompetitionByStatus(Constants.Status status);
    /**
     * fetch data from Competition c
     *
     * @param rank rank
     * @return List<Competition>
     */
    public List<Competition> getCompetitionByRank(Category rank);
    /**
     * fetch data from Competition c
     *
     * @param str1 name
     * @param str2 content
     * @return List<Competition>
     */
    public List<Competition> getCompetitionsByNameLikeOrContentLike(String str1,String str2);
    /**
     * fetch data from Competition c
     *
     * @param rank rank
     * @param name name
     * @return List<Competition>
     */
    public List<Competition> getCompetitionsByRankAndNameLike(Category rank,String name);
    /**
     * fetch data from Competition c
     *
     * @return Competition
     */
    public Competition findFirstByOrderByPkIdDesc();
}
