package com.impa.api.dto;

import com.impa.api.model.EnumStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TarefaAtualizacaoDto {

    private String nomeTarefa;

    private EnumStatus status;
}
