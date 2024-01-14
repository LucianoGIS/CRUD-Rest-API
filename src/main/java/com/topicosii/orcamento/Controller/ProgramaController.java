package com.topicosii.orcamento.Controller;
import com.topicosii.orcamento.Model.Lancamentos;
import com.topicosii.orcamento.Model.Programa;
import com.topicosii.orcamento.Repository.ProgramaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/programa")
@AllArgsConstructor
public class ProgramaController {

    private ProgramaRepository repository;

    @PostMapping("/create")
    public ResponseEntity<Programa> createPrograma(@RequestBody Programa programa){
        return ResponseEntity.status(CREATED).body(repository.save(programa));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Programa> buscarPrograma(@PathVariable Integer id){
        return ResponseEntity.status(OK).body(repository.findById(id).
                orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Programa não encontrado")));
    }
    @GetMapping
    public ResponseEntity<List<Programa>> listaPrograma(){
        return ResponseEntity.status(OK).body(repository.findAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Programa> atualizarPrograma(@RequestBody Programa programa, @PathVariable Integer id){
        Optional<Programa> programa1 = repository.findById(id);
        if (programa1.isPresent()){
            programa.setId(id);
            programa1.get().setId(id);
            repository.save(programa1.get());
            return ResponseEntity.status(OK).body(repository.save(programa1.get()));
        }
        return ResponseEntity.status(NOT_FOUND).body(null);
    }
    @DeleteMapping("delete/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletePrograma(@PathVariable Integer id){
        repository.findById(id).map(programa -> {
            repository.deleteById(id);
            return Void.TYPE;
        }).orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Programa não encontrado"));
    }
}
