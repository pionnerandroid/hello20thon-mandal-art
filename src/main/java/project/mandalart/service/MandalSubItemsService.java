package project.mandalart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.mandalart.domain.MandalSubItemsRepository;
import project.mandalart.dto.MandalItemsSaveRequestDto;
import project.mandalart.dto.MandalSubItemsSaveRequestDto;

@RequiredArgsConstructor
@Service
public class MandalSubItemsService {
    private final MandalSubItemsRepository subItemsRepository;

    // subItems 저장하기
    @Transactional
    public Long save(MandalSubItemsSaveRequestDto requestDto) {
        return subItemsRepository.save(requestDto.toEntity()).getSubItemsId();
    }
}
