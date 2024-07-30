**Endpoints**

**GET /tarefas (Listagem tarefas disponiveis)**
Exemplo Abaixo:

{
            "id": 1,
            "dataCriacao": "2024-07-29",
            "dataExclusao": null,
            "dataAtualizacao": null,
            "nomeTarefa": "Teste2",
            "status": "BACKLOG"
        }
**
GET /tarefas/exluidos ( Listagem de tarefas excluidas**
Exemplo abaixo:

 {
            "id": 2,
            "dataCriacao": null,
            "dataExclusao": "2024-07-29",
            "dataAtualizacao": null,
            "nomeTarefa": "Teste2",
            "status": "EXCLUIDO"
        }

**GET /tarefas/{id} (Listagem por id ex: tarefas/1)**
Exemplo Abaixo:

{
            "id": 1,
            "dataCriacao": "2024-07-29",
            "dataExclusao": null,
            "dataAtualizacao": null,
            "nomeTarefa": "Teste2",
            "status": "BACKLOG"
        }
        
        
**POST /tarefas (criação da Tarefa)**
Dados para serem passados:

{
    "nomeTarefa": "Teste6"
}

Resultado Abaixo:
{
    "id": 6,
    "dataCriacao": "2024-07-29",
    "dataExclusao": null,
    "dataAtualizacao": null,
    "nomeTarefa": "Teste6",
    "status": "BACKLOG"
}

**PUT /tarefas/{id} (atualização da Tarefa Ex: tarefas/6 )**
Dados para serem passados:

{
    "nomeTarefa": "Teste6",
    "status": "ANDAMENTO"
}
Resultado Abaixo:

{
    "id": 6,
    "dataCriacao": "2024-07-29",
    "dataExclusao": null,
    "dataAtualizacao": "2024-07-29",
    "nomeTarefa": "Teste6",
    "status": "BACKLOG"
}

**DELETE /tarefas/{id} (Exclusão da tarefa Ex: tarefas/6)**
Resultado abaixo:

{
    "id": 6,
    "dataCriacao": "2024-07-29",
    "dataExclusao": "2024-07-29",
    "dataAtualizacao": "2024-07-29",
    "nomeTarefa": "Teste2",
    "status": "EXCLUIDO"
}


**ENUMS DISPONIVEIS**

    BACKLOG,
    ANDAMENTO,
    CONCLUIDO,
    EXCLUIDO


