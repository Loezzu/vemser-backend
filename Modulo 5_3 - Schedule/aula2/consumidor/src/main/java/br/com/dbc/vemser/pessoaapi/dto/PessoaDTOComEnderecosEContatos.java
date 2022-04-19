package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class PessoaDTOComEnderecosEContatos extends PessoaCreateDTO {
    private Integer idPessoa;
    private List<EnderecoDTO> enderecos;
    private List<ContatoDTO> contatos;
}
