package project.mandalart.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.mandalart.domain.*;
import project.mandalart.dto.MandalArtSaveRequestDto;

@RequiredArgsConstructor
@Service
public class MandalArtService {
    // final이 붙은 필드를 생성자에 넣음으로써 Bean을 주입한다.
    // 직접 @Autowired 어노테이션을 붙이거나 setter를 작성해서 Bean주입도 가능하다.
    private final MandalArtRepository mandalArtRepository;

    private final int NO_ID = 0;

    /*
     * MandalArt가 없을 때 새로 생성해준다.
     * MandalArt가 있을 때는 SELECT해서 보내준다.
     */
    @Transactional(readOnly = true)
    public MandalArt getMandalArt(Long mandalId) {
        if (mandalId == NO_ID) return mandalArtRepository.save(new MandalArtSaveRequestDto().toEntity());

        return mandalArtRepository.findById(mandalId).orElseThrow(() -> new IllegalArgumentException("잘못된 ID입니다!"));
    }

    @Transactional(readOnly = true)
    public String getMandalArtToJson(Long mandaId) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(getMandalArt(mandaId));
    }


    @Transactional
    public Long save(MandalArtSaveRequestDto requestDto) {
        return mandalArtRepository.save(requestDto.toEntity()).getMandalId();
    }
}
