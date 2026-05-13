package web.quan.ly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Job create(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job update(Integer id, Job job) {

        Job oldJob = jobRepository.findById(id).orElse(null);

        if (oldJob != null) {

            oldJob.setTitle(job.getTitle());
            oldJob.setDescription(job.getDescription());
            oldJob.setLocation(job.getLocation());

            return jobRepository.save(oldJob);
        }

        return null;
    }

    @Override
    public void delete(Integer id) {
        jobRepository.deleteById(id);
    }
}