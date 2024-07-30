package com.impa.api.controller;

import com.impa.api.dto.TarefaAtualizacaoDto;
import com.impa.api.dto.TarefaCriadaDto;
import com.impa.api.dto.TarefaDto;
import com.impa.api.model.Tarefa;
import com.impa.api.service.TarefaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService service;

    @GetMapping
    public Page<TarefaDto> listarTodos(@PageableDefault(size = 10) Pageable paginacao) {
        return service.obterTodosDisponiveis(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDto> detalhar(@PathVariable @NotNull Long id) {
        TarefaDto dto = service.obterPorId(id);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/excluidos")
    public Page<TarefaDto> listarExcluidos(@PageableDefault(size = 10) Pageable paginacao) {
        return service.obterTodosExcluidos(paginacao);
    }

    @PostMapping
    public ResponseEntity<TarefaDto> cadastrar(@RequestBody @Valid TarefaCriadaDto dto, UriComponentsBuilder uriBuilder) {
        TarefaDto tarefa = service.criarTarefa(dto);
        URI endereco = uriBuilder.path("/tarefas/{id}").buildAndExpand(tarefa.getId()).toUri();

        return ResponseEntity.created(endereco).body(tarefa);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TarefaDto> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid TarefaAtualizacaoDto dto) {
        TarefaDto atualizado = service.atualizarTarefa (id, dto);
            return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TarefaDto> remover(@PathVariable @NotNull Long id, TarefaDto dto) {
        TarefaDto excluido = service.excluirTarefa (id, dto);
        return ResponseEntity.ok(excluido);

    }
}
