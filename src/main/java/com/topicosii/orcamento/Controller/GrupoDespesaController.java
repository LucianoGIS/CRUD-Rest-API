package com.topicosii.orcamento.Controller;

import com.topicosii.orcamento.Model.FonteRecurso;
import com.topicosii.orcamento.Model.GrupoDespesa;
import com.topicosii.orcamento.Repository.FonteRecursoRepository;
import com.topicosii.orcamento.Repository.GrupoDespesaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

public class GrupoDespesaController {
    private GrupoDespesaRepository repository;

    @PostMapping("/create")
    public ResponseEntity<GrupoDespesa> createGrupoDespesa(@RequestBody GrupoDespesa grupoDespesa){
        return ResponseEntity.status(CREATED).body(repository.save(grupoDespesa));
    }
    @GetMapping("/{id}")
    public ResponseEntity<GrupoDespesa> buscarGrupoDespesa(@PathVariable Integer id){
        return ResponseEntity.status(OK).body(repository.findById(id).
                orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Grupo Despesa não encontrada")));
    }
    @GetMapping
    public ResponseEntity<List<GrupoDespesa>> listaGrupoDespesa(){
        return ResponseEntity.status(OK).body(repository.findAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<GrupoDespesa> atualizarGrupoDespesa(@RequestBody GrupoDespesa grupoDespesa, @PathVariable Integer id){
        Optional<GrupoDespesa> grupoDespesa1 = repository.findById(id);
        if (grupoDespesa1.isPresent()){
            grupoDespesa.setId(id);
            grupoDespesa1.get().setId(id);
            repository.save(grupoDespesa1.get());
            return ResponseEntity.status(OK).body(repository.save(grupoDespesa1.get()));
        }
        return ResponseEntity.status(NOT_FOUND).body(null);
    }
    @DeleteMapping("delete/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteGrupoDespesa(@PathVariable Integer id){
        repository.findById(id).map(grupoDespesa -> {
            repository.deleteById(id);
            return Void.TYPE;
        }).orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Grupo Despesa não encontrado"));
    }
}
