package com.mycompany.myapp.process.implementationModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/implementation-model/task-insert-discount")
public class TaskInsertDiscountController {

    private final Logger log = LoggerFactory.getLogger(TaskInsertDiscountController.class);

    private final TaskInsertDiscountService taskInsertDiscountService;

    public TaskInsertDiscountController(TaskInsertDiscountService taskInsertDiscountService) {
        this.taskInsertDiscountService = taskInsertDiscountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskInsertDiscountContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskInsertDiscountContextDTO taskInsertDiscountContext = taskInsertDiscountService.loadContext(id);
        return ResponseEntity.ok(taskInsertDiscountContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskInsertDiscountContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskInsertDiscountContextDTO taskInsertDiscountContext = taskInsertDiscountService.claim(id);
        return ResponseEntity.ok(taskInsertDiscountContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskInsertDiscountContextDTO taskInsertDiscountContext) {
        log.debug(
            "REST request to complete ImplementationModel.TaskInsertDiscount {}",
            taskInsertDiscountContext.getTaskInstance().getId()
        );
        taskInsertDiscountService.complete(taskInsertDiscountContext);
        return ResponseEntity.noContent().build();
    }
}
