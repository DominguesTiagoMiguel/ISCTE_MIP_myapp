package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Userplan;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Userplan entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserplanRepository extends JpaRepository<Userplan, Long> {}
