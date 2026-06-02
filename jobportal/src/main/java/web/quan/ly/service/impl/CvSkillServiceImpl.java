package web.quan.ly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.quan.ly.entity.CvSkill;
import web.quan.ly.repository.CvSkillRepository;
import web.quan.ly.service.CvSkillService;

import java.util.List;

@Service
public class CvSkillServiceImpl implements CvSkillService {

    @Autowired
    private CvSkillRepository cvSkillRepository;

    @Override
    public List<CvSkill> getAll() {
        return cvSkillRepository.findAll();
    }

    @Override
    public CvSkill getById(Integer id) {
        return cvSkillRepository.findById(id).orElse(null);
    }

    @Override
    public CvSkill create(CvSkill cvSkill) {
        return cvSkillRepository.save(cvSkill);
    }

    @Override
    public CvSkill save(Integer id, CvSkill cvSkill) {

        CvSkill existing = cvSkillRepository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setCv(cvSkill.getCv());
        existing.setSkill_name(cvSkill.getSkill_name());
        existing.setLevel(cvSkill.getLevel());

        return cvSkillRepository.save(existing);
    }

    @Override
    public void delete(Integer id) {
        cvSkillRepository.deleteById(id);
    }
}