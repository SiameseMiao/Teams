package cn.work.service;

import cn.work.entity.Category;
import cn.work.entity.Competition;
import cn.work.util.Constants;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * CompetitionService Class
 *
 * @author <b>Siamese_miao</b>, Copyright &#169; 2018
 * @version 1.0, 2019-06-04 13:30
 */
public interface CompetitionService {
    public void insertT(String name, String content, Constants.Status status, Category rank, String createTime, String updateTime);
    public void updateT(int pkId, String name, String content, String updateTime);
    public void forbid(int pkId,  Constants.Status status);
    public void deleteById(int pkId);
    public Competition getCompetition(int pkId);
    public List<Competition> getAllCompetitions();
    public List<Competition> getAllCompetitionsByStatus(Constants.Status status);
    public List<Competition> getCompetitionByRank(Category rank);
    public List<Competition> vagueSearch(String str1,String str2);
    public List<Competition> getAllCompetitionsByRankAndName(Category rank,String name);
    public Page<Competition> getEntityPage(Map<String, Object> filterParams, int pageNumber, int pageSize);
}
