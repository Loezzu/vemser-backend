package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

//    public PessoaService(){
//        pessoaRepository = new PessoaRepository();
//    }

    public Pessoa create(Pessoa pessoa) {
        try {
            if (StringUtils.isBlank(pessoa.getNome())) {
                throw new Exception("Nome não pode ser vazio");
            } else if(ObjectUtils.isEmpty(pessoa.getDataNascimento())){
                throw new Exception("Data de nascimento não pode ser vazio");
            } else if(StringUtils.isBlank(pessoa.getCpf()) || StringUtils.length(pessoa.getCpf()) != 11){
                throw new Exception("CPF não pode ser vazio e tem que ter 11 caracteres");
            }
            return pessoaRepository.create(pessoa);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Pessoa> list(){
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar) throws Exception {
        return pessoaRepository.update(id, pessoaAtualizar);
    }

    public void delete(Integer id) throws Exception {
        pessoaRepository.delete(id);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }
}
