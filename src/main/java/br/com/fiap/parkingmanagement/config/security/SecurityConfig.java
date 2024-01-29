package br.com.fiap.parkingmanagement.config.security;

import br.com.fiap.parkingmanagement.controller.exception.CustomAuthenticationFailureHandler;
import br.com.fiap.parkingmanagement.filter.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private final SecurityFilter securityFilter;

    public SecurityConfig(SecurityFilter securityFilter) {
        this.securityFilter = securityFilter;
    }

    /**
     * Método responsável por criar o SecurityFilterChain
     *
     * @param httpSecurity
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                /* A configuração CSRF (Cross-Site Request Forgery) no Spring Security é
                uma medida de segurança que protege contra ataques de falsificação de solicitação entre sites.
                Iremos desabilitar pois iremos trabalhar com JWT.
                */.csrf(AbstractHttpConfigurer::disable)

                /* SessionCreationPolicy.STATELESS => Não iremos manter a sessão do usuário na aplicação */
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).authorizeHttpRequests(authorize -> authorize

                /* Regra para extrair relatório de veículos com situação irregular */
                .requestMatchers(HttpMethod.GET, "/reports").hasRole("ADMIN")

                // Regra para a criação de usuários
                .requestMatchers(HttpMethod.POST, "/users").permitAll()

                // Regra para a realizar o login
                .requestMatchers(HttpMethod.POST, "/auth/signin").permitAll()

                // Regra para a realizar o logout
                .requestMatchers(HttpMethod.POST, "/auth/logout").permitAll()

                // Regra para a permitir o acesso ao swagger
                .requestMatchers(HttpMethod.GET, "/swagger-ui/**", "/v3/api-docs/**").permitAll()

                // Demais requisições serão permitidas
                .anyRequest().authenticated())

                // Realiza verificação do jwt antes das requisições
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)

                // Configura o tratamento de exceções para acesso não autorizado
                .exceptionHandling(exception -> exception.authenticationEntryPoint(new CustomAuthenticationFailureHandler()::onAuthenticationFailure))
                .build();
    }

    /**
     * Método responsável por criar o AuthenticationManager
     *
     * @param userDetailsService
     * @param passwordEncoder
     * @return
     */
    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(authenticationProvider);
    }

    /**
     * Método responsável por criar o PasswordEncoder
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
