package com.topicosii.orcamento.Controller;

import com.topicosii.orcamento.Model.Acao;
import com.topicosii.orcamento.Model.ElementoDespesa;
import com.topicosii.orcamento.Repository.AcaoRepository;
import com.topicosii.orcamento.Repository.ElementoDespesaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

public class AcaoController {
    private AcaoRepository repository;

    @PostMapping("/create")
    public ResponseEntity<Acao> createAcao(@RequestBody Acao acao){
        return ResponseEntity.status(CREATED).body(repository.save(acao));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Acao> buscarElementoDespesa(@PathVariable Integer id){
        return ResponseEntity.status(OK).body(repository.findById(id).
                orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Ação não encontrada")));
    }
    @GetMapping
    public ResponseEntity<List<Acao>> listaAcao(){
        return ResponseEntity.status(OK).body(repository.findAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Acao> atualizarAcao(@RequestBody Acao acao, @PathVariable Integer id){
        Optional<Acao> acao1 = repository.findById(id);
        if (acao1.isPresent()){
            acao.setId(id);
            acao1.get().setId(id);
            repository.save(acao1.get());
            return ResponseEntity.status(OK).body(repository.save(acao1.get()));
        }
        return ResponseEntity.status(NOT_FOUND).body(null);
    }
    @DeleteMapping("delete/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteElementoDespesa(@PathVariable Integer id){
        repository.findById(id).map(acao -> {
            repository.deleteById(id);
            return Void.TYPE;
        }).orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Ação não encontrada"));
    }
}
