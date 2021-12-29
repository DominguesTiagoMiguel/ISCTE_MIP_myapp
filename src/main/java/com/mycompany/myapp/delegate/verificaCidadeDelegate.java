package com.mycompany.myapp.delegate;

import com.mycompany.myapp.service.dto.ImplementationModelDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class verificaCidadeDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        ImplementationModelDTO implementationModel = (ImplementationModelDTO) delegateExecution.getVariable("processInstance");
        Boolean verificaCidade = implementationModel.getUserplan().getCity().contains("Évora");
        // Boolean verificaCidade = false;
        // if(implementationModel.getUserplan().getCity().contains("Lisboa")) {
        //     verificaCidade = true;

        // }
        delegateExecution.setVariable("verificaCidade", verificaCidade);
    }
}
