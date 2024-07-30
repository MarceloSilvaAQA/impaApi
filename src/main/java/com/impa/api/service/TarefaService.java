package com.impa.api.service;

import com.impa.api.dto.TarefaAtualizacaoDto;
import com.impa.api.dto.TarefaCriadaDto;
import com.impa.api.dto.TarefaDto;
import com.impa.api.model.EnumStatus;
import com.impa.api.model.Tarefa;
import com.impa.api.repository.TarefasRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

@Service
public class TarefaService {

    @Autowired
    private TarefasRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public Page<TarefaDto> obterTodosDisponiveis(Pageable paginacao) {
        return repository
                .findByDataExclusaoIsNull(paginacao)
                .map(p -> modelMapper.map(p, TarefaDto.class));
    }

    public Page<TarefaDto> obterTodosExcluidos(Pageable paginacao) {
        return repository
                .findByDataExclusaoIsNotNullAndStatus(paginacao, EnumStatus.EXCLUIDO)
                .map(p -> modelMapper.map(p, TarefaDto.class));
    }

    public TarefaDto obterPorId(Long id) {
        Tarefa tarefa = repository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        return modelMapper.map(tarefa, TarefaDto.class);
    }

    public TarefaDto criarTarefa(TarefaCriadaDto dto) {
        Tarefa tarefa = modelMapper.map(dto, Tarefa.class);
        tarefa.setDataCriacao(LocalDate.now());
        tarefa.setStatus(EnumStatus.BACKLOG);
        repository.save(tarefa);

        return modelMapper.map(tarefa, TarefaDto.class);
    }

    public TarefaDto atualizarTarefa(Long id, @RequestBody @Valid TarefaAtualizacaoDto dto) {
        Tarefa tarefa = repository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        modelMapper.map(dto, tarefa);
        tarefa.setId(id);
        tarefa.setDataExclusao(null);
        tarefa.setStatus(dto.getStatus());
        tarefa.setDataAtualizacao(LocalDate.now());
        Tarefa tarefaAtualizada = repository.save(tarefa);
        return modelMapper.map(tarefaAtualizada, TarefaDto.class);
    }

    public TarefaDto excluirTarefa(Long id, TarefaDto dto) {
        Tarefa tarefa = repository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        if (tarefa.getDataExclusao() != null) {
            throw new RuntimeException("Tarefa já excluída");
        }
        modelMapper.map(id, dto);
        tarefa.setId(id);
        tarefa.setDataExclusao(LocalDate.now());
        tarefa.setStatus(EnumStatus.EXCLUIDO);
        tarefa = repository.save(tarefa);
        return modelMapper.map(tarefa, TarefaDto.class);
    }
}
