package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;



    public ContatoDTO create(ContatoCreateDTO contatoCreate) throws Exception{
        log.info("chamando o método create");
        pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(contatoCreate.getIdPessoa()))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));

        Contato contato = objectMapper.convertValue(contatoCreate, Contato.class);

        return objectMapper.convertValue(contatoRepository.create(contato), ContatoDTO.class);

    }

    public List<ContatoDTO> list() {
        log.info("chamando o método list");
        return contatoRepository.list()
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizar) throws Exception {
        log.info("chamando o método update");
        pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(contatoAtualizar.getIdPessoa()))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));

        Contato contatoAtualizado = objectMapper.convertValue(contatoAtualizar, Contato.class);

        return objectMapper.convertValue(contatoRepository.update(id, contatoAtualizado), ContatoDTO.class);
    }

    public void delete(Integer id)  throws Exception {
        log.warn("chamando o método delete");
        contatoRepository.delete(id);
    }

    public List<ContatoDTO> listByIdPessoa(Integer idPessoa) {
        log.info("chamando o método listByIdPessoa");
        return contatoRepository.listByIdPessoa(idPessoa)
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

}
