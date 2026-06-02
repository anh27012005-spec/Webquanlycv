package web.quan.ly.service;

import web.quan.ly.entity.CvExperience;

import java.util.List;

public interface CvExperienceService {

    List<CvExperience> getAll();

    CvExperience getById(Integer id);

    CvExperience save(CvExperience cv_experience);

    void delete(Integer id);
}