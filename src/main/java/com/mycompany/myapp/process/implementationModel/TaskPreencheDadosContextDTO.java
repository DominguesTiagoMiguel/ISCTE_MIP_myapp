package com.mycompany.myapp.process.implementationModel;

import com.mycompany.myapp.service.dto.ImplementationModelDTO;
import org.akip.service.dto.TaskInstanceDTO;

public class TaskPreencheDadosContextDTO {

    private ImplementationModelDTO implementationModel;
    private TaskInstanceDTO taskInstance;

    public ImplementationModelDTO getImplementationModel() {
        return implementationModel;
    }

    public void setImplementationModel(ImplementationModelDTO implementationModel) {
        this.implementationModel = implementationModel;
    }

    public TaskInstanceDTO getTaskInstance() {
        return taskInstance;
    }

    public void setTaskInstance(TaskInstanceDTO taskInstance) {
        this.taskInstance = taskInstance;
    }
}
