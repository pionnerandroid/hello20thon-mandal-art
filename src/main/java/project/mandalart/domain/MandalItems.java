package project.mandalart.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@NoArgsConstructor
@Getter
@Entity
@Table
public class MandalItems {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemsId;

    @ManyToOne
    @JoinColumn(name = "mandal_art_mandal_id")
    private MandalArt mandalArt;

    @Column
    private Long itemsSquare;

    @Column
    private String itemsItem;
}
