package web.quan.ly.service;

import web.quan.ly.entity.Cv;

import java.util.List;

public interface CvService {

    List<Cv> getAll();

    Cv getById(Integer id);

    Cv save(Cv cv);

    void delete(Integer id);
}