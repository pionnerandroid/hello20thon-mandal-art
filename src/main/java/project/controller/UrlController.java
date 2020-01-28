package project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

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

    @PostMapping("/mandalart")
    public String createRouteId(@RequestParam(name = "routeId") String routeId) {
        System.out.println("createRouteId");
        return "mandalart/mandalart";
    }


    // mandalItems 저장
    @PostMapping("/mandalart/items")
    public String createMandalItems(@RequestParam(name = "mandalId", required = false) Long mandalId,
                                    @RequestParam(name = "itemsSquare") Long itemsSquare,
                                    @RequestParam(name = "itemsItem") String itemsItem) {

        System.out.println("createMandalItems" + itemsSquare + " " + itemsItem);
        return "mandalart/mandalart";
    }

    // subItems 저장
    @PostMapping("/mandalart/subitems")
    public String createMandalSubItems(@RequestParam(name = "mandalId") Long mandalId,
                                       @RequestParam(name = "itemsId") Long itemsId,
                                       @RequestParam(name = "itemsSquare") Long itemsSquare,
                                       @RequestParam(name = "subSquare") Long subSquare,
                                       @RequestParam(name = "itemsItem") String subItem) {

        System.out.println("createMandalSubItems");
        return "mandalart/mandalart";
    }

}
