package com.mycompany.myapp.delegate;

import com.mycompany.myapp.service.dto.ImplementationModelDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class confirmarCodigoDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        ImplementationModelDTO implementationModel = (ImplementationModelDTO) delegateExecution.getVariable("processInstance");
        Boolean confirmaCodigo = true;
        if(ImplementationModel.getImplementationModel().getconfirmaCodigo()) {
            confirmaCodigo = false;

        }
        delegateExecution.setVariable("confirmaCodigo", confirmaCodigo);

    }


}