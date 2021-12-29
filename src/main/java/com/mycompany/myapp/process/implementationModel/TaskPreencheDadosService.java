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
public class TaskPreencheDadosService {

    private final TaskInstanceService taskInstanceService;

    private final UserplanService userplanService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final ImplementationModelRepository implementationModelRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskPreencheDadosMapper taskPreencheDadosMapper;

    private final ImplementationModelMapper implementationModelMapper;

    public TaskPreencheDadosService(
        TaskInstanceService taskInstanceService,
        UserplanService userplanService,
        TaskInstanceRepository taskInstanceRepository,
        ImplementationModelRepository implementationModelRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskPreencheDadosMapper taskPreencheDadosMapper,
        ImplementationModelMapper implementationModelMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.userplanService = userplanService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.implementationModelRepository = implementationModelRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskPreencheDadosMapper = taskPreencheDadosMapper;
        this.implementationModelMapper = implementationModelMapper;
    }

    public TaskPreencheDadosContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        ImplementationModelDTO implementationModel = implementationModelRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskPreencheDadosMapper::toImplementationModelDTO)
            .orElseThrow();

        TaskPreencheDadosContextDTO taskPreencheDadosContext = new TaskPreencheDadosContextDTO();
        taskPreencheDadosContext.setTaskInstance(taskInstanceDTO);
        taskPreencheDadosContext.setImplementationModel(implementationModel);

        return taskPreencheDadosContext;
    }

    public TaskPreencheDadosContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskPreencheDadosContextDTO taskPreencheDadosContext) {
        UserplanDTO userplanDTO = userplanService
            .findOne(taskPreencheDadosContext.getImplementationModel().getUserplan().getId())
            .orElseThrow();
        userplanDTO.setAddress(taskPreencheDadosContext.getImplementationModel().getUserplan().getAddress());
        userplanDTO.setPostalCode(taskPreencheDadosContext.getImplementationModel().getUserplan().getPostalCode());
        userplanDTO.setCity(taskPreencheDadosContext.getImplementationModel().getUserplan().getCity());
        userplanService.save(userplanDTO);
    }

    public void complete(TaskPreencheDadosContextDTO taskPreencheDadosContext) {
        save(taskPreencheDadosContext);
        ImplementationModelDTO implementationModel = implementationModelRepository
            .findByProcessInstanceId(taskPreencheDadosContext.getImplementationModel().getProcessInstance().getId())
            .map(implementationModelMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskPreencheDadosContext.getTaskInstance(), implementationModel);
    }
}
