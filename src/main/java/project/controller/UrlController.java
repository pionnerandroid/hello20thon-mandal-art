package project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UrlController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/mandalart")
    public String madalart() {
        return "mandalart/mandalart";
    }
}
