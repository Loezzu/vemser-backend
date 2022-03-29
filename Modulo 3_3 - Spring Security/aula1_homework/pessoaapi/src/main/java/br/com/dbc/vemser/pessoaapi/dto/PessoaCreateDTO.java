package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {

    @ApiModelProperty(example = "João da Silva", required = true)
    @NotBlank
    @NotEmpty
    private String nome;

    @Past
    @NotNull
    private LocalDate dataNascimento;

    @NotEmpty
    @NotBlank
    @Size(min=11, max=11)
    private String cpf;

    @Email
    private String email;
}
