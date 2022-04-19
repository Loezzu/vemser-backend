package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.*;
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


    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id, @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }


    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }

    @GetMapping("/pessoas-entre-duas-datas")
    public List<PessoaEntity> listarPessoasEntreDuasDatas(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
                                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        return pessoaRepository.findByDataNascimento(dataInicial, dataFinal);
    }

    @GetMapping("/pessoas-que-possuem-endereco")
    public List<PessoaEntity> listarPessoasQuePossuemEndereco() {
        return pessoaRepository.findByPessoasQuePossuemEnderecos();
    }

    @GetMapping("pessoas-que-nao-possuem-endereco")
    public List<PessoaEntity> listarPessoasQueNaoPossuemEndereco() {
        return pessoaRepository.findQueNaoPossuemEndereco();
    }

    @GetMapping("/pessoa-completa")
    public List<PessoaDTOComEnderecosEContatos> listarPessoasComEnderecosEContatos(@RequestParam(value = "id", required = false) Integer id) throws Exception {
        return pessoaService.listarPessoasComEnderecoEContatos(id);
    }

    @GetMapping("pessoa-completa-byname")
    public List<PessoaDTOComEnderecosEContatos> listarPessoasComEnderecosEContatosByName(@RequestParam("nome") String nome) {
        return pessoaService.listarPessoaComEnderecoEContatosPorNome(nome);
    }

    @GetMapping("pessoa-completa-que-possui-endereco")
    public List<PessoaDTOComEnderecosEContatos> listarPessoasComEnderecosEContatosQuePossuemEndereco() {
        return pessoaService.listarPessoaComEnderecoEContatosQuePossuemEndereco();
    }

    @GetMapping("pessoa-completa-que-nao-possui-endereco")
    public List<PessoaDTOComEnderecosEContatos> listarPessoasComEnderecosEContatosQueNaoPossuemEndereco() {
        return pessoaService.listarPessoaComEnderecoEContatosQueNaoPossuemEndereco();
    }

    @GetMapping("aniversariante-do-dia")
    public List<PessoaDTO> listarAniversariantesDoDia() {
        return pessoaService.aniversariantesDoDia();
    }
}
