package project.mandalart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.mandalart.domain.MandalItems;
import project.mandalart.domain.MandalItemsRepository;
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
        MandalItems mandalItems = mandalItemsRepository.getOne(itemsId);

        mandalItems.setItemsTitle(null);
        mandalItems.setItemsContent(null);

        mandalItemsRepository.save(mandalItems);
    }
}
