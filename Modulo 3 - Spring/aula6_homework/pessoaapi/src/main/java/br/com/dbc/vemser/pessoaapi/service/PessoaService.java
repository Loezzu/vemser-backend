package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

//    public PessoaService(){
////        pessoaRepository = new PessoaRepository();
//        Pessoa p = Pessoa.builder()
//                    .cpf("12345678901")
//                    .nome("João")
//                    .build();
//    }

    public PessoaDTO create(PessoaCreateDTO pessoaCreate) throws Exception {
        log.info("chamando o método create");

      Pessoa pessoa = objectMapper.convertValue(pessoaCreate, Pessoa.class);

      Pessoa pessoaCriada = pessoaRepository.create(pessoa);

      PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);

      emailService.sendEmailPessoa(pessoaDTO);

       return pessoaDTO;
    }

    public List<PessoaDTO> list(){
        log.info("chamando o método list");
        return pessoaRepository.list()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }


    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
        log.info("chamando o método update");

        Pessoa pessoa = objectMapper.convertValue(pessoaAtualizar, Pessoa.class);

        Pessoa pessoaAtualizada = pessoaRepository.update(id, pessoa);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaAtualizada, PessoaDTO.class);

        emailService.sendEmailUpdatePessoa(pessoaDTO);

        return pessoaDTO;
    }

    public void delete(Integer id) throws Exception {
        log.warn("chamando o método delete");

        pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class)).ifPresent(pessoaDTO -> {
                    emailService.sendEmailDeletePessoa(pessoaDTO);
                }
        );

        pessoaRepository.delete(id);
    }

    public List<PessoaDTO> listByName(String nome) {
        log.info("chamando o método listByName");
        return pessoaRepository.listByName(nome).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }
}
