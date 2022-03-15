package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
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
   public List<EnderecoDTO> list() {
       return enderecoService.list();
   }

   @PostMapping("/{idPessoa}")
   public ResponseEntity<EnderecoDTO> create(@Valid @RequestBody EnderecoCreateDTO endereco, @PathVariable("idPessoa") Integer idPessoa) throws Exception {
       endereco.setIdPessoa(idPessoa);
       return ResponseEntity.ok(enderecoService.create(endereco, idPessoa));
   }

   @PutMapping("/{idEndereco}")
   public ResponseEntity<EnderecoDTO> update(@Valid @PathVariable("idEndereco") Integer idEndereco, @RequestBody EnderecoCreateDTO enderecoAtualizar) throws Exception {
       return ResponseEntity.ok(enderecoService.update(idEndereco, enderecoAtualizar));
   }

   @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer idEndereco) throws Exception {
       enderecoService.delete(idEndereco);
   }

   @GetMapping("/{idEndereco}")
   public ResponseEntity<List<EnderecoDTO>> listByIdEndereco(@PathVariable("idEndereco") Integer idEndereco) {
       return ResponseEntity.ok(enderecoService.listByIdEndereco(idEndereco));
   }

   @GetMapping("/{idPessoa}/pessoa")
   public List<EnderecoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
       return enderecoService.listByIdPessoa(idPessoa);
   }


}
