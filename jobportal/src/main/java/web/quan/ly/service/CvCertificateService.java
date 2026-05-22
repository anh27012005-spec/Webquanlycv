package web.quan.ly.service;

import web.quan.ly.entity.Cv_certificate;

import java.util.List;

public interface CvCertificateService {

    List<Cv_certificate> getAll();

    Cv_certificate getById(Integer id);

    Cv_certificate save(Cv_certificate cv_certificate);

    void delete(Integer id);
}