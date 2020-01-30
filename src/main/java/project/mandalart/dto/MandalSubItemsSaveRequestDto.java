package project.mandalart.dto;

import lombok.Builder;
import project.mandalart.domain.MandalItems;
import project.mandalart.domain.MandalSubItems;

public class MandalSubItemsSaveRequestDto {
    private Long itemsId;
    private Long subSquare;
    private String subTitle;
    private String subContent;

    @Builder
    public MandalSubItemsSaveRequestDto(Long itemsId, Long subSquare, String subTitle, String subContent) {
        this.itemsId = itemsId;
        this.subSquare = subSquare;
        this.subTitle = subTitle;
        this.subContent = subContent;
    }

    public MandalSubItems toEntity() {
        return MandalSubItems.builder()
                .mandalItemsId(new MandalItems(itemsId))
                .subSquare(subSquare)
                .subTitle(subTitle)
                .subContent(subContent)
                .build();
    }
}
