package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.UserplanRepository;
import com.mycompany.myapp.service.UserplanService;
import com.mycompany.myapp.service.dto.UserplanDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.Userplan}.
 */
@RestController
@RequestMapping("/api")
public class UserplanResource {

    private final Logger log = LoggerFactory.getLogger(UserplanResource.class);

    private final UserplanService userplanService;

    private final UserplanRepository userplanRepository;

    public UserplanResource(UserplanService userplanService, UserplanRepository userplanRepository) {
        this.userplanService = userplanService;
        this.userplanRepository = userplanRepository;
    }

    /**
     * {@code GET  /userplans} : get all the userplans.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of userplans in body.
     */
    @GetMapping("/userplans")
    public List<UserplanDTO> getAllUserplans() {
        log.debug("REST request to get all Userplans");
        return userplanService.findAll();
    }

    /**
     * {@code GET  /userplans/:id} : get the "id" userplan.
     *
     * @param id the id of the userplanDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the userplanDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/userplans/{id}")
    public ResponseEntity<UserplanDTO> getUserplan(@PathVariable Long id) {
        log.debug("REST request to get Userplan : {}", id);
        Optional<UserplanDTO> userplanDTO = userplanService.findOne(id);
        return ResponseUtil.wrapOrNotFound(userplanDTO);
    }
}
