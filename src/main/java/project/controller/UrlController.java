package project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.view.RedirectView;
import project.mandalart.dto.MandalArtSaveRequestDto;
import project.mandalart.service.MandalArtService;

@RequiredArgsConstructor
@Controller
public class UrlController {

    private final MandalArtService mandalArtService;

    @GetMapping("/")
    public String mandalArt(Model model) {
        Long id = mandalArtService.createNewMandarArt();
        model.addAttribute("mandalart", mandalArtService.findMandalArtById(id));
        return "mandalart/mandalart";
    }

    @GetMapping("/{mandalId}")
    public String mandalArt(@PathVariable("mandalId") Long mandalId, Model model) {
        model.addAttribute("mandalart", mandalArtService.findMandalArtById(mandalId));
        return "mandalart/mandalart";
    }

    @PostMapping("/mandalart/save")
    public RedirectView savemandalArt(@ModelAttribute MandalArtSaveRequestDto requestDto,
                                      Model model) {
        mandalArtService.update(requestDto.getId(), requestDto);
        model.addAttribute("mandalart", mandalArtService.findMandalArtById(requestDto.getId()));
        String url = "/" + requestDto.getId();
        return new RedirectView(url);
    }
}
