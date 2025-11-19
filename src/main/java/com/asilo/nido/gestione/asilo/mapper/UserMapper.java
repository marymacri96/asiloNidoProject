package com.asilo.nido.gestione.asilo.mapper;

import com.asilo.nido.gestione.asilo.dto.LoginDTO;
import com.asilo.nido.gestione.asilo.dto.RegisterRequest;
import com.asilo.nido.gestione.asilo.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // password sarà criptata nel service
        user.setNome(request.getNome());
        user.setCognome(request.getCognome());
        user.setRole("USER"); // ruolo di default
        return user;
    }

    public LoginDTO toLoginDTO(User user, String token) {
        LoginDTO dto = new LoginDTO();
        dto.setToken(token);
        dto.setEmail(user.getEmail());
        dto.setNome(user.getNome());
        dto.setCognome(user.getCognome());
        dto.setRole(user.getRole());
        return dto;
    }
}
