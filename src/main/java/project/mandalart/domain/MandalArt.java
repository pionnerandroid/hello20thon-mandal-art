package project.mandalart.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Table
@Entity
public class MandalArt {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mandalId;

    @Column
    @ColumnDefault("1")
    private Long version;


    @Column(nullable = false, columnDefinition = "tinyint default 1")
    boolean banned = true;


    @Column
    private String routeId;

    @Builder
    public MandalArt(String routeId) {
        this.routeId = routeId;
    }
}
