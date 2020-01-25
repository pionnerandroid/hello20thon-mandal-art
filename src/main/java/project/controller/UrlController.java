package project.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UrlController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/mandalart")
    public String madalart(Model model) {
        return "mandalart/mandalart";
    }
}
