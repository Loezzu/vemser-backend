package br.com.dbc.vemser.pessoaapi.security;

import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {
    private static final String CARACTER_SEPARACAO = ";";
    private final UsuarioService usuarioService;

    public String getToken(UsuarioEntity usuarioEntity){
        String tokenTexto = usuarioEntity.getLogin() + CARACTER_SEPARACAO + usuarioEntity.getSenha(); // luiz;123
        String token = Base64.getEncoder().encodeToString(tokenTexto.getBytes()); //
        return token;
    }

    public Optional<UsuarioEntity> isValid(String token){
        if(token == null){
            return Optional.empty();
        }
        byte[] decodedTokenBytes = Base64.getUrlDecoder().decode(token); // bWFpY29uOzEyMw==
        String decodedTokenString = new String(decodedTokenBytes); //luiz;123
        String[] usuarioESenha = decodedTokenString.split(CARACTER_SEPARACAO);/// ['luiz', '123']
        return usuarioService.findByLoginAndSenha(usuarioESenha[0] /*luiz*/, usuarioESenha[1] /*123*/);
    }
}
