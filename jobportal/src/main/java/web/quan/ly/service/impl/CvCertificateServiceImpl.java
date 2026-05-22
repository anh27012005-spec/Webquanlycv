package web.quan.ly.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.quan.ly.entity.Cv_certificate;
import web.quan.ly.repository.CvCertificateRepository;
import web.quan.ly.service.CvCertificateService;

import java.util.List;

@Service
public class CvCertificateServiceImpl implements CvCertificateService {

    @Autowired
    private CvCertificateRepository cvCertificateRepository;

    @Override
    public List<Cv_certificate> getAll(){
        return cvCertificateRepository.findAll();
    }

    @Override
    public Cv_certificate getById(Integer id) {
        return Cv_certificate.findById(id).orElse(null);
    }

    @Override
    public Cv_certificate save(Cv_certificate cv_certificate){
        return cvCertificateRepository.save(cv_certificate);
    }
    @Override
    public void delete(Integer id) {
        Cv_certificate.deleteById(id);
    }

}
