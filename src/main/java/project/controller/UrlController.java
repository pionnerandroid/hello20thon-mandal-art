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
        System.out.println(mandalArtService.findMandalArtById(id).toString());
        return "mandalart/mandalart";
    }

    @GetMapping("/mandalart/{userId}/{mandalId}")
    public String mandalArt(@PathVariable("userId") Long userId,
                            @PathVariable("mandalId") Long mandalId, Model model) {
        model.addAttribute("mandalart", mandalArtService.findMandalArtById(mandalId));
        return "mandalart/mandalart";
    }

    @PostMapping("/mandalart")
    public String savemandalArt(@ModelAttribute MandalArt mandalArt,
                                Model model) {
        System.out.println(mandalArt.toString());
//        model.addAttribute("mandalart",
//                mandalArtService.update(mandalArt.getId(), mandalArt));
        return "mandalart/mandalart";
    }
}
