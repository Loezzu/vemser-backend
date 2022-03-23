package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private EmailService emailService;


    public EnderecoDTO create(EnderecoCreateDTO enderecoCreate, Integer idPessoa) throws Exception {
        log.info("chamando o método create");

        PessoaEntity pessoaEntity = pessoaService.findById(idPessoa);

        EnderecoEntity endereco = objectMapper.convertValue(enderecoCreate, EnderecoEntity.class);

        endereco.setPessoas(new HashSet<>());
        endereco.getPessoas().add(pessoaEntity);

        EnderecoEntity enderecoCriado = enderecoRepository.save(endereco);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);

//
//        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaRepository.listByIdPessoa(idPessoa), PessoaDTO.class);
//
//        emailService.sendEmailEndereco(pessoaDTO, enderecoDTO);

        return enderecoDTO;

    }

    public List<EnderecoDTO> list() {
        log.info("chamando o método list");
        return enderecoRepository.findAll()
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoAtualizar) throws Exception {
        log.info("chamando o método update");

        EnderecoEntity endereco = objectMapper.convertValue(enderecoAtualizar, EnderecoEntity.class);

        EnderecoEntity atualizarEndereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));

        atualizarEndereco.setTipoEndereco(endereco.getTipoEndereco());
        atualizarEndereco.setLogradouro(endereco.getLogradouro());
        atualizarEndereco.setNumero(endereco.getNumero());
        atualizarEndereco.setComplemento(endereco.getComplemento());
        atualizarEndereco.setCidade(endereco.getCidade());
        atualizarEndereco.setEstado(endereco.getEstado());
        atualizarEndereco.setCep(endereco.getCep());
        atualizarEndereco.setPais(endereco.getPais());


        EnderecoEntity enderecoAtualizado = enderecoRepository.save(atualizarEndereco);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoAtualizado, EnderecoDTO.class);

//        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaRepository.listByIdPessoa(id), PessoaDTO.class);
//
//        emailService.sendEmailUpdateEndereco(pessoaDTO, enderecoDTO);

        return  enderecoDTO;
    }

    public void delete(Integer id) throws Exception {
        log.warn("chamando o método delete");

//        EnderecoDTO enderecoDTO = new EnderecoDTO();
//        enderecoDTO.setIdEndereco(id);

//        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaRepository.listByIdPessoa(id), PessoaDTO.class);
//
//        emailService.sendEmailDeleteEndereco(pessoaDTO, enderecoDTO);

        enderecoRepository.deleteById(id);
    }

//    public List<EnderecoDTO> listByIdEndereco(Integer idEndereco) {
//        log.info("chamando o método listByIdEndereco");
//        return enderecoRepository.listByIdEndereco(idEndereco)
//                .stream()
//                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
//                .collect(Collectors.toList());
//    }
//
//    public List<EnderecoDTO> listByIdPessoa(Integer idPessoa) {
//        log.info("chamando o método listByIdPessoa");
//        return enderecoRepository.listByIdPessoa(idPessoa)
//                .stream()
//                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
//                .collect(Collectors.toList());
//    }

}
