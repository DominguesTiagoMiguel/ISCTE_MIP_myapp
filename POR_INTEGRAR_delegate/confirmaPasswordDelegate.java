package com.mycompany.myapp.delegate;

import com.mycompany.myapp.service.dto.ImplementationModelDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class criaUtilizadorDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        ImplementationModelDTO implementationModel = (ImplementationModelDTO) delegateExecution.getVariable("processInstance");
        Boolean confirmaPassword = true;
        if(ImplementationModel.getImplementationModel().getconfirmaPassword()) {
            confirmaPassword = false;

        }
        delegateExecution.setVariable("confirmaPassword", confirmaPassword);

    }


}