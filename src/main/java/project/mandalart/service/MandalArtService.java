package project.mandalart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.mandalart.domain.mandalart.MandalArt;
import project.mandalart.domain.mandalart.MandalArtRepository;

@RequiredArgsConstructor
@Service
public class MandalArtService {

    private final MandalArtRepository mandalArtRepository;

    @Transactional
    public MandalArt update(Long id, MandalArt mandalArt) {
        MandalArt mandal = mandalArtRepository.findById(id).orElseThrow(()->new IllegalArgumentException("잘못된 ID입니다!"));
        mandal = mandalArt;
        return mandal;
    }

    @Transactional
    public Long createNewMandarArt() {
        return mandalArtRepository.save(new MandalArt()).getId();
    }

    @Transactional
    public MandalArt findMandalArtById(Long id) {
        return mandalArtRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("잘못된 ID입니다."));
    }

}
