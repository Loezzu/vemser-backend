package com.dbc.veiculoprodutorconsumidor.controller;

import com.dbc.veiculoprodutorconsumidor.dto.VeiculoComDataDTO;
import com.dbc.veiculoprodutorconsumidor.dto.VeiculoDTO;
import com.dbc.veiculoprodutorconsumidor.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer")
@RequiredArgsConstructor
public class ConsumerController {

    private final VeiculoService veiculoService;

    @GetMapping("/veiculos")
    public List<VeiculoComDataDTO> listAll() {
        return veiculoService.listAll();
    }

    @GetMapping("/veiculos/quantidade-de-veiculos")
    public Long quantidadeVeiculos() {
        return veiculoService.count();
    }

    @GetMapping("/veiculos/media-de-velocidade")
    public Double mediaVelocidade() {
        return veiculoService.averageSpeed();
    }

    @GetMapping("/veiculos/media-de-rotacao")
    public Double mediaRotacao() {
        return veiculoService.averageRotacao();
    }

}
