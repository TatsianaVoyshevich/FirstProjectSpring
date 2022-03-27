package by.overone.project.controller;

import by.overone.project.service.SearchService;
import by.overone.project.model.User;
import by.overone.project.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SearchController {

    private SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "searchParam", required = false) String param,
                         Model model){
        if (param != null){
            model.addAttribute("users", searchService.searchUsers(param));
            return "search";
        }
        return "not found";
    }

}
