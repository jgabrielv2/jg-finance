package br.com.jgfinance.controller;

import br.com.jgfinance.entity.Receita;
import br.com.jgfinance.entity.form.ReceitaForm;
import br.com.jgfinance.service.ReceitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    private final ReceitaService service;


    public ReceitaController(ReceitaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Receita> create(@RequestBody ReceitaForm form) {
        Receita receita = service.create(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(receita);
    }

    @GetMapping
    public ResponseEntity<List<Receita>> getAll(){
        List<Receita> receitas =service.getAll();
        return ResponseEntity.ok(receitas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> getById(@PathVariable Long id){
        Receita receita = service.get(id);
        return ResponseEntity.ok(receita);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receita> update(@RequestBody ReceitaForm form, @PathVariable Long id){
        Receita receita = service.update(id, form);
        return ResponseEntity.ok(receita);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }





}
