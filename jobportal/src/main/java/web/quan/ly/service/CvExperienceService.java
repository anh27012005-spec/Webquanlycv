package web.quan.ly.service;

import web.quan.ly.entity.Cv_experience;

import java.util.List;

public interface CvExperienceService {

    List<Cv_experience> getAll();

    Cv_experience getById(Integer id);

    Cv_experience save(Cv_experience cv_experience);

    void delete(Integer id);
}