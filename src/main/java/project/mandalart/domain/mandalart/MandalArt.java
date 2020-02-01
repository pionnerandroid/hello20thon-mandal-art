package project.mandalart.domain.mandalart;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.mandalart.domain.user.User;

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

    @OneToMany(mappedBy = "mandalArt")
    private List<MandalItems> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_MANDALART_USER"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    @Column(nullable = false, columnDefinition = "tinyint default 0")
    boolean banned = false;

    @Column
    private String routeId;

    @Builder
    public MandalArt(User user, String routeId) {
        this.user = user;
        this.routeId = routeId;
    }

    public MandalArt(Long mandalId) {
        this.mandalId = mandalId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addItems(MandalItems item) {
        items.add(item);
        item.setMandalArt(this);
    }
}
