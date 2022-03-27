package by.overone.project.controller;

import by.overone.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EditController {


    private UserService userService;

    @Autowired
    public EditController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") String id){
        userService.deletebyId(id);
        return "redirect:/";

    }

    public String editForm(@PathVariable("id") String id, Model model){
        model.addAttribute("user", userService.findById(id));
        return "user-edit";
    }
}
