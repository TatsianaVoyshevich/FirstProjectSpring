package by.overone.project.controller;

import by.overone.project.model.User;
import by.overone.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddUserController {

    private final UserService userService;

    @Autowired
    public AddUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add_user")
    public String addUserForm(Model model){
        model.addAttribute("papa", new User());
        return "add_user";
    }

    @PostMapping("/add_user")
    public String addUser(@ModelAttribute(name = "user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }

}
