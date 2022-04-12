package com.dbc.veiculoprodutorconsumidor.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "sensor-veiculo")
@Getter
@Setter
public class VeiculoEntity {

    @Id
    private String id;
    private LocalDateTime dataLeitura;
    private double velocidade;
    private Integer rotacao;
    private boolean sensorFrenagem;
}
