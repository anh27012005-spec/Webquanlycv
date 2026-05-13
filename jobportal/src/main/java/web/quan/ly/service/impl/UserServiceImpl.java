package web.quan.ly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.quan.ly.entity.User;
import web.quan.ly.repository.UserRepository;
import web.quan.ly.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Integer id, User user) {

        User oldUser = userRepository.findById(id).orElse(null);

        if (oldUser != null) {

            oldUser.setName(user.getName());
            oldUser.setEmail(user.getEmail());

            return userRepository.save(oldUser);
        }

        return null;
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}