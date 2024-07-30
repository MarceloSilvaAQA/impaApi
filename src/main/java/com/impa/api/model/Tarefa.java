package com.impa.api.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tarefas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa  extends  Util{

    @NotNull
    @NotBlank
    private String nomeTarefa;

    private EnumStatus status;

}
