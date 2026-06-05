package web.quan.ly.service;

import web.quan.ly.dto.CvRequest;
import web.quan.ly.entity.Cv;

import java.util.List;

public interface CvService {

    List<Cv> getAll();

    Cv getById(Integer id);

    Cv save(CvRequest request);

    void delete(Integer id);
}