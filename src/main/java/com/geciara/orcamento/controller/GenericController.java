package com.geciara.orcamento.controller;

import com.geciara.orcamento.services.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public abstract class GenericController<T, S extends BaseService<T>> {

    protected final S service;

    public GenericController(S service) {
        this.service = service;
    }

    @Operation(
            summary = "Listar todos os registros",
            description = "Recupera todos os registros do tipo especificado",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de registros recuperada com sucesso",
                            content = @Content(
                                    schema = @Schema(implementation = List.class)
                            )
                    )
            }
    )
    @SecurityRequirement(name = "BearerAuth")
    @GetMapping
    public ResponseEntity<List<T>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @Operation(
            summary = "Buscar registro por ID",
            description = "Recupera um registro específico pelo seu identificador",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro encontrado com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Registro não encontrado"
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<T> findById(
            @Parameter(description = "ID do registro a ser buscado", required = true)
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Operation(
            summary = "Criar novo registro",
            description = "Cria um novo registro do tipo especificado",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Registro criado com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Dados inválidos para criação"
                    )
            }
    )
    @PostMapping
    public ResponseEntity<T> save(
            @Parameter(description = "Dados do registro a ser criado", required = true)
            @RequestBody T entity) {
        T savedEntity = service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @Operation(
            summary = "Excluir registro",
            description = "Remove um registro específico pelo seu identificador",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Registro excluído com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Registro não encontrado"
                    )
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID do registro a ser excluído", required = true)
            @PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Atualizar registro",
            description = "Atualiza um registro existente pelo seu identificador",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro atualizado com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Registro não encontrado"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Dados inválidos para atualização"
                    )
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<T> update(
            @Parameter(description = "ID do registro a ser atualizado", required = true)
            @PathVariable Long id,
            @Parameter(description = "Dados atualizados do registro", required = true)
            @RequestBody T entity) {
        T updatedEntity = service.update(id, entity);
        return ResponseEntity.ok(updatedEntity);

    }

}
