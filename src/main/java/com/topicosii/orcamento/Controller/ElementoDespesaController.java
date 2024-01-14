package com.topicosii.orcamento.Controller;
import com.topicosii.orcamento.Model.ElementoDespesa;
import com.topicosii.orcamento.Repository.ElementoDespesaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

public class ElementoDespesaController {

    private ElementoDespesaRepository repository;

    @PostMapping("/create")
    public ResponseEntity<ElementoDespesa> createElementoDespesa(@RequestBody ElementoDespesa elementoDespesa){
        return ResponseEntity.status(CREATED).body(repository.save(elementoDespesa));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ElementoDespesa> buscarElementoDespesa(@PathVariable Integer id){
        return ResponseEntity.status(OK).body(repository.findById(id).
                orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Elemento Despesa não encontrado")));
    }
    @GetMapping
    public ResponseEntity<List<ElementoDespesa>> listaElementoDespesa(){
        return ResponseEntity.status(OK).body(repository.findAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ElementoDespesa> atualizarElementoDespesa(@RequestBody ElementoDespesa elementoDespesa, @PathVariable Integer id){
        Optional<ElementoDespesa> elementoDespesa1 = repository.findById(id);
        if (elementoDespesa1.isPresent()){
            elementoDespesa.setId(id);
            elementoDespesa1.get().setId(id);
            repository.save(elementoDespesa1.get());
            return ResponseEntity.status(OK).body(repository.save(elementoDespesa1.get()));
        }
        return ResponseEntity.status(NOT_FOUND).body(null);
    }
    @DeleteMapping("delete/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteElementoDespesa(@PathVariable Integer id){
        repository.findById(id).map(elementoDespesa -> {
            repository.deleteById(id);
            return Void.TYPE;
        }).orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Elemento despesa não encontrado"));
    }
}
