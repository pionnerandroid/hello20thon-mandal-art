package project.mandalart.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.mandalart.domain.mandalart.MandalArt;
import project.mandalart.domain.mandalart.MandalItems;

@Getter
@NoArgsConstructor
public class MandalItemsSaveRequestDto {
    private Long mandalId;
    private Long itemsSquare;
    private String itemsTitle;
    private String itemsContent;

    @Builder
    public MandalItemsSaveRequestDto(Long mandalId, Long itemsSquare, String itemsTitle, String itemsContent) {
        this.mandalId = mandalId;
        this.itemsSquare = itemsSquare;
        this.itemsTitle = itemsTitle;
        this.itemsContent = itemsContent;
    }

    public MandalItems toEntity() {
        return MandalItems.builder()
                .mandalArt(new MandalArt(mandalId))
                .itemsSquare(itemsSquare)
                .itemsTitle(itemsTitle)
                .itemsContent(itemsContent)
                .build();
    }
}
