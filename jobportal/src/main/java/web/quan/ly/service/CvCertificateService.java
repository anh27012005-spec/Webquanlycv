package web.quan.ly.service;

import web.quan.ly.entity.CvCertificate;

import java.util.List;

public interface CvCertificateService {

    List<CvCertificate> getAll();

    CvCertificate getById(Integer id);

    CvCertificate save(CvCertificate cv_certificate);

    void delete(Integer id);
}