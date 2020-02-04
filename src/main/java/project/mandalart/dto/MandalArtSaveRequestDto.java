package project.mandalart.dto;


import lombok.Getter;
import lombok.Setter;
import project.mandalart.domain.mandalart.MandalArt;

@Getter
@Setter
public class MandalArtSaveRequestDto extends MandalArt {
    private Long id;
    private String routeId;
    private boolean banned;
    private String item11;
    private String item12;
    private String item13;
    private String item14;
    private String item16;
    private String item17;
    private String item18;
    private String item19;
    private String item21;
    private String item22;
    private String item23;
    private String item24;
    private String item26;
    private String item27;
    private String item28;
    private String item29;
    private String item31;
    private String item32;
    private String item33;
    private String item34;
    private String item36;
    private String item37;
    private String item38;
    private String item39;
    private String item41;
    private String item42;
    private String item43;
    private String item44;
    private String item46;
    private String item47;
    private String item48;
    private String item49;
    private String item51;
    private String item52;
    private String item53;
    private String item54;
    private String item55 = null;
    private String item56;
    private String item57;
    private String item58;
    private String item59;
    private String item61;
    private String item62;
    private String item63;
    private String item64;
    private String item66;
    private String item67;
    private String item68;
    private String item69;
    private String item71;
    private String item72;
    private String item73;
    private String item74;
    private String item76;
    private String item77;
    private String item78;
    private String item79;
    private String item81;
    private String item82;
    private String item83;
    private String item84;
    private String item86;
    private String item87;
    private String item88;
    private String item89;
    private String item91;
    private String item92;
    private String item93;
    private String item94;
    private String item96;
    private String item97;
    private String item98;
    private String item99;

    public MandalArt toEntity() {
        return MandalArt.builder()
                .routeId(routeId)
                .item11(item11)
                .item12(item12)
                .item13(item13)
                .item14(item14)
                .item16(item16)
                .item17(item17)
                .item18(item18)
                .item19(item19)
                .item21(item21)
                .item22(item22)
                .item23(item23)
                .item24(item24)
                .item26(item26)
                .item27(item27)
                .item28(item28)
                .item29(item29)
                .item31(item31)
                .item32(item32)
                .item33(item33)
                .item34(item34)
                .item36(item36)
                .item37(item37)
                .item38(item38)
                .item39(item39)
                .item41(item41)
                .item42(item42)
                .item43(item43)
                .item44(item44)
                .item46(item46)
                .item47(item47)
                .item48(item48)
                .item49(item49)
                .item51(item51)
                .item52(item52)
                .item53(item53)
                .item54(item54)
                .item55(item55)
                .item56(item56)
                .item57(item57)
                .item58(item58)
                .item59(item59)
                .item61(item61)
                .item62(item62)
                .item63(item63)
                .item64(item64)
                .item66(item66)
                .item67(item67)
                .item68(item68)
                .item69(item69)
                .item71(item71)
                .item72(item72)
                .item73(item73)
                .item74(item74)
                .item76(item76)
                .item77(item77)
                .item78(item78)
                .item79(item79)
                .item81(item81)
                .item82(item82)
                .item83(item83)
                .item84(item84)
                .item86(item86)
                .item87(item87)
                .item88(item88)
                .item89(item89)
                .item91(item91)
                .item92(item92)
                .item93(item93)
                .item94(item94)
                .item96(item96)
                .item97(item97)
                .item98(item98)
                .item99(item99)
                .build();
    }
}
