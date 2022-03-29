package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/paginacao")
public class PaginacaoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;


    @GetMapping("/findAllOrderByDisc")
    public Page<ContatoEntity> findAllOrderByDisc(Integer paginaSolicitada, Integer tamanhoPagina) {
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoPagina, Sort.by("descricao"));
        Page<ContatoEntity> all = contatoRepository.findAll(pageable);
        return all;
    }

    @GetMapping("/findAllAddressOrderByCep")
    public Page<EnderecoEntity> findAllAddressOrderByCep(Integer paginaSolicitada, Integer tamanhoPagina) {
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoPagina, Sort.by("cep"));
        Page<EnderecoEntity> all = enderecoRepository.findAll(pageable);
        return all;
    }

    @GetMapping("/findAllAddressByPais")
    public Page<EnderecoEntity> findAllAddressOrderByPais(Integer paginaSolicitada, Integer tamanhoPagina, String pais) {
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoPagina);
        Page<EnderecoEntity> all = enderecoRepository.findByPaisPaged(pais.toUpperCase(Locale.ROOT), pageable);
        return all;
    }



}
