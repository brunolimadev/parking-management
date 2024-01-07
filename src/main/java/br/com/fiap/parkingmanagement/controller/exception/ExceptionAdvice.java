package br.com.fiap.parkingmanagement.controller.exception;

import br.com.fiap.parkingmanagement.model.dto.ErrorDto;
import br.com.fiap.parkingmanagement.model.dto.ErrorFieldDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorDto> handleValidationException(MethodArgumentNotValidException ex) {

        List<ErrorFieldDto> errorFields = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorFields.add(new ErrorFieldDto(error.getField(), error.getDefaultMessage()));
        });


        ErrorDto errorDto = new ErrorDto(
                "Dados inválidos",
                "Por favor, verifique os dados enviados e tente novamente.",
                "400",
                errorFields);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    @ExceptionHandler({NoResourceFoundException.class})
    public ResponseEntity<ErrorDto> handleNotFoundException(NoResourceFoundException ex) {

        ErrorDto errorDto = new ErrorDto(
                "Erro interno",
                "Recurso não encontrado.",
                "400", null);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<ErrorDto> handleAccessDenyException(AccessDeniedException ex) {

        ErrorDto errorDto = new ErrorDto(
                "Credenciais inválidas",
                "Suas credenciais são inválidas para acessar este recurso.",
                "403", null);

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorDto);
    }

    @ExceptionHandler({VehicleException.class})
    public ResponseEntity<ErrorDto> handleVehicleAlredyExistsException(VehicleException ex) {

        ErrorDto errorDto = new ErrorDto(
                ex.getTitle(),
                ex.getMessage(),
                "404", null);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

}
