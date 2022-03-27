package by.overone.project.service;

import by.overone.project.model.User;
import by.overone.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }


    //for delete statement
    public void deletebyId(String id){
        userRepository.deleteById(id);
    }

    //for edition statement
    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("user id  not found"));
    }

}
