package project.mandalart.domain.mandalart;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.mandalart.domain.BaseTimeEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@JsonIgnoreProperties({"mandalArt"})
@Entity
@Table
public class MandalItems extends BaseTimeEntity {
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

    @OneToMany(mappedBy = "mandalItems")
    private List<MandalSubItems> subItems = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "mandal_art_mandal_id", foreignKey = @ForeignKey(name = "FK_MANDALITEMS_MANDALART"))
    private MandalArt mandalArt;

    @Builder
    public MandalItems(MandalArt mandalArt, Long itemsSquare, String itemsTitle, String itemsContent) {
        this.mandalArt = mandalArt;
        this.itemsSquare = itemsSquare;
        this.itemsTitle = itemsTitle;
        this.itemsContent = itemsContent;
    }

    @Builder
    public MandalItems(Long itemsId, MandalArt mandalArt, Long itemsSquare, String itemsTitle, String itemsContent) {
        this.itemsId = itemsId;
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

//    public void setItemsTitle(String itemsTitle) {
//        this.itemsTitle = itemsTitle;
//    }
//
//    public void setItemsContent(String itemsContent) {
//        this.itemsContent = itemsContent;
//    }

    public void delete() {
        this.itemsTitle = null;
        this.itemsContent = null;
    }

    public void update(String itemsTitle, String itemsContent) {
        this.itemsTitle = itemsTitle;
        this.itemsContent = itemsContent;
    }

    public void addSubItems(MandalSubItems subItem) {
        subItems.add(subItem);
        subItem.setMandalItems(this);
    }
}
