package web.quan.ly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.quan.ly.entity.Application;
import web.quan.ly.entity.Job;
import web.quan.ly.entity.User;
import web.quan.ly.repository.ApplicationRepository;
import web.quan.ly.repository.JobRepository;
import web.quan.ly.repository.UserRepository;
import web.quan.ly.service.ApplicationService;
import web.quan.ly.entity.enums.StatusApplication;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public Application apply(Integer jobId, String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        Application app = new Application();
        app.setUser(user);
        app.setJob(job);
        app.setStatusApplication(StatusApplication.PENDING);

        return applicationRepository.save(app);
    }

    @Override
    public List<Application> getAll() {
        return applicationRepository.findAll();
    }

    @Override
    public Application getById(Integer id) {
        return applicationRepository.findById(id).orElse(null);
    }

    @Override
    public Application create(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Application update(Integer id, Application application) {
        application.setId(id);
        return applicationRepository.save(application);
    }

    @Override
    public void delete(Integer id) {
        applicationRepository.deleteById(id);
    }
}