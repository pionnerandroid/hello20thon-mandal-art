package project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import project.mandalart.config.auth.LoginUser;
import project.mandalart.config.auth.dto.SessionUser;
import project.mandalart.domain.mandalart.MandalArt;
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
    public String index(Model model, @LoginUser SessionUser user) {

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    // readDto 로 routeId or mandalId RequestBody 구현
    // test code
//    @GetMapping("/mandalart")
//    public @ResponseBody
//    MandalArt getMandalArt(@RequestParam(name = "mandalId") Long mandalId) {
//        return mandalArtService.getMandalArt(mandalId);
//    }

    @GetMapping("/mandalart/{userId}/{mandalId}")
    public String mandalArt(@PathVariable("userId") Long userId,
                            @RequestParam(name = "mandalId") Long mandalId, Model model) throws JsonProcessingException {
        String mandalArt = mandalArtService.getMandalArtToJson(userId, mandalId);
        model.addAttribute("mandalart", mandalArt);
        return "mandalart/mandalart";
    }

    @PostMapping("/mandalart/{userId}/{mandalId}")
    public @ResponseBody
    MandalArt createRouteId(@PathVariable("userId") Long userId,
                            @PathVariable("mandalId") Long mandalId,
                            @RequestParam(name = "routeId") String routeId) {

        return mandalArtService.getMandalArt(userId, mandalId);
    }

    // mandalItems 저장
    @PostMapping("/mandalart/items/save/{userId}/{mandalId}")
    public @ResponseBody
    MandalArt createMandalItems(@PathVariable("userId") Long userId,
                                @PathVariable("mandalId") Long mandalId,
                                @RequestBody MandalItemsSaveRequestDto requestDto) {
        itemsService.save(requestDto);
        return mandalArtService.getMandalArt(userId, mandalId);
    }

    // subItems 저장
    @PostMapping("/mandalart/subitems/save/{userId}/{mandalId}")
    public @ResponseBody
    MandalArt createMandalSubItems(@PathVariable("userId") Long userId,
                                   @PathVariable("mandalId") Long mandalId,
                                   @RequestBody MandalSubItemsSaveRequestDto requestDto) {
        if (requestDto.getItemsId() == NO_ID) {
            Long itemsId = itemsService.saveEmptyMandalItems();
            requestDto.setItemsId(itemsId);
        }
        subItemsService.save(requestDto);
        return mandalArtService.getMandalArt(userId, mandalId);
    }

    @DeleteMapping("/mandalart/delete/{userId}/{mandalId}")
    public @ResponseBody
    MandalArt deleteMandalArt(@PathVariable("userId") Long userId,
                              @PathVariable("mandalId") Long mandalId) {
//                              @RequestParam(name = "mandalId") Long mandalId) {
        mandalArtService.delete(mandalId);
        return mandalArtService.getMandalArt(userId, mandalId);
    }

    @DeleteMapping("/mandalart/items/delete/{userId}/{mandalId}")
    public @ResponseBody
    MandalArt deleteMandalItems(@PathVariable("userId") Long userId,
                                @PathVariable("mandalId") Long mandalId,
                                @RequestParam(name = "itemsId") Long itemsId) {
        itemsService.delete(itemsId);
        return mandalArtService.getMandalArt(userId, mandalId);
    }

    @DeleteMapping("/mandalart/subitems/delete/{userId}/{mandalId}")
    public @ResponseBody
    MandalArt deleteSubItems(@PathVariable("userId") Long userId,
                             @PathVariable("mandalId") Long mandalId,
                             @RequestParam(name = "subItemsId") Long subItemsId) {
        subItemsService.delete(subItemsId);
        return mandalArtService.getMandalArt(userId, mandalId);
    }
}
