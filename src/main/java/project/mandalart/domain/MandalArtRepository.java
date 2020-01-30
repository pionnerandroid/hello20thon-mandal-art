package project.mandalart.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MandalArtRepository extends JpaRepository<MandalArt, Long> {
//    MandalArt findById(Long mandalId);

//    select *
//    from mandalart a, mandal_items b, mandal_subitems as `c`
//    where a.mandal_id = b.mandal_id

//    @Query("select m from mandal_art m join fetch m.mandal_items")
//    List<MandalArt> findAllJoinFetch();
}
