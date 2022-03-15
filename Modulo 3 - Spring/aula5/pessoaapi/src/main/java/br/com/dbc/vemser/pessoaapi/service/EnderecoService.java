package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Endereco create(Endereco endereco, Integer idPessoa) throws Exception {
        log.info("chamando o método create");
        pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(endereco.getIdPessoa()))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));

        return enderecoRepository.create(endereco, idPessoa);
    }

    public List<Endereco> list() {
        log.info("chamando o método list");
        return enderecoRepository.list();
    }

    public Endereco update(Integer id, Endereco enderecoAtualizar) throws Exception {
        log.info("chamando o método update");
        pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(enderecoAtualizar.getIdPessoa()))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));

        return enderecoRepository.update(id, enderecoAtualizar);
    }

    public void delete(Integer id) throws Exception {
        log.warn("chamando o método delete");
        enderecoRepository.delete(id);
    }

    public List<Endereco> listByIdEndereco(Integer idEndereco) {
        log.info("chamando o método listByIdEndereco");
        return enderecoRepository.listByIdEndereco(idEndereco);
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        log.info("chamando o método listByIdPessoa");
        return enderecoRepository.listByIdPessoa(idPessoa);
    }

}
