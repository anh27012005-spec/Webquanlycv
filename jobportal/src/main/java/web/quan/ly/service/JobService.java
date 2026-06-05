package web.quan.ly.service;

import web.quan.ly.dto.JobRequest;
import web.quan.ly.entity.Job;

import java.util.List;

public interface JobService {

    List<Job> getAll();

    Job getById(Integer id);

    Job create(JobRequest request);

    Job update(Integer id, JobRequest request);

    void delete(Integer id);
}