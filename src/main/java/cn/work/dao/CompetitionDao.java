package cn.work.dao;

import cn.work.config.orm.PlatformRepository;
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
    public List<Competition> getAll();
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
     * @param str name or content
     * @return List<Competition>
     */
    public List<Competition> getCompetitionsByNameOrContentLike(String str);
    /**
     * fetch data from Competition c
     *
     * @param name name
     * @return List<Competition>
     */
    public List<Competition> getCompetitionsByName(String name);
}
