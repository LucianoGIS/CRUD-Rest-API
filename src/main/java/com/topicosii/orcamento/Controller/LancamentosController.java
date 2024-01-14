package com.topicosii.orcamento.Controller;
import com.topicosii.orcamento.Model.Lancamentos;
import com.topicosii.orcamento.Repository.LancamentosRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/lancamentos")
@AllArgsConstructor
public class LancamentosController {

    private LancamentosRepository repository;

    @PostMapping("/create")
    public ResponseEntity<Lancamentos> createLancamento(@RequestBody Lancamentos lancamentos){
        return ResponseEntity.status(CREATED).body(repository.save(lancamentos));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Lancamentos> buscarLancamento(@PathVariable Integer id){
        return ResponseEntity.status(OK).body(repository.findById(id).
                orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Lançamento não encontrado")));
    }
    @GetMapping
    public ResponseEntity<List<Lancamentos>> listaLancamentos(){
        return ResponseEntity.status(OK).body(repository.findAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Lancamentos> atualizarLancamento(@RequestBody Lancamentos lancamentos, @PathVariable Integer id){
        Optional<Lancamentos> lancamentos1 = repository.findById(id);
        if (lancamentos1.isPresent()){
            lancamentos.setId(id);
            lancamentos1.get().setId(id);
            repository.save(lancamentos1.get());
            return ResponseEntity.status(OK).body(repository.save(lancamentos1.get()));
        }
        return ResponseEntity.status(NOT_FOUND).body(null);
    }
    @DeleteMapping("delete/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteLancamento(@PathVariable Integer id){
        repository.findById(id).map(lancamentos -> {
            repository.deleteById(id);
            return Void.TYPE;
        }).orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Lançamento não encontrado"));
    }
}