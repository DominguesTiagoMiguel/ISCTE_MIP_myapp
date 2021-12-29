package com.mycompany.myapp.delegate;

import com.mycompany.myapp.service.MailService;
import com.mycompany.myapp.service.dto.ImplementationModelDTO;
import com.mycompany.myapp.service.dto.UserplanDTO;
import java.util.Locale;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Component
public class MsgEvora implements JavaDelegate {

    @Autowired
    MailService mailService;

    @Autowired
    SpringTemplateEngine templateEngine;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        ImplementationModelDTO implementationModel = (ImplementationModelDTO) delegateExecution.getVariable("processInstance");
        UserplanDTO Userplan = implementationModel.getUserplan();
        String to = Userplan.getEmail();
        String subject = "O serviço apenas está disponível no Alentejo" + Userplan.getFirstName() + Userplan.getLastName();
        Context context = new Context(Locale.getDefault());
        context.setVariable("Userplan", Userplan);
        String content = templateEngine.process("ImplementationModel/userPlanSummaryEmail", context);
        mailService.sendEmail(to, subject, content, false, true);
    }
}
