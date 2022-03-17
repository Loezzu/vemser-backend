package br.com.dbc.vemser.pessoaapi.entity;

import br.com.dbc.vemser.pessoaapi.enums.TipoEndereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Endereco {

    private Integer idEndereco;
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
