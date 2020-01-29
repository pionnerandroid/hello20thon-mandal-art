package project.mandalart.dto;

import lombok.Getter;
import project.mandalart.domain.MandalItems;

@Getter
public class MandalItemsResponseDto {
    private Long itemsId;
    private Long foreignId;
    private Long itemsSquare;
    private String itemsItem;

    public MandalItemsResponseDto(MandalItems entity) {
        this.itemsId = itemsId;
        this.foreignId = foreignId;
        this.itemsSquare = itemsSquare;
        this.itemsItem = itemsItem;
    }
}
