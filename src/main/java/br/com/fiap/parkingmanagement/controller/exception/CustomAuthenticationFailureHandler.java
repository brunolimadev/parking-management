package br.com.fiap.parkingmanagement.controller.exception;

import br.com.fiap.parkingmanagement.model.dto.ErrorDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;
import java.io.PrintWriter;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Método responsável por tratar a exceção de autenticação.
     *
     * @param request   requisição.
     * @param response  resposta.
     * @param exception exceção lançada
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException exception) throws IOException, ServletException {

        // Definição do status code da resposta 403 - Forbidden
        response.setStatus(HttpStatus.FORBIDDEN.value());

        // Definição do tipo de conteúdo da resposta
        response.setContentType("application/json;charset=UTF-8");

        // Definição do tipo de conteúdo da resposta
        ErrorDto errorDto = new ErrorDto(
                "Credenciais inválidas",
                "Suas credenciais são inválidas para acessar este recurso.",
                "403", null);


        // Escrita do JSON de resposta
        PrintWriter writer = response.getWriter();
        writer.write(objectMapper.writeValueAsString(errorDto));
        writer.flush();
    }
}
