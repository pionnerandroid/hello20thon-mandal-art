package project.mandalart.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Table
@Entity
@NoArgsConstructor
@Getter
public class MandalArt{
    @Id
    @Column(columnDefinition = "BINARY(16)")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    private UUID uuid;

    @Column
    private String nothing;

    @Builder
    public MandalArt(String nothing) {
//        this.uuid = uuid;
        this.nothing = nothing;
    }
}
