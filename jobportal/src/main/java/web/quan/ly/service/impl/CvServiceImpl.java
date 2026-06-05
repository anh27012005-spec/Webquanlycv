package web.quan.ly.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.quan.ly.dto.CvRequest;
import web.quan.ly.entity.Cv;
import web.quan.ly.repository.CvRepository;
import web.quan.ly.service.CvService;

import java.util.List;

@Service
public class CvServiceImpl implements CvService {

    @Autowired
    private CvRepository CvRepository;

    @Override
    public List<Cv> getAll() {
        return CvRepository.findAll();
    }

    @Override
    public Cv getById(Integer id) {
        return CvRepository.findById(id).orElse(null);
    }

    @Override
    public Cv save(CvRequest request) {

        Cv cv = new Cv();

        cv.setTitle(request.getTitle());
        cv.setFullName(request.getFullname());
        cv.setEmail(request.getEmail());
        cv.setPhone(request.getPhone());

        return CvRepository.save(cv);
    }

    @Override
    public void delete(Integer id) {
        CvRepository.deleteById(id);
    }
}