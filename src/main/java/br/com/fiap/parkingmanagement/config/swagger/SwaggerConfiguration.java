package br.com.fiap.parkingmanagement.config.swagger;

import java.util.List;

import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfiguration {

    final String securitySchemeName = "bearerAuth";

    @Bean
    public OpenAPI myOpenAPI() {

        Contact contact = new Contact();
        contact.setName("Turma: 2ADJT - Grupo 57");
        contact.setUrl("https://github.com/brunolimadev/parking-management");

        Server localServer = new Server();
        localServer.setUrl("http://localhost:8080/parking-management/api");
        localServer.setDescription("URL do servidor no ambiente LOCAL");

        Info info = new Info()
                .title("Gestão de Estacionamento")
                .contact(contact)
                .version("1.0")
                .description("Tech Challenger (Fase 2) - Solução de Parquímetros (01/2024)");

        return new OpenAPI()
                .info(info)
                .servers(List.of(localServer))
                .addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));

    }
}
