package project.mandalart.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.mandalart.domain.mandalart.MandalArt;

@Getter
@NoArgsConstructor
public class MandalArtSaveRequestDto {
    private short version;
    private boolean banned;
    private String routId;

    @Builder
    public MandalArtSaveRequestDto(String routId) {
        this.routId = routId;
    }

    public MandalArt toEntity() {
        return MandalArt.builder()
                .routeId(routId)
                .build();
    }


    // 최초에 routeId만 수정하게
    // banned만 수정
    // version만 수정하게
}
