package acc.br.both.controller;
import java.util.List;

import acc.br.both.dto.SaveStudentDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import acc.br.both.model.Student;
import acc.br.both.service.StudentService;
import org.springframework.web.servlet.ModelAndView;

//creating RestController
@RestController
public class StudentController
{
    //autowired the StudentService class
    @Autowired
    StudentService studentService;

    //creating a get mapping that retrieves all the students detail from the database
    @GetMapping("/student")
    private List<Student> getAllStudent()
    {
        return studentService.getAllStudent();
    }

    @GetMapping("/student/listar")
    public ModelAndView listar() {
        List<Student> lista = this.getAllStudent();

        ModelAndView modelAndView = new ModelAndView("estudantes");
        modelAndView.addObject("estudantes", lista);

        return modelAndView;
    }

    //creating a get mapping that retrieves the detail of a specific student
    @GetMapping("/student/{id}")
    private Student getStudent(@PathVariable("id") int id)
    {
        return studentService.getStudentById(id);
    }

    //creating a delete mapping that deletes a specific student
    @DeleteMapping("/student/{id}")
    private void deleteStudent(@PathVariable("id") int id)
    {
        studentService.delete(id);
    }

    //creating post mapping that post the student detail in the database
    @PostMapping("/student")
    private int saveStudent(@Valid @RequestBody SaveStudentDTO saveStudentDTO)
    {
        studentService.saveOrUpdate(saveStudentDTO);
        return Integer.parseInt(saveStudentDTO.getId());
    }


}

