package project.mandalart.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.mandalart.domain.mandalart.MandalArt;

@Getter
@NoArgsConstructor
public class MandalArtNoLoginSaveRequestDto {
    private boolean banned;
    private String routId;

    @Builder
    public MandalArtNoLoginSaveRequestDto(String routId) {
        this.routId = routId;
    }

    public MandalArt toEntity() {
        return MandalArt.builder()
                .user(null)
                .routeId(routId)
                .build();
    }
}
