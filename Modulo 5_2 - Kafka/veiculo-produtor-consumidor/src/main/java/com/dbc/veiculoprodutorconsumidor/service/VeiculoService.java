package com.dbc.veiculoprodutorconsumidor.service;

import com.dbc.veiculoprodutorconsumidor.VeiculoRepository;
import com.dbc.veiculoprodutorconsumidor.dto.VeiculoComDataDTO;
import com.dbc.veiculoprodutorconsumidor.dto.VeiculoDTO;
import com.dbc.veiculoprodutorconsumidor.entity.VeiculoEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ObjectMapper objectMapper;

    public VeiculoDTO save(VeiculoDTO veiculoDTO) {
        VeiculoEntity veiculoEntity = objectMapper.convertValue(veiculoDTO, VeiculoEntity.class);
        veiculoEntity.setDataLeitura(LocalDateTime.now());
        veiculoEntity = veiculoRepository.save(veiculoEntity);
        return objectMapper.convertValue(veiculoEntity, VeiculoDTO.class);
    }

    public List<VeiculoComDataDTO> listAll() {
        return veiculoRepository.findAll().stream().map(veiculo -> objectMapper.convertValue(veiculo, VeiculoComDataDTO.class)).collect(Collectors.toList());
    }

    public Long count() {
        return veiculoRepository.count();
    }

    public Double averageSpeed() {
        double velocidade = veiculoRepository.findVelocidadeTotal();
        long qtdVeiculos = veiculoRepository.count();
        return velocidade / qtdVeiculos;
    }

    public Double averageRotacao() {
        double rotacao = veiculoRepository.findRotacaoTotal();
        long qtdVeiculos = veiculoRepository.count();
        return rotacao / qtdVeiculos;
    }



}
