package com.mycompany.myapp.process.implementationModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/implementation-model/task-preenche-dados")
public class TaskPreencheDadosController {

    private final Logger log = LoggerFactory.getLogger(TaskPreencheDadosController.class);

    private final TaskPreencheDadosService taskPreencheDadosService;

    public TaskPreencheDadosController(TaskPreencheDadosService taskPreencheDadosService) {
        this.taskPreencheDadosService = taskPreencheDadosService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskPreencheDadosContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskPreencheDadosContextDTO taskPreencheDadosContext = taskPreencheDadosService.loadContext(id);
        return ResponseEntity.ok(taskPreencheDadosContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskPreencheDadosContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskPreencheDadosContextDTO taskPreencheDadosContext = taskPreencheDadosService.claim(id);
        return ResponseEntity.ok(taskPreencheDadosContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskPreencheDadosContextDTO taskPreencheDadosContext) {
        log.debug("REST request to complete ImplementationModel.TaskPreencheDados {}", taskPreencheDadosContext.getTaskInstance().getId());
        taskPreencheDadosService.complete(taskPreencheDadosContext);
        return ResponseEntity.noContent().build();
    }
}
