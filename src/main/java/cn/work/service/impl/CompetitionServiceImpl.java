package cn.work.service.impl;

import cn.work.config.orm.jpa.DynamicSpecifications;
import cn.work.config.orm.jpa.SearchFilter;
import cn.work.dao.CategoryDao;
import cn.work.dao.CompetitionDao;
import cn.work.entity.Category;
import cn.work.entity.Competition;
import cn.work.service.CompetitionService;
import cn.work.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * CompetitionServiceImpl Class
 *
 * @author <b>Siamese_miao</b>, Copyright &#169; 2018
 * @version 1.0, 2019-06-04 13:32
 */
@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    CompetitionDao competitionDao;
    @Autowired
    CategoryDao categoryDao;
    @Override
    public void insertT(String name, String content, Constants.Status status, Category rank, String createTime, String updateTime) {
        Competition competition=new Competition();
        competition.setName(name);
        competition.setContent(content);
        competition.setStatus(status);
        competition.setRank(rank);
        competition.setCreateTime(createTime);
        competition.setUpdateTime(updateTime);
        competitionDao.save(competition);
    }
    @Override
    public void updateT(int pkId, String name, String content, String updateTime){
        Competition competition=getCompetition(pkId);
        competition.setName(name);
        competition.setContent(content);
        competition.setUpdateTime(updateTime);
        competitionDao.save(competition);
    }
    @Override
    public void forbid(int pkId,  Constants.Status status){
        Competition competition=getCompetition(pkId);
        competition.setStatus(status);
        competitionDao.save(competition);
    }
    @Override
    public void deleteById(int pkId) {
        competitionDao.delete(pkId);
    }

    @Override
    public Competition getCompetition(int pkId) {
        return competitionDao.findOne(pkId);
    }

    @Override
    public List<Competition> getAllCompetitions() {
        return competitionDao.findAllByOrderByCreateTimeDesc();
    }
    @Override
    public List<Competition> getCompetitionByRank(Category rank) {
        return competitionDao.getCompetitionByRank(rank);
    }
    @Override
    public List<Competition> getAllCompetitionsByStatus(Constants.Status status) {
        return competitionDao.getCompetitionByStatus(status);
    }
    @Override
    public List<Competition> vagueSearch(String str1,String str2) {
        return competitionDao.getCompetitionsByNameLikeOrContentLike(str1,str2);
    }
    @Override
    public List<Competition> getAllCompetitionsByRankAndName(Category rank,String name) {
        return competitionDao.getCompetitionsByRankAndNameLike(rank,name);
    }


    @Override
    public Page<Competition> getEntityPage(Map<String, Object> filterParams, int pageNumber, int pageSize){
        PageRequest pageRequest = buildPageRequest(pageNumber - 1, pageSize,"updateTime");
        Specification<Competition> spec = buildSpecification(filterParams);
        return competitionDao.findAll(spec,pageRequest);
    }

    private PageRequest buildPageRequest(int pageNumber, int pageSize, String sortType) {
        Sort sort  = new Sort(Sort.Direction.DESC, "updateTime");
        return new PageRequest(pageNumber , pageSize, sort);
    }

    private Specification<Competition> buildSpecification(Map<String, Object> filterParams) {
        if(!filterParams.values().isEmpty()){
            try {
                int rankId=Integer.valueOf(filterParams.get("EQ_rank").toString());
                Category rank = categoryDao.findOne(rankId);
                filterParams.put("EQ_rank",rank);
            }catch (Exception e){}
        }
        Map<String, SearchFilter> filters = SearchFilter.parse(filterParams);
        Specification<Competition> spec = DynamicSpecifications.bySearchFilter(filters.values(), Competition.class);
        return spec;
    }
}
