package com.topicosii.orcamento.Controller;

import com.topicosii.orcamento.Model.ObjetivoEstrategico;
import com.topicosii.orcamento.Model.Programa;
import com.topicosii.orcamento.Repository.ObjetivoEstrategicoRepository;
import com.topicosii.orcamento.Repository.ProgramaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

public class ObjetivoEstrategicoController {
    private ObjetivoEstrategicoRepository repository;

    @PostMapping("/create")
    public ResponseEntity<ObjetivoEstrategico> createObjetivoEstrategic(@RequestBody ObjetivoEstrategico objetivoEstrategic){
        return ResponseEntity.status(CREATED).body(repository.save(objetivoEstrategic));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ObjetivoEstrategico> buscarObjetivoEstrategico(@PathVariable Integer id){
        return ResponseEntity.status(OK).body(repository.findById(id).
                orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Objetivo Estrategico não encontrado")));
    }
    @GetMapping
    public ResponseEntity<List<ObjetivoEstrategico>> listaObjetivoEstrategico(){
        return ResponseEntity.status(OK).body(repository.findAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ObjetivoEstrategico> atualizarObjetivoEstrategico(@RequestBody ObjetivoEstrategico objetivoEstrategico, @PathVariable Integer id){
        Optional<ObjetivoEstrategico> objetivoEstrategico1 = repository.findById(id);
        if (objetivoEstrategico1.isPresent()){
            objetivoEstrategico.setId(id);
            objetivoEstrategico1.get().setId(id);
            repository.save(objetivoEstrategico1.get());
            return ResponseEntity.status(OK).body(repository.save(objetivoEstrategico1.get()));
        }
        return ResponseEntity.status(NOT_FOUND).body(null);
    }
    @DeleteMapping("delete/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteObjetivoEstrategico(@PathVariable Integer id){
        repository.findById(id).map(objetivoEstrategico -> {
            repository.deleteById(id);
            return Void.TYPE;
        }).orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Objetivo Estrategico não encontrado"));
    }
}
