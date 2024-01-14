package com.topicosii.orcamento.Controller;
import com.topicosii.orcamento.Model.UnidadeOrcamentaria;
import com.topicosii.orcamento.Repository.UnidadeOrcamentariaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/unidadeOrcamentaria")
@AllArgsConstructor
public class UnidadeOrcamentariaController {
    private UnidadeOrcamentariaRepository repository;

    @PostMapping("/create")
    public ResponseEntity<UnidadeOrcamentaria> createUnidadeOrcamentaria(@RequestBody UnidadeOrcamentaria unidadeOrcamentaria){
        return ResponseEntity.status(CREATED).body(repository.save(unidadeOrcamentaria));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UnidadeOrcamentaria> buscarUnidadeOrcamentaria(@PathVariable Integer id){
        return ResponseEntity.status(OK).body(repository.findById(id).
                orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Unidade não encontrado")));
    }
    @GetMapping
    public ResponseEntity<List<UnidadeOrcamentaria>> listarUnidadeOrcamentaria(){
        return ResponseEntity.status(OK).body(repository.findAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<UnidadeOrcamentaria> atualizarUnidadeOrcamentaria(@RequestBody UnidadeOrcamentaria unidadeOrcamentaria, @PathVariable Integer id){
        Optional<UnidadeOrcamentaria> unidadeOrcamentaria1 = repository.findById(id);
        if(unidadeOrcamentaria1.isPresent()){
            unidadeOrcamentaria.setId(id);
            unidadeOrcamentaria1.get().getId();
            repository.save(unidadeOrcamentaria);
            return ResponseEntity.status(OK).body(repository.save(unidadeOrcamentaria1.get()));
        }
        return ResponseEntity.status(NOT_FOUND).body(null);
    }
    @DeleteMapping("delete/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteUnidadeOrcamentaria(@PathVariable Integer id){
        repository.findById(id).map(unidadeOrcamentaria -> {
            repository.deleteById(id);
            return Void.TYPE;
        }).orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Unnidade não encontrada"));
    }
}
