package br.com.fiap.parkingmanagement.enumerator;

import lombok.Getter;

@Getter
public enum UserRoleEnum {
    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER");

    private final String role;

    UserRoleEnum(String role) {
        this.role = role;
    }

}
