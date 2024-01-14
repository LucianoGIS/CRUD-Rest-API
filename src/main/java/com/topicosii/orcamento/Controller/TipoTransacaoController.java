package com.topicosii.orcamento.Controller;

import com.topicosii.orcamento.Model.TipoTransacao;
import com.topicosii.orcamento.Model.Unidade;
import com.topicosii.orcamento.Repository.TipoTransacaoRepository;
import com.topicosii.orcamento.Repository.UnidadeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

public class TipoTransacaoController {

    private TipoTransacaoRepository repository;

    @PostMapping("/create")
    public ResponseEntity<TipoTransacao> createTipoTransacao(@RequestBody TipoTransacao tipoTransacao){
        return ResponseEntity.status(CREATED).body(repository.save(tipoTransacao));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TipoTransacao> buscarTipoTransacao(@PathVariable Integer id){
        return ResponseEntity.status(OK).body(repository.findById(id).
                orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Tipo Transação não encontrado")));
    }
    @GetMapping
    public ResponseEntity<List<TipoTransacao>> listarTipoTransacao(){
        return ResponseEntity.status(OK).body(repository.findAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<TipoTransacao> atualizarTipoTransacao(@RequestBody TipoTransacao tipoTransacao, @PathVariable Integer id){
        Optional<TipoTransacao> tipoTransacao1 = repository.findById(id);
        if(tipoTransacao1.isPresent()){
            tipoTransacao.setId(id);
            tipoTransacao1.get().getId();
            repository.save(tipoTransacao);
            return ResponseEntity.status(OK).body(repository.save(tipoTransacao1.get()));
        }
        return ResponseEntity.status(NOT_FOUND).body(null);
    }
    @DeleteMapping("delete/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteTipoTransacao(@PathVariable Integer id){
        repository.findById(id).map(tipoTransacao -> {
            repository.deleteById(id);
            return Void.TYPE;
        }).orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Tipo Transacao não encontrada"));
    }
}
