package br.com.jgfinance.controller;

import br.com.jgfinance.entity.Despesa;
import br.com.jgfinance.entity.form.DespesaForm;
import br.com.jgfinance.service.DespesaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

    private final DespesaService service;

    public DespesaController(DespesaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Despesa> create(@RequestBody DespesaForm form) {
        Despesa despesa = service.create(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(despesa);
    }

    @GetMapping
    public ResponseEntity<List<Despesa>> getAll(){
        List<Despesa> despesas =service.getAll();
        return ResponseEntity.ok(despesas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Despesa> getById(@PathVariable Long id){
        Despesa despesa = service.get(id);
        return ResponseEntity.ok(despesa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Despesa> update(@RequestBody DespesaForm form, @PathVariable Long id){
        Despesa despesa = service.update(id, form);
        return ResponseEntity.ok(despesa);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
