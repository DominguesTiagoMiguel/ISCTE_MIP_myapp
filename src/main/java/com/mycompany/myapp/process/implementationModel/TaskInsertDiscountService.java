package com.mycompany.myapp.process.implementationModel;

import com.mycompany.myapp.repository.ImplementationModelRepository;
import com.mycompany.myapp.service.UserplanService;
import com.mycompany.myapp.service.dto.ImplementationModelDTO;
import com.mycompany.myapp.service.dto.UserplanDTO;
import com.mycompany.myapp.service.mapper.ImplementationModelMapper;
import org.akip.repository.TaskInstanceRepository;
import org.akip.service.TaskInstanceService;
import org.akip.service.dto.TaskInstanceDTO;
import org.akip.service.mapper.TaskInstanceMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskInsertDiscountService {

    private final TaskInstanceService taskInstanceService;

    private final UserplanService userplanService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final ImplementationModelRepository implementationModelRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskInsertDiscountMapper taskInsertDiscountMapper;

    private final ImplementationModelMapper implementationModelMapper;

    public TaskInsertDiscountService(
        TaskInstanceService taskInstanceService,
        UserplanService userplanService,
        TaskInstanceRepository taskInstanceRepository,
        ImplementationModelRepository implementationModelRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskInsertDiscountMapper taskInsertDiscountMapper,
        ImplementationModelMapper implementationModelMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.userplanService = userplanService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.implementationModelRepository = implementationModelRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskInsertDiscountMapper = taskInsertDiscountMapper;
        this.implementationModelMapper = implementationModelMapper;
    }

    public TaskInsertDiscountContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        ImplementationModelDTO implementationModel = implementationModelRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskInsertDiscountMapper::toImplementationModelDTO)
            .orElseThrow();

        TaskInsertDiscountContextDTO taskInsertDiscountContext = new TaskInsertDiscountContextDTO();
        taskInsertDiscountContext.setTaskInstance(taskInstanceDTO);
        taskInsertDiscountContext.setImplementationModel(implementationModel);

        return taskInsertDiscountContext;
    }

    public TaskInsertDiscountContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskInsertDiscountContextDTO taskInsertDiscountContext) {
        UserplanDTO userplanDTO = userplanService
            .findOne(taskInsertDiscountContext.getImplementationModel().getUserplan().getId())
            .orElseThrow();
        userplanDTO.setDiscountCode(taskInsertDiscountContext.getImplementationModel().getUserplan().getDiscountCode());
        userplanService.save(userplanDTO);
    }

    public void complete(TaskInsertDiscountContextDTO taskInsertDiscountContext) {
        save(taskInsertDiscountContext);
        ImplementationModelDTO implementationModel = implementationModelRepository
            .findByProcessInstanceId(taskInsertDiscountContext.getImplementationModel().getProcessInstance().getId())
            .map(implementationModelMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskInsertDiscountContext.getTaskInstance(), implementationModel);
    }
}
