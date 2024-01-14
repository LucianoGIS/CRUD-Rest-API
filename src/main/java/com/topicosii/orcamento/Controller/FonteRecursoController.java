package com.topicosii.orcamento.Controller;

import com.topicosii.orcamento.Model.FonteRecurso;
import com.topicosii.orcamento.Model.Lancamentos;
import com.topicosii.orcamento.Repository.FonteRecursoRepository;
import com.topicosii.orcamento.Repository.LancamentosRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

public class FonteRecursoController {
    private FonteRecursoRepository repository;

    @PostMapping("/create")
    public ResponseEntity<FonteRecurso> createFonteRecurso(@RequestBody FonteRecurso fonteRecurso){
        return ResponseEntity.status(CREATED).body(repository.save(fonteRecurso));
    }
    @GetMapping("/{id}")
    public ResponseEntity<FonteRecurso> buscarFonteRecurso(@PathVariable Integer id){
        return ResponseEntity.status(OK).body(repository.findById(id).
                orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Fonte Recurso não encontrado")));
    }
    @GetMapping
    public ResponseEntity<List<FonteRecurso>> listaFonteRecurso(){
        return ResponseEntity.status(OK).body(repository.findAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<FonteRecurso> atualizarFonteRecurso(@RequestBody FonteRecurso fonteRecurso, @PathVariable Integer id){
        Optional<FonteRecurso> fonteRecurso1 = repository.findById(id);
        if (fonteRecurso1.isPresent()){
            fonteRecurso.setId(id);
            fonteRecurso1.get().setId(id);
            repository.save(fonteRecurso1.get());
            return ResponseEntity.status(OK).body(repository.save(fonteRecurso1.get()));
        }
        return ResponseEntity.status(NOT_FOUND).body(null);
    }
    @DeleteMapping("delete/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteFonteRecurso(@PathVariable Integer id){
        repository.findById(id).map(fonteRecurso -> {
            repository.deleteById(id);
            return Void.TYPE;
        }).orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Lançamento não encontrado"));
    }
}
