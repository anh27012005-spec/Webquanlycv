package web.quan.ly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.quan.ly.entity.CvCertificate;
import web.quan.ly.repository.CvCertificateRepository;
import web.quan.ly.service.CvCertificateService;

import java.util.List;

@Service
public class CvCertificateServiceImpl implements CvCertificateService {

    @Autowired
    private CvCertificateRepository cvCertificateRepository;

    @Override
    public List<CvCertificate> getAll() {
        return cvCertificateRepository.findAll();
    }

    @Override
    public CvCertificate getById(Integer id) {
        return cvCertificateRepository.findById(id).orElse(null);
    }

    @Override
    public CvCertificate save(CvCertificate cv_certificate) {
        return cvCertificateRepository.save(cv_certificate);
    }

    @Override
    public void delete(Integer id) {
        cvCertificateRepository.deleteById(id);
    }
}