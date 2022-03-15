package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Validated
@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

//    public ContatoController() {
//        contatoService = new ContatoService();
//    }

    @GetMapping  // localhost:8080/contato
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}")// localhost:8080/contato/4
    public List<Contato> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Contato> create(@Valid @RequestBody Contato contato, @PathVariable("idPessoa") Integer idPessoa) throws Exception {
        contato.setIdPessoa(idPessoa);
        return ResponseEntity.ok(contatoService.create(contato));
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<Contato> update(@Valid @PathVariable("idContato") Integer idContato, @RequestBody Contato contatoAtualizar) throws Exception  {
        return ResponseEntity.ok(contatoService.update(idContato, contatoAtualizar));
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer idContato) throws Exception  {
        contatoService.delete(idContato);
    }


}
