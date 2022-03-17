package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.enums.TipoEndereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
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
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet(), 1, TipoEndereco.CASA, "Rua 1", "100", "1234567", "Cidade 1", "RS", "Brasil"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet(), 2, TipoEndereco.CASA, "Rua 2", "200", "1234567", "Cidade 2", "SC", "Brasil"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet(), 3, TipoEndereco.CASA, "Rua 3", "300", "1234567", "Cidade 3", "RJ", "Brasil"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet(), 4, TipoEndereco.CASA, "Rua 4", "400", "1234567", "Cidade 4", "SP", "Brasil"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet(), 5, TipoEndereco.CASA, "Rua 5", "500", "1234567", "Cidade 5", "PR", "Brasil"));
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
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não econtrado"));
        enderecoRecuperado.setIdPessoa(enderecoAtualizar.getIdPessoa());
        enderecoRecuperado.setTipoEndereco(enderecoAtualizar.getTipoEndereco());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());
        return enderecoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Endereco enderecoRecuperado = listaEndereco.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não encontrado"));
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
