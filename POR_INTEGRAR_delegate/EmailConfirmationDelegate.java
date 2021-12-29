package com.mycompany.myapp.delegate;

import com.mycompany.myapp.service.MailService;
import com.mycompany.myapp.service.dto.UserPlanDTO;
import com.mycompany.myapp.service.dto.ImplementationModelDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.Locale;

@Component
public class EmailConfirmationDelegate implements JavaDelegate {

    @Autowired
    MailService mailService;

    @Autowired
    SpringTemplateEngine templateEngine;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        implementationModelDTO implementationModel = (ImplementationModelDTO) delegateExecution.getVariable("processInstance");
        UserlPlanDTO userPlan = implementationModel.getUserplan();
        String to = userPlan.getEmail();
        String subject = "Confirmamos o seu acesso" + userPlan.getFirstName() + userPlan.getLastName();
        Context context = new Context(Locale.getDefault());
        context.setVariable("userPlan", userPlan);
        String content = templateEngine.process("ImplementationModel/userPlanSummaryEmail", context);
        mailService.sendEmail(to, subject, content, false, true);
    }
}