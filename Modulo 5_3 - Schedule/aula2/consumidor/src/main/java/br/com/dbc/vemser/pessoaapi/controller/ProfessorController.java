package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.entity.ProfessorEntity;
import br.com.dbc.vemser.pessoaapi.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor") // localhost:8080/professor
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorRepository professorRepository;

    @GetMapping
    public List<ProfessorEntity> listar()  {
        return professorRepository.findAll();
    }

    @PostMapping
    public ProfessorEntity create(@RequestBody ProfessorEntity professor) {
        return professorRepository.save(professor);
    }

}
