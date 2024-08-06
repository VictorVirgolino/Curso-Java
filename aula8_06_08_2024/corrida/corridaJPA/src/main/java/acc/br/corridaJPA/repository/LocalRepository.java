package acc.br.corridaJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acc.br.corridaJPA.model.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long>
{
}

