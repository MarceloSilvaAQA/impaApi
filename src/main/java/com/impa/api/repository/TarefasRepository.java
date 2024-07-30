package com.impa.api.repository;

import com.impa.api.model.EnumStatus;
import com.impa.api.model.Tarefa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefasRepository extends JpaRepository<Tarefa, Long> {

    Page<Tarefa> findByDataExclusaoIsNotNullAndStatus(Pageable pageable, EnumStatus status);
    Page<Tarefa> findByDataExclusaoIsNull(Pageable pageable);

}
