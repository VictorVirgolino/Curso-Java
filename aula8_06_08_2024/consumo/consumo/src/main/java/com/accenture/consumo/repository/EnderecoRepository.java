package com.accenture.consumo.repository;

import com.accenture.consumo.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EnderecoRepository extends JpaRepository<Endereco, Long> {
}
