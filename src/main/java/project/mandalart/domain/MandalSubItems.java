package project.mandalart.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table
@JsonIgnoreProperties({"mandalItems"})
public class MandalSubItems extends BaseTimeEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subItemsId;

    @Column
    private Long subSquare;

    @Column(length = 60)
    private String subTitle;

    @Column(columnDefinition = "TEXT")
    private String subContent;

    @Column(nullable = false, columnDefinition = "tinyint default 1")
    boolean enable = true;

    @ManyToOne
    @JoinColumn(name = "mandal_items_items_id", foreignKey = @ForeignKey(name = "FK_MANDALSUBITEMS_MANDALITEMSID"))
    private MandalItems mandalItems;

    @Builder
    public MandalSubItems(MandalItems mandalItemsId, Long subSquare, String subTitle, String subContent) {
        this.mandalItems = mandalItemsId;
        this.subSquare = subSquare;
        this.subTitle = subTitle;
        this.subContent = subContent;
    }

    public void setMandalItems(MandalItems mandalItem) { this.mandalItems = mandalItem; }
}
