package project.mandalart.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.mandalart.domain.MandalArt;
import project.mandalart.domain.MandalItems;

@Getter
@NoArgsConstructor
public class MandalItemsSaveRequestDto {
    private Long mandalId;
    private Long itemsSquare;
    private String itemsItem;

    @Builder
    public MandalItemsSaveRequestDto(Long mandalId, Long itemsSquare, String itemsItem) {
        this.mandalId = mandalId;
        this.itemsSquare = itemsSquare;
        this.itemsItem = itemsItem;
    }

    public MandalItems toEntity() {
        return MandalItems.builder()
                .mandalArt(new MandalArt(mandalId))
                .itemsSquare(itemsSquare)
                .itemsItem(itemsItem)
                .build();
    }
}
