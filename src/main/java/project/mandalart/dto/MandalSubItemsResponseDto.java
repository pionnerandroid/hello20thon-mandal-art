package project.mandalart.dto;

import lombok.Getter;

@Getter
public class MandalSubItemsResponseDto {
    private Long subItemsId;
    private Long foreignId;
    private Long subSquare;
    private String subItem;

    public MandalSubItemsResponseDto(Long subItemsId, Long foreignId, Long subSquare, String subItem) {
        this.subItemsId = subItemsId;
        this.foreignId = foreignId;
        this.subSquare = subSquare;
        this.subItem = subItem;
    }
}
