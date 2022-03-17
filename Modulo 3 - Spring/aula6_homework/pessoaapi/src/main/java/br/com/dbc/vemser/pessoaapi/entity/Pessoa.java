package br.com.dbc.vemser.pessoaapi.entity;


import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Pessoa {

  private Integer idPessoa;

  @NotBlank
  @NotEmpty
  private String nome;

  @Past
  @NotNull
  private LocalDate  dataNascimento;

  @NotEmpty
  @NotBlank
  @Size(min=11, max=11)
  private String cpf;

  @Email
  private String email;

}

