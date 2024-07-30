package com.impa.api.dto;

import com.impa.api.model.EnumStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarefaCriadaDto {

    private String nomeTarefa;
    private EnumStatus status;
}
