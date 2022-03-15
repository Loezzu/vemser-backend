package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.enums.TipoEndereco;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EnderecoCreateDTO {


    private Integer idPessoa;

    @NotNull
    private TipoEndereco tipoEndereco;

    @NotNull
    @Size(max = 250)
    private String logradouro;

    @NotNull
    @NotEmpty
    private String numero;

    @NotNull
    @Size(max = 8)
    private String cep;

    @NotNull
    @NotEmpty
    @Size(max = 250)
    private String cidade;

    @NotNull
    private String estado;

    @NotNull
    private String pais;
}
