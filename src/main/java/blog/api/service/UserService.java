package blog.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.api.model.User;
import blog.api.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);  
    }

    @SuppressWarnings("deprecation")
    public User findUserByID(Long id) {
        return userRepository.getById(id);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
