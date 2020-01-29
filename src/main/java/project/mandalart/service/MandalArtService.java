package project.mandalart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.mandalart.domain.MandalArt;
import project.mandalart.domain.MandalArtRepository;
import project.mandalart.dto.MandalArtSaveRequestDto;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MandalArtService {
    // final이 붙은 필드를 생성자에 넣음으로써 Bean을 주입한다.
    // 직접 @Autowired 어노테이션을 붙이거나 setter를 작성해서 Bean주입도 가능하다.
    private final MandalArtRepository mandalArtRepository;

    @Transactional
    public Optional<MandalArt> getMandalArtById(Long mandalId) {
        return mandalArtRepository.findById(mandalId);
    }

    @Transactional
    public Long save(MandalArtSaveRequestDto requestDto) {
        return  mandalArtRepository.save(requestDto.toEntity()).getMandalId();
    }
}
