package br.com.dbc.vemser.pessoaapi.service;


import br.com.dbc.vemser.pessoaapi.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final ObjectMapper objectMapper;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public LoginDTO create(LoginDTO loginDTO) {
        UsuarioEntity usuario = objectMapper.convertValue(loginDTO, UsuarioEntity.class);
        usuario.setSenha(new BCryptPasswordEncoder().encode(loginDTO.getSenha()));

        return objectMapper.convertValue(usuarioRepository.save(usuario), LoginDTO.class);
    }
}
