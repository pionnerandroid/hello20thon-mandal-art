package project.mandalart.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MandalArtRepository extends JpaRepository<MandalArt, Long> {
     Optional<MandalArt> findById(Long mandalId);
}
