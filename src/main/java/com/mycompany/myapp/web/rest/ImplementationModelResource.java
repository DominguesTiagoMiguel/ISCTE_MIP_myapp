package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.ImplementationModelService;
import com.mycompany.myapp.service.dto.ImplementationModelDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.ImplementationModel}.
 */
@RestController
@RequestMapping("/api")
public class ImplementationModelResource {

    private final Logger log = LoggerFactory.getLogger(ImplementationModelResource.class);

    private static final String ENTITY_NAME = "implementationModel";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ImplementationModelService implementationModelService;

    public ImplementationModelResource(ImplementationModelService implementationModelService) {
        this.implementationModelService = implementationModelService;
    }

    /**
     * {@code POST  /implementation-models} : Create a new implementationModel.
     *
     * @param implementationModelDTO the implementationModelDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new implementationModelDTO, or with status {@code 400 (Bad Request)} if the implementationModel has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/implementation-models")
    public ResponseEntity<ImplementationModelDTO> create(@RequestBody ImplementationModelDTO implementationModelDTO)
        throws URISyntaxException {
        log.debug("REST request to save ImplementationModel : {}", implementationModelDTO);
        if (implementationModelDTO.getId() != null) {
            throw new BadRequestAlertException("A new implementationModel cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ImplementationModelDTO result = implementationModelService.create(implementationModelDTO);
        return ResponseEntity
            .created(new URI("/api/implementation-models/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /implementation-models} : get all the implementationModels.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of implementationModels in body.
     */
    @GetMapping("/implementation-models")
    public List<ImplementationModelDTO> getAllImplementationModels() {
        log.debug("REST request to get all ImplementationModels");
        return implementationModelService.findAll();
    }

    /**
     * {@code GET  /implementation-models/:id} : get the "id" implementationModel.
     *
     * @param processInstanceId the id of the implementationModelDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the implementationModelDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/implementation-models/{processInstanceId}")
    public ResponseEntity<ImplementationModelDTO> getByProcessInstanceId(@PathVariable Long processInstanceId) {
        log.debug("REST request to get ImplementationModel by processInstanceId : {}", processInstanceId);
        Optional<ImplementationModelDTO> implementationModelDTO = implementationModelService.findByProcessInstanceId(processInstanceId);
        return ResponseUtil.wrapOrNotFound(implementationModelDTO);
    }
}
