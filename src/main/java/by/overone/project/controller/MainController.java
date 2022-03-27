package by.overone.project.controller;

import by.overone.project.model.User;
import by.overone.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model){
        Iterable<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "home";
    }

}