package project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import project.mandalart.domain.mandalart.MandalArt;
import project.mandalart.service.MandalArtService;

@RequiredArgsConstructor
@Controller
public class UrlController {

    private final MandalArtService mandalArtService;

    @GetMapping("/")
//    public String index(Model model, @LoginUser SessionUser user) {
    public String index() {
        return "index";
    }

    @GetMapping("/mandalart")
    public String mandalArt(Model model) {
        Long id = mandalArtService.createNewMandarArt();
        model.addAttribute("mandalart", mandalArtService.findMandalArtById(id));
        return "mandalart/mandalart";
    }

    @GetMapping("/mandalart/{userId}/{mandalId}")
    public String mandalArt(@PathVariable("userId") Long userId,
                            @PathVariable("mandalId") Long mandalId) {
        System.out.println(mandalArtService.save(userId, mandalId));
        return "mandalart/mandalart";
    }
}
