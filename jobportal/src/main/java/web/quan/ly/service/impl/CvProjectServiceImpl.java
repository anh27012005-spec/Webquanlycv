package web.quan.ly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.quan.ly.entity.CvProject;
import web.quan.ly.repository.CvProjectRepository;
import web.quan.ly.service.Cv_projectService;

import java.util.List;

@Service
public class CvProjectServiceImpl implements Cv_projectService {

    @Autowired
    private CvProjectRepository cv_projectRepository;

    @Override
    public List<CvProject> getAll() {
        return cv_projectRepository.findAll();
    }

    @Override
    public CvProject getById(Integer id) {
        return cv_projectRepository.findById(id).orElse(null);
    }

    @Override
    public CvProject create(CvProject cv_project) {
        return cv_projectRepository.save(cv_project);
    }

    @Override
    public CvProject save(Integer id, CvProject cv_project) {

        CvProject old = cv_projectRepository.findById(id).orElse(null);

        if (old != null) {
            cv_project.setId(id);
            return cv_projectRepository.save(cv_project);
        }

        return null;
    }

    @Override
    public void delete(Integer id) {
        cv_projectRepository.deleteById(id);
    }
}