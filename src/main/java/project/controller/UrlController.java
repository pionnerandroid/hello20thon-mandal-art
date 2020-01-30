package project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@RequiredArgsConstructor
@Controller
public class UrlController {

    private final MandalArtService mandalArtService;
    private final MandalItemsService itemsService;
    private final MandalSubItemsService subItemsService;

    private final int NO_ID = 0;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    // readDto 로 routeId or mandalId RequestBody 구현
    // test code
//    @GetMapping("/mandalart")
//    public @ResponseBody
//    MandalArt getMandalArt(@RequestParam(name = "mandalId") Long mandalId) {
//        return mandalArtService.getMandalArt(mandalId);
//    }


    @GetMapping("/mandalart")
    public String mandalArt(@RequestParam(name = "mandalId") Long mandalId, Model model) throws JsonProcessingException {
        model.addAttribute("mandalArt", mandalArtService.getMandalArtToJson(mandalId));
        return "mandalart/mandalart";
    }

    @PostMapping("/mandalart")
    public String createRouteId(@RequestParam(name = "routeId") String routeId) {
        System.out.println("createRouteId");
        return "mandalart/mandalart";
    }

    // mandalItems 저장
    @PostMapping("/mandalart/items/save")
    public String createMandalItems(@RequestBody MandalItemsSaveRequestDto requestDto) {
        itemsService.save(requestDto);
        return "mandalart/test";
    }

    // subItems 저장
    @PostMapping("/mandalart/subitems/save")
    public String createMandalSubItems(@RequestBody MandalSubItemsSaveRequestDto requestDto, Model model) {
        subItemsService.save(requestDto);
        return "mandalart/mandalart";
    }
}
