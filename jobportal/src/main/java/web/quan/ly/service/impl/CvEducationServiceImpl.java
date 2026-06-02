package web.quan.ly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.quan.ly.entity.CvEducation;
import web.quan.ly.repository.CvEducationRepository;
import web.quan.ly.service.CvEducationService;

import java.util.List;

@Service
public class CvEducationServiceImpl implements CvEducationService {

    @Autowired
    private CvEducationRepository cv_educationRepository;

    @Override
    public List<CvEducation> getAll() {
        return cv_educationRepository.findAll();
    }

    @Override
    public CvEducation getById(Integer id) {
        return cv_educationRepository.findById(id).orElse(null);
    }

    @Override
    public CvEducation create(CvEducation cv_education) {
        return cv_educationRepository.save(cv_education);
    }

    @Override
    public CvEducation save(Integer id, CvEducation cv_education) {

        CvEducation old = cv_educationRepository.findById(id).orElse(null);

        if (old != null) {
            return cv_educationRepository.save(cv_education);
        }

        return null;
    }

    @Override
    public void delete(Integer id) {
        cv_educationRepository.deleteById(id);
    }
}