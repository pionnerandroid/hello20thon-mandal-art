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
public class MandalItems {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemsId;

    @OneToMany(mappedBy = "mandalItems", cascade = CascadeType.ALL)
    private List<MandalSubItems> subItems = new ArrayList<>();

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mandal_art_mandal_id", foreignKey = @ForeignKey(name = "FK_MANDALITEMS_MANDALART"))
    private MandalArt mandalArt;

    @Column
    private Long itemsSquare;

    @Column
    private String itemsItem;

    @Builder
    public MandalItems(MandalArt mandalArt, Long itemsSquare, String itemsItem) {
        this.mandalArt = mandalArt;
        this.itemsSquare = itemsSquare;
        this.itemsItem = itemsItem;
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
