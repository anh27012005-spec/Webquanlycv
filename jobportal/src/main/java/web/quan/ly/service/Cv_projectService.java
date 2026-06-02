package web.quan.ly.service;

import web.quan.ly.entity.CvProject;
import java.util.List;

public interface Cv_projectService {

    List<CvProject> getAll();

    CvProject getById(Integer id);

    CvProject create(CvProject cv_project);

    CvProject save(Integer id , CvProject cv_project);

    void delete(Integer id);

}
