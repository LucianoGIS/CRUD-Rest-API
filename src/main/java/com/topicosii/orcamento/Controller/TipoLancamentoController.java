package com.topicosii.orcamento.Controller;

import com.topicosii.orcamento.Model.Solicitante;
import com.topicosii.orcamento.Model.TipoLancamento;
import com.topicosii.orcamento.Repository.TipoLancamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/tipoLancamento")
@AllArgsConstructor
public class TipoLancamentoController {

    private TipoLancamentoRepository repository;

    @PostMapping("/create")
    public ResponseEntity<TipoLancamento> createTipoLancamento(@RequestBody TipoLancamento tipoLancamento){
        return ResponseEntity.status(CREATED).body(repository.save(tipoLancamento));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TipoLancamento> buscarTipoSolicitante(@PathVariable Integer id){
        return ResponseEntity.status(OK).body(repository.findById(id).
                orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Solicitante não encontrado")));
    }
    @GetMapping
    public ResponseEntity<List<TipoLancamento>> listarTipoLancamento(){
        return ResponseEntity.status(OK).body(repository.findAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<TipoLancamento> atualizarSolicitante(@RequestBody TipoLancamento tipoLancamento, @PathVariable Integer id){
        Optional<TipoLancamento> tipoLancamento1 = repository.findById(id);
        if(tipoLancamento1.isPresent()){
            tipoLancamento.setId(id);
            tipoLancamento1.get().getId();
            repository.save(tipoLancamento);
            return ResponseEntity.status(OK).body(repository.save(tipoLancamento1.get()));
        }
        return ResponseEntity.status(NOT_FOUND).body(null);
    }
    @DeleteMapping("delete/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteTipoLancamento(@PathVariable Integer id){
        repository.findById(id).map(tipoLancamento -> {
            repository.deleteById(id);
            return Void.TYPE;
        }).orElseThrow(()->new ResponseStatusException(NOT_FOUND, "Tipo de Lançamento não encontrado"));
    }
}
