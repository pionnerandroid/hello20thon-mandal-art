package project.mandalart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.mandalart.domain.MandalItems;
import project.mandalart.domain.MandalSubItems;
import project.mandalart.domain.MandalSubItemsRepository;
import project.mandalart.dto.MandalSubItemsSaveRequestDto;

@RequiredArgsConstructor
@Service
public class MandalSubItemsService {
    private final MandalSubItemsRepository subItemsRepository;
    private final MandalItemsService itemsService;

    private final int NO_ID = 0;

    // subItems 저장하기
    // NO_ID 일 때
    @Transactional
    public Long save(MandalSubItemsSaveRequestDto requestDto) {
        return subItemsRepository.save(requestDto.toEntity()).getSubItemsId();
    }

    @Transactional
    public void delete(Long subItemsId) {
        MandalSubItems subItems = subItemsRepository.findById(subItemsId).orElseThrow(() -> new IllegalArgumentException("잘못된 ID입니다."));

        subItems.setSubTitle(null);
        subItems.setSubContent(null);

        subItemsRepository.save(subItems);
    }
}
