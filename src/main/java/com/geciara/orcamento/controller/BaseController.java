package com.geciara.orcamento.controller;

import com.geciara.orcamento.model.services.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<T, S extends BaseService<T>> {

    protected final S service;

    public BaseController(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<T>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<T> save(@RequestBody T entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody T updatedEntity) {
        boolean updated = service.update(id, updatedEntity);
        if (updated) {
            return ResponseEntity.ok("item atualizado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item não encontrado");
        }


    }

}
