package br.com.dbc.vemser.pessoaapi.service;


import br.com.dbc.vemser.pessoaapi.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.entity.GrupoEntity;
import br.com.dbc.vemser.pessoaapi.entity.RegraEntity;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.GrupoRepository;
import br.com.dbc.vemser.pessoaapi.repository.RegraRepository;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final ObjectMapper objectMapper;

    private final GrupoRepository grupoRepository;

    private final RegraRepository regraRepository;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public LoginDTO create(LoginDTO loginDTO, List<Integer> idGrupo) throws Exception {

        Set<GrupoEntity> hashSet = new HashSet<>();

        for (Integer i : idGrupo) {
            hashSet.add(grupoRepository.findById(i).orElseThrow(() -> new RegraDeNegocioException("Grupo não encontrado")));
        }

        UsuarioEntity usuario = objectMapper.convertValue(loginDTO, UsuarioEntity.class);

        usuario.setGrupos(hashSet);

        usuario.setSenha(new BCryptPasswordEncoder().encode(loginDTO.getSenha()));

        UsuarioEntity usuarioCriado = usuarioRepository.save(usuario);



        return objectMapper.convertValue(usuarioCriado, LoginDTO.class);
    }
}
