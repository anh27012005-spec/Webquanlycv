package web.quan.ly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.quan.ly.entity.CvExperience;
import web.quan.ly.repository.CvExperienceRepository;
import web.quan.ly.service.CvExperienceService;

import java.util.List;

@Service
public class CvExperienceServiceImpl implements CvExperienceService {

    @Autowired
    private CvExperienceRepository cvExperienceRepository;

    @Override
    public List<CvExperience> getAll() {
        return cvExperienceRepository.findAll();
    }

    @Override
    public CvExperience getById(Integer id) {
        return cvExperienceRepository.findById(id).orElse(null);
    }

    @Override
    public CvExperience save(CvExperience cv_experience) {
        return cvExperienceRepository.save(cv_experience);
    }

    @Override
    public void delete(Integer id) {
        cvExperienceRepository.deleteById(id);
    }
}