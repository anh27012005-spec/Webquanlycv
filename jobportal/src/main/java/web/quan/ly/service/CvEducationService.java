package web.quan.ly.service;

import web.quan.ly.entity.CvEducation;
import java.util.List;

public interface CvEducationService {
    List<CvEducation> getAll();

    CvEducation getById(Integer id );

    CvEducation create(CvEducation cv_education);

    CvEducation save(Integer id, CvEducation cv_education);

    void delete(Integer id);



}
