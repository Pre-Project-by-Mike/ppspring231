package org.itmentor.service;

import org.itmentor.repository.UserRepository;
import org.itmentor.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public void save(User user) {
        userRepository.add(user);
    }

    public User show(int id) {
        return userRepository.show(id);
    }

    public void remove(int id) {
        userRepository.remove(id);
    }
    public void update(int id, User updateUser) {
        userRepository.update(id, updateUser);
    }
}