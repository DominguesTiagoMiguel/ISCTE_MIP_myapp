package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.ImplementationModel;
import com.mycompany.myapp.repository.ImplementationModelRepository;
import com.mycompany.myapp.repository.UserplanRepository;
import com.mycompany.myapp.service.dto.ImplementationModelDTO;
import com.mycompany.myapp.service.mapper.ImplementationModelMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.akip.domain.ProcessInstance;
import org.akip.service.ProcessInstanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link ImplementationModel}.
 */
@Service
@Transactional
public class ImplementationModelService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "ImplementationModel";

    private final Logger log = LoggerFactory.getLogger(ImplementationModelService.class);

    private final ProcessInstanceService processInstanceService;

    private final UserplanRepository userplanRepository;

    private final ImplementationModelRepository implementationModelRepository;

    private final ImplementationModelMapper implementationModelMapper;

    public ImplementationModelService(
        ProcessInstanceService processInstanceService,
        UserplanRepository userplanRepository,
        ImplementationModelRepository implementationModelRepository,
        ImplementationModelMapper implementationModelMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.userplanRepository = userplanRepository;
        this.implementationModelRepository = implementationModelRepository;
        this.implementationModelMapper = implementationModelMapper;
    }

    /**
     * Save a implementationModel.
     *
     * @param implementationModelDTO the entity to save.
     * @return the persisted entity.
     */
    public ImplementationModelDTO create(ImplementationModelDTO implementationModelDTO) {
        log.debug("Request to save ImplementationModel : {}", implementationModelDTO);

        ImplementationModel implementationModel = implementationModelMapper.toEntity(implementationModelDTO);

        //Saving the domainEntity
        userplanRepository.save(implementationModel.getUserplan());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "Userplan#" + implementationModel.getUserplan().getId(),
            implementationModel
        );
        implementationModel.setProcessInstance(processInstance);

        //Saving the process entity
        implementationModel = implementationModelRepository.save(implementationModel);
        return implementationModelMapper.toDto(implementationModel);
    }

    /**
     * Get all the implementationModels.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<ImplementationModelDTO> findAll() {
        log.debug("Request to get all ImplementationModels");
        return implementationModelRepository
            .findAll()
            .stream()
            .map(implementationModelMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one implementationModel by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ImplementationModelDTO> findOne(Long id) {
        log.debug("Request to get ImplementationModel : {}", id);
        return implementationModelRepository.findById(id).map(implementationModelMapper::toDto);
    }

    /**
     * Get one implementationModel by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ImplementationModelDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get ImplementationModel by  processInstanceId: {}", processInstanceId);
        return implementationModelRepository.findByProcessInstanceId(processInstanceId).map(implementationModelMapper::toDto);
    }
}
