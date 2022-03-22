package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

      PessoaEntity pessoa = objectMapper.convertValue(pessoaCreate, PessoaEntity.class);

      PessoaEntity pessoaCriada = pessoaRepository.save(pessoa);

      PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);

//      emailService.sendEmailPessoa(pessoaDTO);

       return pessoaDTO;
    }

    public List<PessoaDTO> list(){
        log.info("chamando o método list");
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }


    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
        log.info("chamando o método update");

        PessoaEntity pessoa = objectMapper.convertValue(pessoaAtualizar, PessoaEntity.class);

        PessoaEntity atualizarPessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new Exception("Pessoa não encontrada"));
        atualizarPessoa.setNome(pessoa.getNome());
        atualizarPessoa.setCpf(pessoa.getCpf());
        atualizarPessoa.setDataNascimento(pessoa.getDataNascimento());
        atualizarPessoa.setEmail(pessoa.getEmail());

        PessoaEntity pessoaAtualizada = pessoaRepository.save(atualizarPessoa);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaAtualizada, PessoaDTO.class);

//        emailService.sendEmailUpdatePessoa(pessoaDTO);

        return pessoaDTO;
    }

    public void delete(Integer id) throws Exception {
        log.warn("chamando o método delete");
        pessoaRepository.deleteById(id);
    }


    public List<PessoaDTOComContatos> listarPessoasComContatos(Integer idPessoa) throws Exception {
        List<PessoaDTOComContatos> pessoasDTOList = new ArrayList<>();
        if (idPessoa == null) {
            pessoasDTOList.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOComContatos pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTOComContatos.class);
                        pessoaDTO.setContatos(pessoa.getContatos().stream()
                                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                                .collect(Collectors.toList())
                        );
                        return pessoaDTO;
                    }).toList()
            );
        } else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
            PessoaDTOComContatos pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComContatos.class);
            pessoaDTO.setContatos(pessoaEntity.getContatos().stream()
                    .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                    .collect(Collectors.toList())
            );
            pessoasDTOList.add(pessoaDTO);
        }
        return pessoasDTOList;
    }

    public List<PessoaDTOComEnderecos> listarPessoasComEnderecos(Integer idPessoa) throws Exception {
        List<PessoaDTOComEnderecos> pessoasDTOList = new ArrayList<>();
        if (idPessoa == null) {
            pessoasDTOList.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOComEnderecos pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTOComEnderecos.class);
                        pessoaDTO.setEnderecos(pessoa.getEnderecos().stream()
                                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                                .collect(Collectors.toList())
                        );
                        return pessoaDTO;
                    }).toList()
            );
        } else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
            PessoaDTOComEnderecos pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComEnderecos.class);
            pessoaDTO.setEnderecos(pessoaEntity.getEnderecos().stream()
                    .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                    .collect(Collectors.toList())
            );
            pessoasDTOList.add(pessoaDTO);
        }
        return pessoasDTOList;
    }
}
