package cn.work.service;

import cn.work.entity.Competition;
import cn.work.util.Constants;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author 刘畅
 * @version 2019/5/24
 */
public interface CompetitionService {
    public void insertT(String name, String content,Constants.Status status, int rankId, LocalDateTime createTime, LocalDateTime updateTime);
    public void updateT(int pkId, String name, String content, LocalDateTime updateTime);
    public void forbid(int pkId,  Constants.Status status);
    public void deleteById(int pkId);
    public Competition getCompetition(int pkId);
    public List<Competition> getAllCompetitions();
    public List<Competition> getAllCompetitionsByStatus(Constants.Status status);
    public List<Competition> getCompetitionByRank(int rankId);
    public List<Competition> vagueSearch(String str1,String str2);
    public List<Competition> getAllCompetitionsByName(String name);
}
