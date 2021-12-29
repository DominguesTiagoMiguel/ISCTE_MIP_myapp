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
public class TaskPasswordService {

    private final TaskInstanceService taskInstanceService;

    private final UserplanService userplanService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final ImplementationModelRepository implementationModelRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskPasswordMapper taskPasswordMapper;

    private final ImplementationModelMapper implementationModelMapper;

    public TaskPasswordService(
        TaskInstanceService taskInstanceService,
        UserplanService userplanService,
        TaskInstanceRepository taskInstanceRepository,
        ImplementationModelRepository implementationModelRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskPasswordMapper taskPasswordMapper,
        ImplementationModelMapper implementationModelMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.userplanService = userplanService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.implementationModelRepository = implementationModelRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskPasswordMapper = taskPasswordMapper;
        this.implementationModelMapper = implementationModelMapper;
    }

    public TaskPasswordContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        ImplementationModelDTO implementationModel = implementationModelRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskPasswordMapper::toImplementationModelDTO)
            .orElseThrow();

        TaskPasswordContextDTO taskPasswordContext = new TaskPasswordContextDTO();
        taskPasswordContext.setTaskInstance(taskInstanceDTO);
        taskPasswordContext.setImplementationModel(implementationModel);

        return taskPasswordContext;
    }

    public TaskPasswordContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskPasswordContextDTO taskPasswordContext) {
        UserplanDTO userplanDTO = userplanService.findOne(taskPasswordContext.getImplementationModel().getUserplan().getId()).orElseThrow();
        userplanDTO.setPassword(taskPasswordContext.getImplementationModel().getUserplan().getPassword());
        userplanService.save(userplanDTO);
    }

    public void complete(TaskPasswordContextDTO taskPasswordContext) {
        save(taskPasswordContext);
        ImplementationModelDTO implementationModel = implementationModelRepository
            .findByProcessInstanceId(taskPasswordContext.getImplementationModel().getProcessInstance().getId())
            .map(implementationModelMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskPasswordContext.getTaskInstance(), implementationModel);
    }
}
