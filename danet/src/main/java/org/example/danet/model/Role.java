package org.example.danet.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Getter
@RequiredArgsConstructor
public enum Role implements GrantedAuthority {

    ROLE_USER("Пользователь"),
    ROLE_ADMIN("Администратор");

    private final String name;

    @Override
    public String getAuthority() {
        return name();
    }

}
