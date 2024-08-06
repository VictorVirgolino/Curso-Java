package acc.br.corridaJPA.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import acc.br.corridaJPA.model.Corrida;
import acc.br.corridaJPA.repository.CorridaRepository;
import acc.br.corridaJPA.repository.LocalRepository;

//Define a lógica de negócio
@Service
public class CorridaService
{
    @Autowired
    CorridaRepository corridaRepository;

    @Autowired
    LocalRepository localRepository;

    //Pega todos os registros da tabela students
    public List<Corrida> getAllCorrida()
    {
        List<Corrida> corridas = new ArrayList<Corrida>();
        corridaRepository.findAll().forEach(corrida -> corridas.add(corrida));
        return corridas;
    }
    //Recupera um registro especifico
    public Corrida getCorridaById(long id)
    {
        return corridaRepository.findById(id).get();
    }
    public void saveOrUpdate(Corrida corrida)
    {
        corridaRepository.save(corrida);
    }
    //Deleta um registro especifico
    public void delete(long id)
    {
        corridaRepository.deleteById(id);
    }

    //POST Adicionar uma corrida a um Local
    public void criarCorrida(@PathVariable(value = "localId") Long localId, @RequestBody Corrida corridaRequest) {
//	public ResponseEntity<Corrida> createCorrida(@PathVariable(value = "localId") Long localId, @RequestBody Corrida corridaRequest) {
        Corrida corrida = localRepository
                .findById(localId)
                .map(local -> {
                    corridaRequest.setLocal(local);
                    return corridaRepository.save(corridaRequest);})
                .orElse(corridaRequest);
//			  			 .orElseThrow(() -> new ResourceNotFoundException("Não encontrado o Local com id = " + localId));
//		return new ResponseEntity<>(corrida, HttpStatus.CREATED);
    }

    //GET Consulta corridas por local
    public ResponseEntity<List<Corrida>> consultaCorridasPorLocalId(@PathVariable(value = "localId") Long localId) {
        if (!localRepository.existsById(localId)) {
//		      throw new ResourceNotFoundException("Não encontrado o Local com id = \" + localId));
        }

        List<Corrida> corridas = corridaRepository.findByLocalId(localId);
        return new ResponseEntity<>(corridas, HttpStatus.OK);
    }

    //DELETE Coridas por Local
    public ResponseEntity<List<Corrida>> deletaCorridasPorLocalId(@PathVariable(value = "localId") Long localId) {
        if (!localRepository.existsById(localId)) {
//	      throw new ResourceNotFoundException("Not found Tutorial with id = " + localId);
        }

        corridaRepository.deleteByLocalId(localId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
