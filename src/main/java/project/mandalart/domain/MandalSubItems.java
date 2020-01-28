package project.mandalart.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table
public class MandalSubItems {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subItemsId;

    @ManyToOne
    @JoinColumn(name = "mandal_items_items_id")
    private MandalItems mandalItemsId;

    @Column
    private Long subSquare;

    @Column
    private String subItem;
}
