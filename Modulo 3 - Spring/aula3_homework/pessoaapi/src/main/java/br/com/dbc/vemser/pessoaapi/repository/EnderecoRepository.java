package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    private static List<Endereco> listaEndereco = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();


    public EnderecoRepository() {
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet(), 1, "Rua 1", "Bairro 1", "Cidade 1", "Estado 1", "RS"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet(), 2, "Rua 2", "Bairro 2", "Cidade 2", "Estado 2", "SC"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet(), 3, "Rua 3", "Bairro 3", "Cidade 3", "Estado 3", "RJ"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet(), 4, "Rua 4", "Bairro 4", "Cidade 4", "Estado 4", "SP"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet(), 5, "Rua 5", "Bairro 5", "Cidade 5", "Estado 5", "PR"));
    }

    public Endereco create(Endereco endereco, Integer idPessoa) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        endereco.setIdPessoa(idPessoa);
        listaEndereco.add(endereco);
        return endereco;
    }

    public List<Endereco> list() {
        return listaEndereco;
    }

    public Endereco update(Integer id,
                         Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = listaEndereco.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereco não econtrado"));
        enderecoRecuperado.setIdPessoa(enderecoAtualizar.getIdPessoa());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setBairro(enderecoAtualizar.getBairro());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        return enderecoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Endereco enderecoRecuperado = listaEndereco.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereco não encontrado"));
        listaEndereco.remove(enderecoRecuperado);
    }

    public List<Endereco> listByIdEndereco(Integer idEndereco) {
        return listaEndereco.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .collect(Collectors.toList());
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        Pessoa pessoa = new Pessoa();
        pessoa.setIdPessoa(idPessoa);
        return listaEndereco.stream()
                .filter(endereco -> endereco.getIdPessoa().equals(pessoa.getIdPessoa()))
                .collect(Collectors.toList());
    }



}
