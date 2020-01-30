package project.mandalart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
}
