package br.com.fiap.parkingmanagement.controller;


import br.com.fiap.parkingmanagement.model.dto.AuthDto;
import br.com.fiap.parkingmanagement.model.dto.SignResponseDto;
import br.com.fiap.parkingmanagement.model.entity.User;
import br.com.fiap.parkingmanagement.service.AuthService;
import br.com.fiap.parkingmanagement.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@Valid @RequestBody AuthDto credentials) throws Exception {

        var userCredentials = new UsernamePasswordAuthenticationToken(credentials.email(), credentials.password());

        var authentication = authenticationManager.authenticate(userCredentials);

        var jwt = jwtService.generateToken((User) authentication.getPrincipal());

        HttpHeaders hearders = new HttpHeaders();

        hearders.add(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);

        SignResponseDto response = new SignResponseDto(true, userCredentials.getName());

        return ResponseEntity.ok().headers(hearders).body(response);
    }
}
