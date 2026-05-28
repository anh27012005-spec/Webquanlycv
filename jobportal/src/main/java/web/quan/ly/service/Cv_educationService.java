package web.quan.ly.service;

import web.quan.ly.repository.Cv_EducationRepository;
import web.quan.ly.entity.Cv_education;
import java.util.List;



public interface Cv_educationService {
    List<Cv_EducationRepository> GetAll();

    Cv_education getById(Integer id );

    Cv_education  create(Cv_education  cv_education);

    Cv_education  update(Integer id, Cv_education  cv_education);

    void delete(Integer id);



}
