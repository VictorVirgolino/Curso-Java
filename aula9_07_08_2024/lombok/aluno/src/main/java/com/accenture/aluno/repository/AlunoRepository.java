package com.accenture.aluno.repository;

import org.springframework.data.repository.CrudRepository;

import com.accenture.aluno.model.Aluno;

public interface AlunoRepository  extends CrudRepository<Aluno, Integer>{

}
