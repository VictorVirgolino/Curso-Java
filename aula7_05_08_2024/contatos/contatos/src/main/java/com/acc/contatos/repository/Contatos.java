package com.acc.contatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acc.contatos.model.Contato;

public interface Contatos extends JpaRepository<Contato, Long> {

}
