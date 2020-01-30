package project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import project.mandalart.domain.MandalArt;
import project.mandalart.domain.MandalArtRepository;
import project.mandalart.domain.MandalItems;
import project.mandalart.domain.MandalItemsRepository;
import project.mandalart.dto.MandalArtSaveRequestDto;
import project.mandalart.dto.MandalItemsSaveRequestDto;
import project.mandalart.dto.MandalSubItemsSaveRequestDto;
import project.mandalart.service.MandalArtService;
import project.mandalart.service.MandalItemsService;
import project.mandalart.service.MandalSubItemsService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class UrlController {

    private final MandalArtService mandalArtService;
    private final MandalItemsService itemsService;
    private final MandalSubItemsService subItemsService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    // readDto 로 routeId or mandalId RequestBody 구현
    @GetMapping("/mandalart")
    public @ResponseBody
    MandalArt getMandalArt(@RequestParam(name = "mandalId") Long mandalId) {
        // MandalArt, MandalItems, MandalSubItems addAttribute 하자
        return mandalArtService.getMandalArt(mandalId);
    }

    @PostMapping("/mandalart")
    public String createRouteId(@RequestParam(name = "routeId") String routeId) {
        System.out.println("createRouteId");
        return "mandalart/mandalart";
    }

    // mandalItems 저장
    @PostMapping("/mandalart/items")
    public String createMandalItems(@RequestBody MandalItemsSaveRequestDto requestDto, Model model) {
        // TODO mandalID를 mandal_art_mandal_id에 저장해라
        // 근데 mandal_art_mandal_id가 MandalArt이다

        // DB 저장
        mandalArtService.save(new MandalArtSaveRequestDto("aaa"));
        itemsService.save(requestDto);

        return "mandalart/test";
    }

    // subItems 저장
    @PostMapping("/mandalart/subitems")
    public String createMandalSubItems(@RequestBody MandalSubItemsSaveRequestDto requestDto, Model model) {
        subItemsService.save(requestDto);
        return "mandalart/mandalart";
    }
}
