package by.overone.project.service;


import by.overone.project.repository.UserRepository;
import by.overone.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private UserRepository userRepository;

    @Autowired
    public SearchService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> searchUsers(String param) {
        return userRepository.findAll().stream().
                filter(user -> user.getName().contains(param)
                        || user.getSecondName().contains(param)
                        || user.getAge().contains(param)).
                collect(Collectors.toList());
    }
}