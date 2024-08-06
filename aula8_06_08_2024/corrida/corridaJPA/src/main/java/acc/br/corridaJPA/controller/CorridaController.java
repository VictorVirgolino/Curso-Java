package acc.br.corridaJPA.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import acc.br.corridaJPA.model.Corrida;
import acc.br.corridaJPA.service.CorridaService;
import acc.br.corridaJPA.service.LocalService;

//creating RestController
@RestController
public class CorridaController
{
    //autowired the StudentService class
    @Autowired
    CorridaService corridaService;

    @Autowired
    LocalService localService;


    @GetMapping("/corrida")
    private List<Corrida> getAllCorrida()
    {
        return corridaService.getAllCorrida();
    }

    //creating a get mapping that retrieves the detail of a specific student
    @GetMapping("/corrida/{id}")
    private Corrida getCorrida(@PathVariable("id") int id)
    {
        return corridaService.getCorridaById(id);
    }

    //creating a delete mapping that deletes a specific student
    @DeleteMapping("/corrida/{id}")
    private void deleteCorrida(@PathVariable("id") int id)
    {
        corridaService.delete(id);
    }

    //creating post mapping that post the student detail in the database
    @PostMapping("/corrida")
    private long saveCorrida(@RequestBody Corrida corrida)
    {
        corridaService.saveOrUpdate(corrida);
        return corrida.getIdCorrida();

    }

    //Adicionar uma corrida a um Local
    @PostMapping("/local/{localId}/corrida")
    public ResponseEntity<Corrida> criarCorrida(@PathVariable(value = "localId") Long localId, @RequestBody Corrida corridaRequest) {
        corridaService.criarCorrida(localId, corridaRequest);
        return new ResponseEntity<>(corridaRequest, HttpStatus.CREATED);
    }

    //Consulta todas as corridas de um local
    @GetMapping("/local/{localId}/corrida")
    public ResponseEntity<List<Corrida>> consultaCorridasPorLocalId(@PathVariable(value = "localId") Long localId) {

        return corridaService.consultaCorridasPorLocalId(localId);
    }

    @DeleteMapping("/local/{localId}/corrida")
    public ResponseEntity<List<Corrida>> deletaCorridasPorLocalId(@PathVariable(value = "localId") Long localId) {
        corridaService.deletaCorridasPorLocalId(localId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

