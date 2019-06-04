package cn.work.service.impl;

import cn.work.config.orm.jpa.DynamicSpecifications;
import cn.work.config.orm.jpa.SearchFilter;
import cn.work.dao.CompetitionDao;
import cn.work.entity.Competition;
import cn.work.service.CompetitionService;
import cn.work.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 * @author 刘畅
 * @version 2019/5/24
 */
@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    CompetitionDao competitionDao;
    @Override
    public void insertT(Competition competition) {
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
        return competitionDao.getAll();
    }
    @Override
    public List<Competition> getAllCompetitionsByStatus(Constants.Status status) {
        return competitionDao.getCompetitionByStatus(status);
    }
    @Override
    public List<Competition> vagueSearch(String str) {
        return competitionDao.getCompetitionsByNameOrContentLike(str);
    }
    @Override
    public List<Competition> getAllCompetitionsByName(String name) {
        return competitionDao.getCompetitionsByName(name);
    }

    public Page<Competition> getEntityPage(Map<String, Object> filterParams, int pageNumber, int pageSize){
        PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize);
        Specification<Competition> spec = buildSpecification(filterParams);
        return competitionDao.findAll(spec,pageRequest);
    }

    private Specification<Competition> buildSpecification(Map<String, Object> filterParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(filterParams);
        Specification<Competition> spec = DynamicSpecifications.bySearchFilter(filters.values(), Competition.class);
        return spec;
    }
}
