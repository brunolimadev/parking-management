package br.com.fiap.parkingmanagement.model.entity;

import br.com.fiap.parkingmanagement.enumerator.UserRoleEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Document
@Data
public class User implements UserDetails {

    @Id
    private String id;

    private String name;

    private String email;

    private String password;

    private boolean isActive;

    private LocalDateTime createdAt;

    private UserRoleEnum role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if (this.role == UserRoleEnum.ROLE_ADMIN) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        } else {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        }
    }

    /**
     * Método responsável por retornar o username do usuário
     *
     * @return
     */
    @Override
    public String getUsername() {
        return this.email;
    }

    /**
     * Método responsável por retornar se a conta do usuário está expirada
     *
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Método responsável por retornar se a conta do usuário está bloqueada
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return this.isActive;
    }

    /**
     * Método responsável por retornar se as credenciais do usuário estão expiradas
     *
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Método responsável por retornar se o usuário está habilitado
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return this.isActive;
    }
}
