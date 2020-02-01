package project.mandalart.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.mandalart.domain.BaseTimeEntity;
import project.mandalart.domain.mandalart.MandalArt;
import project.mandalart.domain.mandalart.MandalItems;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<MandalArt> mandalArts = new ArrayList<>();

    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public User(Long id) {
        this.id = id;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

    public void addMandalArts(MandalArt mandalArt) {
        mandalArts.add(mandalArt);
        mandalArt.setUser(this);
    }
}
