package project.mandalart.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MandalSubItemsRepository extends JpaRepository<MandalSubItems,Long> {
    Optional<MandalSubItems> findById(Long mandalId);
}
