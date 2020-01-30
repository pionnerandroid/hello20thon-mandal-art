package project.mandalart.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Table
@Entity
public class MandalArt {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mandalId;

    @OneToMany(mappedBy = "mandalArt", cascade = CascadeType.ALL)
    private List<MandalItems> items = new ArrayList<>();

    @Column
    @ColumnDefault("1")
    private Long version;


    @Column(nullable = false, columnDefinition = "tinyint default 0")
    boolean banned = false;

    @Column
    private String routeId;

    @Builder
    public MandalArt(String routeId) {
        this.routeId = routeId;
    }

    public MandalArt(Long mandalId) {
        this.mandalId = mandalId;
    }

    public void addItems(MandalItems item) {
        items.add(item);
        item.setMandalArt(this);
    }
}
