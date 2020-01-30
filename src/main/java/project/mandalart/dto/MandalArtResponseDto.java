package project.mandalart.dto;

import lombok.Getter;
import project.mandalart.domain.MandalItems;

import java.util.List;

@Getter
public class MandalArtResponseDto {
    private Long mandalId;
    private String routeId;
    private boolean banned;
    private List<MandalItems> mandalItems;

    public MandalArtResponseDto(Long mandalId, String routeId, boolean banned, List<MandalItems> mandalItems) {
        this.mandalId = mandalId;
        this.routeId = routeId;
        this.banned = banned;
        this.mandalItems = mandalItems;
    }
}
