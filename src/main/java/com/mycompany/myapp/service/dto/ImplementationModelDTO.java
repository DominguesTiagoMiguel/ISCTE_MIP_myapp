package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;
import org.akip.service.dto.ProcessInstanceDTO;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.ImplementationModel} entity.
 */
public class ImplementationModelDTO implements Serializable {

    private Long id;

    private ProcessInstanceDTO processInstance;

    private UserplanDTO userplan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProcessInstanceDTO getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstanceDTO processInstance) {
        this.processInstance = processInstance;
    }

    public UserplanDTO getUserplan() {
        return userplan;
    }

    public void setUserplan(UserplanDTO userplan) {
        this.userplan = userplan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ImplementationModelDTO)) {
            return false;
        }

        ImplementationModelDTO implementationModelDTO = (ImplementationModelDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, implementationModelDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ImplementationModelDTO{" +
            "id=" + getId() +
            ", processInstance=" + getProcessInstance() +
            ", userplan=" + getUserplan() +
            "}";
    }
}
