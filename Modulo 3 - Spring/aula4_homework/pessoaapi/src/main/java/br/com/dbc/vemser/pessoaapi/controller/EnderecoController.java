package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;


   @GetMapping // localhost:8080/endereco
   public List<Endereco> list() {
       return enderecoService.list();
   }

   @PostMapping("/{idPessoa}")
   public ResponseEntity<Endereco> create(@Valid @RequestBody Endereco endereco, @PathVariable("idPessoa") Integer idPessoa) throws Exception {
       endereco.setIdPessoa(idPessoa);
       return ResponseEntity.ok(enderecoService.create(endereco, idPessoa));
   }

   @PutMapping("/{idEndereco}")
   public ResponseEntity<Endereco> update(@Valid @PathVariable("idEndereco") Integer idEndereco, @RequestBody Endereco enderecoAtualizar) throws Exception {
       return ResponseEntity.ok(enderecoService.update(idEndereco, enderecoAtualizar));
   }

   @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer idEndereco) throws Exception {
       enderecoService.delete(idEndereco);
   }

   @GetMapping("/{idEndereco}")
   public ResponseEntity<List<Endereco>> listByIdEndereco(@PathVariable("idEndereco") Integer idEndereco) {
       return ResponseEntity.ok(enderecoService.listByIdEndereco(idEndereco));
   }

   @GetMapping("/{idPessoa}/pessoa")
   public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
       return enderecoService.listByIdPessoa(idPessoa);
   }


}
