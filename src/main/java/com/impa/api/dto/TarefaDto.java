package com.impa.api.dto;

import com.impa.api.model.EnumStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class TarefaDto {

    private Long id;

    private LocalDate dataCriacao;

    private LocalDate dataExclusao;

    private LocalDate dataAtualizacao;

    private String nomeTarefa;

    private EnumStatus status;
}
