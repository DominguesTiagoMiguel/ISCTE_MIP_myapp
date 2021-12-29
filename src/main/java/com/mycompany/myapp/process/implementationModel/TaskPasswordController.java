package com.mycompany.myapp.process.implementationModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/implementation-model/task-password")
public class TaskPasswordController {

    private final Logger log = LoggerFactory.getLogger(TaskPasswordController.class);

    private final TaskPasswordService taskPasswordService;

    public TaskPasswordController(TaskPasswordService taskPasswordService) {
        this.taskPasswordService = taskPasswordService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskPasswordContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskPasswordContextDTO taskPasswordContext = taskPasswordService.loadContext(id);
        return ResponseEntity.ok(taskPasswordContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskPasswordContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskPasswordContextDTO taskPasswordContext = taskPasswordService.claim(id);
        return ResponseEntity.ok(taskPasswordContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskPasswordContextDTO taskPasswordContext) {
        log.debug("REST request to complete ImplementationModel.TaskPassword {}", taskPasswordContext.getTaskInstance().getId());
        taskPasswordService.complete(taskPasswordContext);
        return ResponseEntity.noContent().build();
    }
}
