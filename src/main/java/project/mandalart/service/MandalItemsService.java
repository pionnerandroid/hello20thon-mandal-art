package project.mandalart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.mandalart.domain.MandalItems;
import project.mandalart.domain.MandalItemsRepository;
import project.mandalart.dto.MandalItemsSaveRequestDto;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MandalItemsService {
    private final MandalItemsRepository mandalItemsRepository;

    @Transactional
    public List<MandalItems> getMandalItems(Long mandalId) {
        return mandalItemsRepository.findAllById(Collections.singleton(mandalId));
    }

    @Transactional
    public Long save(MandalItemsSaveRequestDto requestDto) {
        return mandalItemsRepository.save(requestDto.toEntity()).getItemsId();
    }
}
