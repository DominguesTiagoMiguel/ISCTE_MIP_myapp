package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.ImplementationModelDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ImplementationModel} and its DTO {@link ImplementationModelDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class, UserplanMapper.class })
public interface ImplementationModelMapper extends EntityMapper<ImplementationModelDTO, ImplementationModel> {
    @Mapping(target = "processInstance", source = "processInstance")
    @Mapping(target = "userplan", source = "userplan")
    ImplementationModelDTO toDto(ImplementationModel s);
}
