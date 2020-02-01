package project.mandalart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.mandalart.domain.mandalart.MandalItems;
import project.mandalart.domain.mandalart.MandalItemsRepository;
import project.mandalart.dto.MandalItemsSaveRequestDto;

@RequiredArgsConstructor
@Service
public class MandalItemsService {
    private final MandalItemsRepository mandalItemsRepository;

    @Transactional
    public Long save(MandalItemsSaveRequestDto requestDto) {
        return mandalItemsRepository.save(requestDto.toEntity()).getItemsId();
    }

    @Transactional
    public Long saveEmptyMandalItems() {
        return mandalItemsRepository.save(new MandalItems()).getItemsId();
    }

    @Transactional
    public void delete(Long itemsId) {
        MandalItems mandalItems = mandalItemsRepository.findById(itemsId).orElseThrow(() -> new IllegalArgumentException("잘못된 ID 입니다!!"));
        mandalItems.delete();
        mandalItemsRepository.save(mandalItems);
    }
}
