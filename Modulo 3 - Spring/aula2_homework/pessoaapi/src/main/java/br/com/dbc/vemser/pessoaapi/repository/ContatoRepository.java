package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.enums.TipoContato;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ContatoRepository {
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, TipoContato.COMERCIAL, "99999999", "Contato Maicon"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 2, TipoContato.RESIDENCIAL, "88888888", "Contato Charles"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 3, TipoContato.COMERCIAL, "7777777", "Contato Marina"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 4, TipoContato.RESIDENCIAL, "66666666", "Contato Rafael"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 5, TipoContato.COMERCIAL, "55555555", "Contato Ana"));
    }

    public Contato create(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContatos;
    }

    public Contato update(Integer id, Contato contatoAtualizar) throws Exception  {
       Contato contatoRecuperado = listaContatos.stream()
               .filter(contato -> contato.getIdContato().equals(id))
               .findFirst()
               .orElseThrow(() -> new Exception("Contato não encontrado"));
       contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa());
       contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
       contatoRecuperado.setNumero(contatoAtualizar.getNumero());
       contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception {
     Contato contatoRecuperado = listaContatos.stream()
             .filter(contato -> contato.getIdContato().equals(id))
             .findFirst()
             .orElseThrow(() -> new Exception("Contato não encontrado"));
     listaContatos.remove(contatoRecuperado);
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        Pessoa pessoa = new Pessoa();
        pessoa.setIdPessoa(idPessoa);
       return listaContatos.stream()
               .filter(contato -> contato.getIdPessoa().equals(pessoa.getIdPessoa()))
               .collect(Collectors.toList());


    }



}




















