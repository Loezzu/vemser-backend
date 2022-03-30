package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.enums.TipoContato;
import lombok.Data;

@Data
public class ContatoCreateDTO {
    private TipoContato tipoContato;
    private String numero;
    private String descricao;
}
