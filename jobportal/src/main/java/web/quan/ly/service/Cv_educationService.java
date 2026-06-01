package web.quan.ly.service;

import web.quan.ly.entity.Cv_education;
import java.util.List;



public interface Cv_educationService {
    List<Cv_education> getAll();;

    Cv_education getById(Integer id );

    Cv_education  create(Cv_education  cv_education);

    Cv_education  save(Integer id, Cv_education  cv_education);

    void delete(Integer id);



}
