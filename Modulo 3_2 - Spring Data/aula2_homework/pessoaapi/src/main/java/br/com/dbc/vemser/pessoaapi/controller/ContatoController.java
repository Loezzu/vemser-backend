package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
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

    @GetMapping  // localhost:8080/contato
    public List<ContatoDTO> list() {
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}")// localhost:8080/contato/4
    public List<ContatoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(idPessoa);
    }

    @PostMapping
    public ResponseEntity<ContatoDTO> create(@Valid @RequestBody ContatoCreateDTO contato) throws Exception {
        return ResponseEntity.ok(contatoService.create(contato));
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoDTO> update(@Valid @PathVariable("idContato") Integer idContato, @RequestBody ContatoCreateDTO contatoAtualizar) throws Exception  {
        return ResponseEntity.ok(contatoService.update(idContato, contatoAtualizar));
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer idContato) throws Exception  {
        contatoService.delete(idContato);
    }


}
