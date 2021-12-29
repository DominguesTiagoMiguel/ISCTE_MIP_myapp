package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Userplan;
import com.mycompany.myapp.repository.UserplanRepository;
import com.mycompany.myapp.service.dto.UserplanDTO;
import com.mycompany.myapp.service.mapper.UserplanMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Userplan}.
 */
@Service
@Transactional
public class UserplanService {

    private final Logger log = LoggerFactory.getLogger(UserplanService.class);

    private final UserplanRepository userplanRepository;

    private final UserplanMapper userplanMapper;

    public UserplanService(UserplanRepository userplanRepository, UserplanMapper userplanMapper) {
        this.userplanRepository = userplanRepository;
        this.userplanMapper = userplanMapper;
    }

    /**
     * Save a userplan.
     *
     * @param userplanDTO the entity to save.
     * @return the persisted entity.
     */
    public UserplanDTO save(UserplanDTO userplanDTO) {
        log.debug("Request to save Userplan : {}", userplanDTO);
        Userplan userplan = userplanMapper.toEntity(userplanDTO);
        userplan = userplanRepository.save(userplan);
        return userplanMapper.toDto(userplan);
    }

    /**
     * Partially update a userplan.
     *
     * @param userplanDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<UserplanDTO> partialUpdate(UserplanDTO userplanDTO) {
        log.debug("Request to partially update Userplan : {}", userplanDTO);

        return userplanRepository
            .findById(userplanDTO.getId())
            .map(
                existingUserplan -> {
                    userplanMapper.partialUpdate(existingUserplan, userplanDTO);
                    return existingUserplan;
                }
            )
            .map(userplanRepository::save)
            .map(userplanMapper::toDto);
    }

    /**
     * Get all the userplans.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<UserplanDTO> findAll() {
        log.debug("Request to get all Userplans");
        return userplanRepository.findAll().stream().map(userplanMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one userplan by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<UserplanDTO> findOne(Long id) {
        log.debug("Request to get Userplan : {}", id);
        return userplanRepository.findById(id).map(userplanMapper::toDto);
    }

    /**
     * Delete the userplan by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Userplan : {}", id);
        userplanRepository.deleteById(id);
    }
}
