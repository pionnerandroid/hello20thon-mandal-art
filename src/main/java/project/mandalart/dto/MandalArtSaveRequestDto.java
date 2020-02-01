package project.mandalart.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.mandalart.domain.mandalart.MandalArt;
import project.mandalart.domain.user.User;

@Getter
@NoArgsConstructor
public class MandalArtSaveRequestDto {
    private Long userId;
    private boolean banned;
    private String routId;

    @Builder
    public MandalArtSaveRequestDto(String routId) {
        this.routId = routId;
    }

    public MandalArtSaveRequestDto(Long userId) {
        this.userId = userId;
    }

    public MandalArt toEntity() {
        return MandalArt.builder()
                .user(new User(userId))
                .routeId(routId)
                .build();
    }
}
