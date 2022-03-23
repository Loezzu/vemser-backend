package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTOComContatos;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTOComEnderecos;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import br.com.dbc.vemser.pessoaapi.repository.PropertieReader;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Slf4j
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PropertieReader propertieReader;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Value("${user}")
    private String usuario;

    @ApiOperation(value = "Retorna uma String")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma pessoa por id"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @GetMapping("/ambiente")
    public String ambiente() {
        return propertieReader.getAmbiente();
    }


    @ApiOperation(value = "Retorna uma String")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma pessoa por id"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public String hello() {
        log.error("chamou o metodo Hello");
        return "Hello " + usuario;
    }
    @ApiOperation(value = "Retorna uma pessoa por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma pessoa por id"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @PostMapping // localhost:8080/pessoa
    @Validated
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        PessoaDTO pessoaCriada = pessoaService.create(pessoa);

        return ResponseEntity.ok(pessoaCriada);
    }

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @GetMapping // localhost:8080/pessoa
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

    @GetMapping("/byname")
    public List<PessoaEntity> listByName(@RequestParam("nome") String nome) {
        return pessoaRepository.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("/bycpf")
    public List<PessoaEntity> listByCpf(@RequestParam("cpf") String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }


    @GetMapping("/by-data-nascimento")
    public List<PessoaEntity> listByData(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        return pessoaRepository.findByDataNascimentoBetween(dataInicial, dataFinal);
    }

    @GetMapping("/listar-com-contatos")
    public List<PessoaDTOComContatos> listarPessoasComContatos(@RequestParam(value = "id", required = false) Integer id) throws Exception {
        return pessoaService.listarPessoasComContatos(id);
    }

    @GetMapping("/listar-com-endereco")
    public List<PessoaDTOComEnderecos> listarPessoasComEnderecos(@RequestParam(value = "id", required = false) Integer id) throws Exception {
        return pessoaService.listarPessoasComEnderecos(id);
    }

    @ApiOperation(value = "Retorna uma pessoa por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma pessoa por id"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id, @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }

    @ApiOperation(value = "Deleta uma pessoa por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deleta uma pessoa por id"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }

}
