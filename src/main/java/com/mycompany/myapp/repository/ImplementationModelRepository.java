package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.ImplementationModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the ImplementationModel entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ImplementationModelRepository extends JpaRepository<ImplementationModel, Long> {
    Optional<ImplementationModel> findByProcessInstanceId(Long processInstanceId);
}
