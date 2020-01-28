package project.mandalart.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MandalItemsRepository extends JpaRepository<MandalItems,Long> {
    Optional<MandalItems> findById(Long mandalId);
}
