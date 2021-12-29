package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.UserplanDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Userplan} and its DTO {@link UserplanDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserplanMapper extends EntityMapper<UserplanDTO, Userplan> {}
