package com.asilo.nido.gestione.asilo.controller;

import com.asilo.nido.gestione.asilo.dto.LoginDTO;
import com.asilo.nido.gestione.asilo.dto.LoginRequest;
import com.asilo.nido.gestione.asilo.dto.RegisterRequest;
import com.asilo.nido.gestione.asilo.entity.User;
import com.asilo.nido.gestione.asilo.mapper.UserMapper;
import com.asilo.nido.gestione.asilo.security.JwtUtil;
import com.asilo.nido.gestione.asilo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, UserMapper userMapper,
                          AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {

        if (userService.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body("Email già registrata");
        }

        User user = userMapper.toEntity(request);
        userService.save(user);

        return ResponseEntity.ok("Registrazione effettuata");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

            User user = userService.getByEmail(request.getEmail());
            String token = jwtUtil.generateToken(user.getEmail());
            LoginDTO dto = userMapper.toLoginDTO(user, token);

            return ResponseEntity.ok(dto);

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Email o password non validi");
        }
    }
}
