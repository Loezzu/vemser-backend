package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.PropertieReader;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Slf4j
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PropertieReader propertieReader;

    @Value("${user}")
    private String usuario;


    @GetMapping("/ambiente")
    public String ambiente() {
        return propertieReader.getAmbiente();
    }

    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public String hello() {
        log.error("chamou o metodo Hello");
        return "Hello " + usuario;
    }

    @PostMapping // localhost:8080/pessoa
    @Validated
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        PessoaDTO pessoaCriada = pessoaService.create(pessoa);

        return ResponseEntity.ok(pessoaCriada);
    }

    @GetMapping // localhost:8080/pessoa
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public List<PessoaDTO> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id, @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }

    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }

}
