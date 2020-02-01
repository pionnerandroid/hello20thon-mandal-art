package project.mandalart.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.mandalart.domain.mandalart.MandalItems;
import project.mandalart.domain.mandalart.MandalSubItems;

@NoArgsConstructor
@Getter
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

    public Long getItemsId() {
        return this.itemsId;
    }

    public void setItemsId(Long itemsId) {
        this.itemsId = itemsId;
    }
}
