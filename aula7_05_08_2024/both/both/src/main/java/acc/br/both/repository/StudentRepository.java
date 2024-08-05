package acc.br.both.repository;

import acc.br.both.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer>
{
}
