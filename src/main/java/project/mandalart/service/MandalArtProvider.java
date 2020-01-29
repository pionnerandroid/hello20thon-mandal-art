package project.mandalart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.mandalart.domain.MandalItems;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MandalArtProvider {
    private MandalArtService mandalArtService;
    private MandalItemsService mandalItemsService;

    @Transactional
    public void getMandalArt(Long mandalId) {
        List<MandalItems> mandalItemsList = mandalItemsService.getMandalItems(mandalId);
//        mandalItemsList.stream().map()
    }

}
