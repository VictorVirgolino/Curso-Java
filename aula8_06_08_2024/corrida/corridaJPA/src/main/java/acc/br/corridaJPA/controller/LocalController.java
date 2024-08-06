package acc.br.corridaJPA.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import acc.br.corridaJPA.model.Local;
import acc.br.corridaJPA.service.LocalService;

//creating RestController
@RestController
public class LocalController
{
    //autowired the localService class
    @Autowired
    LocalService localService;

    //creating a get mapping that retrieves all the Local detail from the database

    @GetMapping("/local")
    private List<Local> getAllLocal()
    {
        return localService.getAllLocal();
    }

    //creating a get mapping that retrieves the detail of a specific student
    @GetMapping("/local/{id}")
    private Local getLocal(@PathVariable("id") int id)
    {
        return localService.getLocalById(id);
    }

    //creating a delete mapping that deletes a specific student
    @DeleteMapping("/local/{id}")
    private void deleteLocal(@PathVariable("id") int id)
    {
        localService.delete(id);
    }

    //creating post mapping that post the student detail in the database
    @PostMapping("/local")
    private long saveLocal(@RequestBody Local local)
    {
        localService.saveOrUpdate(local);
        return local.getId();
        //return 123;
    }
}
