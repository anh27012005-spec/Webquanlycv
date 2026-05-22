package web.quan.ly.service;

import web.quan.ly.entity.Application;
import java.util.List;

public interface ApplicationService {

    List<Application> getAll();

    Application getById(Integer id);

    Application create(Application application);
    Application update(Integer Id , Application application);

    void delete(Integer Id);
}