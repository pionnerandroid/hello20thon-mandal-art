package project.mandalart.dto;

import lombok.Builder;
import project.mandalart.domain.MandalArt;
import project.mandalart.domain.MandalItems;
import project.mandalart.domain.MandalSubItems;

public class MandalSubItemsSaveRequestDto {
    private Long itemsId;
    private Long subSquare;
    private String subItem;

    @Builder
    public MandalSubItemsSaveRequestDto(Long itemsId, Long subSquare, String subItem) {
        this.itemsId = itemsId;
        this.subSquare = subSquare;
        this.subItem = subItem;
    }


    public MandalSubItems toEntity() {
        return MandalSubItems.builder()
                .mandalItemsId(new MandalItems(itemsId))
                .subSquare(subSquare)
                .subItem(subItem)
                .build();
    }
}
