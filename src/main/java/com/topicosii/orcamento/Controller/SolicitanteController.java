package com.topicosii.orcamento.Controller;

import com.topicosii.orcamento.Model.Lancamentos;
import com.topicosii.orcamento.Model.Solicitante;
import com.topicosii.orcamento.Repository.LancamentosRepository;
import com.topicosii.orcamento.Repository.SolicitanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/solicitante")
@AllArgsConstructor
public class SolicitanteController {

    private SolicitanteRepository repository;

    @PostMapping("/create")
    public ResponseEntity<Solicitante> createSolicitante(@RequestBody Solicitante solicitante){
        return ResponseEntity.status(CREATED).body(repository.save(solicitante));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Solicitante> buscarSolicitante(@PathVariable Integer id){
        return ResponseEntity.status(OK).body(repository.findById(id).
                orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Solicitante não encontrado")));
    }
    @GetMapping
    public ResponseEntity<List<Solicitante>> listaSolicitantes(){
        return ResponseEntity.status(OK).body(repository.findAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Solicitante> atualizarSolicitante(@RequestBody Solicitante solicitante, @PathVariable Integer id){
        Optional<Solicitante> solicitante1 = repository.findById(id);
        if (solicitante1.isPresent()){
            solicitante.setId(id);
            solicitante1.get().getId();
            repository.save(solicitante);
            return ResponseEntity.status(OK).body(repository.save(solicitante1.get()));
        }
        return ResponseEntity.status(NOT_FOUND).body(null);
    }
    @DeleteMapping("delete/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteSolicitante(@PathVariable Integer id){
        repository.findById(id).map(solicitante -> {
            repository.deleteById(id);
            return Void.TYPE;
        }).orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Solicitante não encontrado"));
    }
    
}
