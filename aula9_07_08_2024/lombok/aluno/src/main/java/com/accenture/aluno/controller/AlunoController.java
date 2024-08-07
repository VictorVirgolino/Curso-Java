package com.accenture.aluno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.aluno.model.Aluno;
import com.accenture.aluno.service.AlunoService;

//creating RestController
@RestController
public class AlunoController {
    //autowired the StudentService class
    @Autowired
    AlunoService alunoService;

    //creating a get mapping that retrieves all the alunos detail from the database
    @GetMapping("/aluno")
    private List<Aluno> getAllAluno()
    {
        return alunoService.getAllAluno();
    }

    //creating a get mapping that retrieves the detail of a specific aluno
    @GetMapping("/aluno/{id}")
    private Aluno getAluno(@PathVariable("id") int id)
    {
        return alunoService.getAlunoById(id);
    }

    //creating a delete mapping that deletes a specific aluno
    @DeleteMapping("/aluno/{id}")
    private void deleteAluno(@PathVariable("id") int id)
    {
        alunoService.delete(id);
    }

    //creating post mapping that post the aluno detail in the database
    @PostMapping("/aluno")
    private int saveAluno(@RequestBody Aluno aluno)
    {
        alunoService.saveOrUpdate(aluno);
        return aluno.getId();
    }
}

