package project.mandalart.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.mandalart.domain.mandalart.MandalArt;
import project.mandalart.domain.mandalart.MandalArtRepository;
import project.mandalart.dto.MandalArtNoLoginSaveRequestDto;
import project.mandalart.dto.MandalArtSaveRequestDto;

@RequiredArgsConstructor
@Service
public class MandalArtService {

    private final MandalArtRepository mandalArtRepository;

    private final int NO_ID = 0;

    @Transactional
    public MandalArt getMandalArt(Long userId, Long mandalId) {

        if (IdValidation.isNoId(userId) && IdValidation.isNoId(mandalId)) {
            return mandalArtRepository.save(new MandalArtNoLoginSaveRequestDto().toEntity());
        } else if (!IdValidation.isNoId(userId) && IdValidation.isNoId(mandalId)) {
            return mandalArtRepository.save(new MandalArtSaveRequestDto(userId).toEntity());
        }


        return mandalArtRepository.findById(mandalId).orElseThrow(() -> new IllegalArgumentException("잘못된 ID입니다!"));
    }

    @Transactional
    public String getMandalArtToJson(Long userId, Long mandaId) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(getMandalArt(userId, mandaId));
    }

    @Transactional
    public Long save(MandalArtSaveRequestDto requestDto) {
        return mandalArtRepository.save(requestDto.toEntity()).getMandalId();
    }

    @Transactional
    public void delete(Long mandalId) {
        MandalArt mandalArt = mandalArtRepository.findById(mandalId).orElseThrow(() -> new IllegalArgumentException("잘못된 ID입니다!!"));
        mandalArtRepository.delete(mandalArt);
    }
}
