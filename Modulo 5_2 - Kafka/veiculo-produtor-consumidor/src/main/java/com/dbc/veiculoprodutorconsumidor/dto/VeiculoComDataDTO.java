package com.dbc.veiculoprodutorconsumidor.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VeiculoComDataDTO {

    private LocalDateTime dataLeitura;
    private double velocidade;
    private Integer rotacao;
    private boolean sensorFrenagem;
}
