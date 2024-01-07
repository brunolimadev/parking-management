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

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException exception) throws IOException, ServletException {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/json;charset=UTF-8");
        ErrorDto errorDto = new ErrorDto(
                "Credenciais inválidas",
                "Suas credenciais são inválidas para acessar este recurso.",
                "403", null);

        PrintWriter writer = response.getWriter();
        writer.write(objectMapper.writeValueAsString(errorDto));
        writer.flush();
    }
}
