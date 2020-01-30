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
public class MandalSubItems {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subItemsId;

    @ManyToOne
    @JoinColumn(name = "mandal_items_items_id", foreignKey = @ForeignKey(name = "FK_MANDALSUBITEMS_MANDALITEMSID"))
    private MandalItems mandalItems;

    @Column
    private Long subSquare;

    @Column
    private String subItem;

    @Builder
    public MandalSubItems(MandalItems mandalItemsId, Long subSquare, String subItem) {
        this.mandalItems = mandalItemsId;
        this.subSquare = subSquare;
        this.subItem = subItem;
    }

    public void setMandalItems(MandalItems mandalItem) { this.mandalItems = mandalItem; }
}
