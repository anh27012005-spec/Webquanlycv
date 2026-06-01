package web.quan.ly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.quan.ly.entity.Cv_education;
import web.quan.ly.repository.Cv_EducationRepository;
import web.quan.ly.service.Cv_educationService;

import java.util.List;

@Service
public class Cv_educationServiceImpl implements Cv_educationService {

    @Autowired
    private Cv_EducationRepository cv_educationRepository;

    @Override
    public List<Cv_education> getAll() {
        return cv_educationRepository.findAll();
    }

    @Override
    public Cv_education getById(Integer id) {
        return cv_educationRepository.findById(id).orElse(null);
    }

    @Override
    public Cv_education create(Cv_education cv_education) {
        return cv_educationRepository.save(cv_education);
    }

    @Override
    public Cv_education save(Integer id, Cv_education cv_education) {

        Cv_education old = cv_educationRepository.findById(id).orElse(null);

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