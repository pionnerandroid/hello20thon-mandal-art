package project.mandalart.domain.mandalart;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.mandalart.domain.BaseTimeEntity;
import project.mandalart.dto.MandalArtSaveRequestDto;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Table
@Entity
public class MandalArt extends BaseTimeEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "tinyint default 0")
    boolean banned = false;

    @Column
    private String routeId;

    @Column(length = 60)
    private String item11;

    @Column(length = 60)
    private String item12;

    @Column(length = 60)
    private String item13;

    @Column(length = 60)
    private String item14;

    @Column(length = 60)
    private String item16;

    @Column(length = 60)
    private String item17;

    @Column(length = 60)
    private String item18;

    @Column(length = 60)
    private String item19;

    @Column(length = 60)
    private String item21;

    @Column(length = 60)
    private String item22;

    @Column(length = 60)
    private String item23;

    @Column(length = 60)
    private String item24;

    @Column(length = 60)
    private String item26;

    @Column(length = 60)
    private String item27;

    @Column(length = 60)
    private String item28;

    @Column(length = 60)
    private String item29;

    @Column(length = 60)
    private String item31;

    @Column(length = 60)
    private String item32;

    @Column(length = 60)
    private String item33;

    @Column(length = 60)
    private String item34;

    @Column(length = 60)
    private String item36;

    @Column(length = 60)
    private String item37;

    @Column(length = 60)
    private String item38;

    @Column(length = 60)
    private String item39;

    @Column(length = 60)
    private String item41;

    @Column(length = 60)
    private String item42;

    @Column(length = 60)
    private String item43;

    @Column(length = 60)
    private String item44;

    @Column(length = 60)
    private String item46;

    @Column(length = 60)
    private String item47;

    @Column(length = 60)
    private String item48;

    @Column(length = 60)
    private String item49;

    @Column(length = 60)
    private String item51;

    @Column(length = 60)
    private String item52;

    @Column(length = 60)
    private String item53;

    @Column(length = 60)
    private String item54;

    @Column(length = 60)
    private String item55;

    @Column(length = 60)
    private String item56;

    @Column(length = 60)
    private String item57;

    @Column(length = 60)
    private String item58;

    @Column(length = 60)
    private String item59;

    @Column(length = 60)
    private String item61;

    @Column(length = 60)
    private String item62;

    @Column(length = 60)
    private String item63;

    @Column(length = 60)
    private String item64;

    @Column(length = 60)
    private String item66;

    @Column(length = 60)
    private String item67;

    @Column(length = 60)
    private String item68;

    @Column(length = 60)
    private String item69;

    @Column(length = 60)
    private String item71;

    @Column(length = 60)
    private String item72;

    @Column(length = 60)
    private String item73;

    @Column(length = 60)
    private String item74;

    @Column(length = 60)
    private String item76;

    @Column(length = 60)
    private String item77;

    @Column(length = 60)
    private String item78;

    @Column(length = 60)
    private String item79;

    @Column(length = 60)
    private String item81;

    @Column(length = 60)
    private String item82;

    @Column(length = 60)
    private String item83;

    @Column(length = 60)
    private String item84;

    @Column(length = 60)
    private String item86;

    @Column(length = 60)
    private String item87;

    @Column(length = 60)
    private String item88;

    @Column(length = 60)
    private String item89;

    @Column(length = 60)
    private String item91;

    @Column(length = 60)
    private String item92;

    @Column(length = 60)
    private String item93;

    @Column(length = 60)
    private String item94;

    @Column(length = 60)
    private String item96;

    @Column(length = 60)
    private String item97;

    @Column(length = 60)
    private String item98;

    @Column(length = 60)
    private String item99;

    @Builder
    public MandalArt(String routeId, String item11, String item12, String item13, String item14, String item16, String item17, String item18, String item19, String item21, String item22, String item23, String item24, String item26, String item27, String item28, String item29, String item31, String item32, String item33, String item34, String item36, String item37, String item38, String item39, String item41, String item42, String item43, String item44, String item46, String item47, String item48, String item49, String item51, String item52, String item53, String item54, String item55, String item56, String item57, String item58, String item59, String item61, String item62, String item63, String item64, String item66, String item67, String item68, String item69, String item71, String item72, String item73, String item74, String item76, String item77, String item78, String item79, String item81, String item82, String item83, String item84, String item86, String item87, String item88, String item89, String item91, String item92, String item93, String item94, String item96, String item97, String item98, String item99) {
        this.routeId = routeId;
        this.item11 = item11;
        this.item12 = item12;
        this.item13 = item13;
        this.item14 = item14;
        this.item16 = item16;
        this.item17 = item17;
        this.item18 = item18;
        this.item19 = item19;
        this.item21 = item21;
        this.item22 = item22;
        this.item23 = item23;
        this.item24 = item24;
        this.item26 = item26;
        this.item27 = item27;
        this.item28 = item28;
        this.item29 = item29;
        this.item31 = item31;
        this.item32 = item32;
        this.item33 = item33;
        this.item34 = item34;
        this.item36 = item36;
        this.item37 = item37;
        this.item38 = item38;
        this.item39 = item39;
        this.item41 = item41;
        this.item42 = item42;
        this.item43 = item43;
        this.item44 = item44;
        this.item46 = item46;
        this.item47 = item47;
        this.item48 = item48;
        this.item49 = item49;
        this.item51 = item51;
        this.item52 = item52;
        this.item53 = item53;
        this.item54 = item54;
        this.item55 = item55;
        this.item56 = item56;
        this.item57 = item57;
        this.item58 = item58;
        this.item59 = item59;
        this.item61 = item61;
        this.item62 = item62;
        this.item63 = item63;
        this.item64 = item64;
        this.item66 = item66;
        this.item67 = item67;
        this.item68 = item68;
        this.item69 = item69;
        this.item71 = item71;
        this.item72 = item72;
        this.item73 = item73;
        this.item74 = item74;
        this.item76 = item76;
        this.item77 = item77;
        this.item78 = item78;
        this.item79 = item79;
        this.item81 = item81;
        this.item82 = item82;
        this.item83 = item83;
        this.item84 = item84;
        this.item86 = item86;
        this.item87 = item87;
        this.item88 = item88;
        this.item89 = item89;
        this.item91 = item91;
        this.item92 = item92;
        this.item93 = item93;
        this.item94 = item94;
        this.item96 = item96;
        this.item97 = item97;
        this.item98 = item98;
        this.item99 = item99;
    }

    public void update(MandalArtSaveRequestDto requestDto) {
        this.item11 = requestDto.getItem11();
        this.item12 = requestDto.getItem12();
        this.item13 = requestDto.getItem13();
        this.item14 = requestDto.getItem14();
        this.item16 = requestDto.getItem16();
        this.item17 = requestDto.getItem17();
        this.item18 = requestDto.getItem18();
        this.item19 = requestDto.getItem19();
        this.item21 = requestDto.getItem21();
        this.item22 = requestDto.getItem22();
        this.item23 = requestDto.getItem23();
        this.item24 = requestDto.getItem24();
        this.item26 = requestDto.getItem26();
        this.item27 = requestDto.getItem27();
        this.item28 = requestDto.getItem28();
        this.item29 = requestDto.getItem29();
        this.item31 = requestDto.getItem31();
        this.item32 = requestDto.getItem32();
        this.item33 = requestDto.getItem33();
        this.item34 = requestDto.getItem34();
        this.item36 = requestDto.getItem36();
        this.item37 = requestDto.getItem37();
        this.item38 = requestDto.getItem38();
        this.item39 = requestDto.getItem39();
        this.item41 = requestDto.getItem41();
        this.item42 = requestDto.getItem42();
        this.item43 = requestDto.getItem43();
        this.item44 = requestDto.getItem44();
        this.item46 = requestDto.getItem46();
        this.item47 = requestDto.getItem47();
        this.item48 = requestDto.getItem48();
        this.item49 = requestDto.getItem49();
        this.item51 = requestDto.getItem51();
        this.item52 = requestDto.getItem52();
        this.item53 = requestDto.getItem53();
        this.item54 = requestDto.getItem54();
        this.item55 = requestDto.getItem55();
        this.item56 = requestDto.getItem56();
        this.item57 = requestDto.getItem57();
        this.item58 = requestDto.getItem58();
        this.item59 = requestDto.getItem59();
        this.item61 = requestDto.getItem61();
        this.item62 = requestDto.getItem62();
        this.item63 = requestDto.getItem63();
        this.item64 = requestDto.getItem64();
        this.item66 = requestDto.getItem66();
        this.item67 = requestDto.getItem67();
        this.item68 = requestDto.getItem68();
        this.item69 = requestDto.getItem69();
        this.item71 = requestDto.getItem71();
        this.item72 = requestDto.getItem72();
        this.item73 = requestDto.getItem73();
        this.item74 = requestDto.getItem74();
        this.item76 = requestDto.getItem76();
        this.item77 = requestDto.getItem77();
        this.item78 = requestDto.getItem78();
        this.item79 = requestDto.getItem79();
        this.item81 = requestDto.getItem81();
        this.item82 = requestDto.getItem82();
        this.item83 = requestDto.getItem83();
        this.item84 = requestDto.getItem84();
        this.item86 = requestDto.getItem86();
        this.item87 = requestDto.getItem87();
        this.item88 = requestDto.getItem88();
        this.item89 = requestDto.getItem89();
        this.item91 = requestDto.getItem91();
        this.item92 = requestDto.getItem92();
        this.item93 = requestDto.getItem93();
        this.item94 = requestDto.getItem94();
        this.item96 = requestDto.getItem96();
        this.item97 = requestDto.getItem97();
        this.item98 = requestDto.getItem98();
        this.item99 = requestDto.getItem99();
    }
}
