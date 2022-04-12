package com.dbc.veiculoprodutorconsumidor.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VeiculoDTO {

    private double velocidade;
    private Integer rotacao;
    private boolean sensorFrenagem;
}
