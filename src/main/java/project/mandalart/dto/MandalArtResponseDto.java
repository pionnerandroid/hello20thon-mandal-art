package project.mandalart.dto;

import lombok.Getter;

@Getter
public class MandalArtResponseDto {
    private Long mandalId;
    private String routeId;
    private boolean banned;

    public MandalArtResponseDto(Long mandalId, String routeId, boolean banned) {
        this.mandalId = mandalId;
        this.routeId = routeId;
        this.banned = banned;
    }
}
