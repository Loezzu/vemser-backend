package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;


    public Contato create(Contato contato) throws Exception{
        log.info("chamando o método create");
        pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(contato.getIdPessoa()))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));

        return contatoRepository.create(contato);
    }

    public List<Contato> list() {
        log.info("chamando o método list");
        return contatoRepository.list();
    }

    public Contato update(Integer id, Contato contatoAtualizar) throws Exception {
        log.info("chamando o método update");
        pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(contatoAtualizar.getIdPessoa()))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));

        return contatoRepository.update(id , contatoAtualizar);
    }

    public void delete(Integer id)  throws Exception {
        log.warn("chamando o método delete");
        contatoRepository.delete(id);
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        log.info("chamando o método listByIdPessoa");
        return contatoRepository.listByIdPessoa(idPessoa);
    }

}
