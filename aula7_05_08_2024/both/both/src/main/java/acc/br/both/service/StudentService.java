package acc.br.both.service;
import java.util.ArrayList;
import java.util.List;

import acc.br.both.dto.SaveStudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acc.br.both.model.Student;
import acc.br.both.repository.StudentRepository;


@Service
public class StudentService
{
    @Autowired
    StudentRepository studentRepository;
    //getting all student records
    public List<Student> getAllStudent()
    {
        List<Student> students = new ArrayList<Student>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }
    //getting a specific record
    public Student getStudentById(int id)
    {
        return studentRepository.findById(id).get();
    }
    public void saveOrUpdate(SaveStudentDTO saveStudentDTO)
    {

        Student student = new Student();

        int id = Integer.parseInt(saveStudentDTO.getId());
        int age = Integer.parseInt(saveStudentDTO.getAge());
        String name = saveStudentDTO.getName();
        String email = saveStudentDTO.getEmail();

        student.setId(id);
        student.setAge(age);
        student.setName(name);
        student.setEmail(email);

        studentRepository.save(student);
    }
    //deleting a specific record
    public void delete(int id)
    {
        studentRepository.deleteById(id);
    }
}