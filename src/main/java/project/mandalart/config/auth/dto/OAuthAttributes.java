package project.mandalart.config.auth.dto;

import lombok.Builder;
import lombok.Getter;
import project.mandalart.domain.user.Role;
import project.mandalart.domain.user.User;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attriutes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attriutes,
                           String nameAttributeKey, String name,
                           String email, String picture) {
        this.attriutes = attriutes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attriutes) {
        return ofGoogle(userNameAttributeName, attriutes);
    }

    private static OAuthAttributes ofGoogle(String
                                            userNameAttriuteName, Map<String,
                                            Object> attriutes) {
        return OAuthAttributes.builder()
                .name((String) attriutes.get("name"))
                .email((String) attriutes.get("email"))
                .picture((String) attriutes.get("picture"))
                .attriutes(attriutes)
                .nameAttributeKey(userNameAttriuteName)
                .build();
    }

    public User toEntity() {
        return  User.builder()
                    .name(name)
                    .email(email)
                    .picture(picture)
                    .role(Role.GUEST)
                    .build();
    }
}
