package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
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
        pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(contatoCreate.getIdPessoa()))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));

        Contato contato = objectMapper.convertValue(contatoCreate, Contato.class);

        return objectMapper.convertValue(contatoRepository.save(contato), ContatoDTO.class);

    }

    public List<ContatoDTO> list() {
        log.info("chamando o método list");
        return contatoRepository.findAll()
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizar) throws Exception {
        log.info("chamando o método update");
        pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(contatoAtualizar.getIdPessoa()))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));

        Contato contato = objectMapper.convertValue(contatoAtualizar, Contato.class);

        Contato buscarContato = contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));

        buscarContato.setIdPessoa(contato.getIdPessoa());
        buscarContato.setTipoContato(contato.getTipoContato());
        buscarContato.setNumero(contato.getNumero());
        buscarContato.setDescricao(contato.getDescricao());

        Contato contatoAtualizado = contatoRepository.save(buscarContato);

        return objectMapper.convertValue(contatoRepository.save(contatoAtualizado), ContatoDTO.class);
    }

    public void delete(Integer id)  throws Exception {
        log.warn("chamando o método delete");
        contatoRepository.deleteById(id);
    }

    public List<ContatoDTO> listByIdPessoa(Integer idPessoa) {
        log.info("chamando o método listByIdPessoa");
        return contatoRepository.findById(idPessoa)
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

}
