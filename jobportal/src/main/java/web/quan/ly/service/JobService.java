package web.quan.ly.service;

import web.quan.ly.entity.Job;

import java.util.List;

public interface JobService {

    List<Job> getAll();

    Job getById(Integer id);

    Job create(Job job);

    Job update(Integer id, Job job);

    void delete(Integer id);
}