package com.topicosii.orcamento.Controller;

import com.topicosii.orcamento.Model.TipoLancamento;
import com.topicosii.orcamento.Model.Unidade;
import com.topicosii.orcamento.Repository.UnidadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/unidade")
@AllArgsConstructor
public class UnidadeController {

    private UnidadeRepository repository;

    @PostMapping("/create")
    public ResponseEntity<Unidade> createUnidade(@RequestBody Unidade unidade){
        return ResponseEntity.status(CREATED).body(repository.save(unidade));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Unidade> buscarUnidade(@PathVariable Integer id){
        return ResponseEntity.status(OK).body(repository.findById(id).
                orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Unidade não encontrado")));
    }
    @GetMapping
    public ResponseEntity<List<Unidade>> listarUnidade(){
        return ResponseEntity.status(OK).body(repository.findAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Unidade> atualizarUnidade(@RequestBody Unidade unidade, @PathVariable Integer id){
        Optional<Unidade> unidade1 = repository.findById(id);
        if(unidade1.isPresent()){
            unidade.setId(id);
            unidade1.get().getId();
            repository.save(unidade);
            return ResponseEntity.status(OK).body(repository.save(unidade1.get()));
        }
        return ResponseEntity.status(NOT_FOUND).body(null);
    }
    @DeleteMapping("delete/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteUnidade(@PathVariable Integer id){
        repository.findById(id).map(unidade -> {
            repository.deleteById(id);
            return Void.TYPE;
        }).orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Unnidade não encontrada"));
    }
}
