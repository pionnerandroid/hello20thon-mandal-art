package project.mandalart.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table
@JsonIgnoreProperties({"mandalArt"})
public class MandalItems extends BaseTimeEntity{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemsId;

    @Column
    private Long itemsSquare;

    @Column(length = 60)
    private String itemsTitle;

    @Column(columnDefinition = "TEXT")
    private String itemsContent;

    @Column(nullable = false, columnDefinition = "tinyint default 1")
    boolean enable = true;

    @OneToMany(mappedBy = "mandalItems", cascade = CascadeType.ALL)
    private List<MandalSubItems> subItems = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mandal_art_mandal_id", foreignKey = @ForeignKey(name = "FK_MANDALITEMS_MANDALART"))
    private MandalArt mandalArt;

    @Builder
    public MandalItems(MandalArt mandalArt, Long itemsSquare, String itemsTitle, String itemsContent) {
        this.mandalArt = mandalArt;
        this.itemsSquare = itemsSquare;
        this.itemsTitle = itemsTitle;
        this.itemsContent = itemsContent;
    }

    public MandalItems(Long itemsId) {
        this.itemsId = itemsId;
    }


    public void setMandalArt(MandalArt mandalArt) {
        this.mandalArt = mandalArt;
    }

    public void addSubItems(MandalSubItems subItem) {
        subItems.add(subItem);
        subItem.setMandalItems(this);
    }
}
