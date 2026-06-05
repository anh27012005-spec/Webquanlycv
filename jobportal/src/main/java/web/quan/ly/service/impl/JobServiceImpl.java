package web.quan.ly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.quan.ly.dto.JobRequest;
import web.quan.ly.entity.Job;
import web.quan.ly.repository.JobRepository;
import web.quan.ly.service.JobService;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> getAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job getById(Integer id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Khong tim thay job"));
    }

    @Override
    public Job create(JobRequest request) {

        Job job = new Job();

        job.setTitle(request.getTitle());
        job.setPosition(request.getPosition());
        job.setDescription(request.getDescription());
        job.setRequirement(request.getRequirement());

        return jobRepository.save(job);
    }

    @Override
    public Job update(Integer id, JobRequest request) {

        Job job = getById(id);

        job.setTitle(request.getTitle());
        job.setPosition(request.getPosition());
        job.setDescription(request.getDescription());
        job.setRequirement(request.getRequirement());

        return jobRepository.save(job);
    }

    @Override
    public void delete(Integer id) {
        Job job = getById(id);
        jobRepository.delete(job);
    }
}