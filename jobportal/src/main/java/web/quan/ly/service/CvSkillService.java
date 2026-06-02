package web.quan.ly.service;

import web.quan.ly.entity.CvSkill;
import java.util.List;

public interface CvSkillService {

    List<CvSkill> getAll();

    CvSkill getById(Integer id);

    CvSkill create(CvSkill cvSkill);

    CvSkill save(Integer id, CvSkill cvSkill);

    void delete(Integer id);
}