package com.topicosii.orcamento.Controller;

import com.topicosii.orcamento.Model.ModalidadeAplicacao;
import com.topicosii.orcamento.Model.Programa;
import com.topicosii.orcamento.Repository.ModalidadeAplicacaoRepository;
import com.topicosii.orcamento.Repository.ProgramaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

public class ModalidadeAplicacaoController {
    private ModalidadeAplicacaoRepository repository;

    @PostMapping("/create")
    public ResponseEntity<ModalidadeAplicacao> createModalidadeAplicacao(@RequestBody ModalidadeAplicacao modalidadeAplicacao){
        return ResponseEntity.status(CREATED).body(repository.save(modalidadeAplicacao));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ModalidadeAplicacao> buscarModalidadeAplicacao(@PathVariable Integer id){
        return ResponseEntity.status(OK).body(repository.findById(id).
                orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Modalidade da Aplicação não encontrada")));
    }
    @GetMapping
    public ResponseEntity<List<ModalidadeAplicacao>> listaModalidadeAplicacao(){
        return ResponseEntity.status(OK).body(repository.findAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ModalidadeAplicacao> atualizarModalidadeAplicacao(@RequestBody ModalidadeAplicacao modalidadeAplicacao, @PathVariable Integer id){
        Optional<ModalidadeAplicacao> modalidadeAplicacao1 = repository.findById(id);
        if (modalidadeAplicacao1.isPresent()){
            modalidadeAplicacao.setId(id);
            modalidadeAplicacao1.get().setId(id);
            repository.save(modalidadeAplicacao1.get());
            return ResponseEntity.status(OK).body(repository.save(modalidadeAplicacao1.get()));
        }
        return ResponseEntity.status(NOT_FOUND).body(null);
    }
    @DeleteMapping("delete/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteModalidadeAplicacao(@PathVariable Integer id){
        repository.findById(id).map(modalidadeAplicacao -> {
            repository.deleteById(id);
            return Void.TYPE;
        }).orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Modalidade de Aplicação não encontrada"));
    }
}
