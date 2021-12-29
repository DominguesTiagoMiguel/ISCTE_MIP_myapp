package com.mycompany.myapp.process.implementationModel;

import com.mycompany.myapp.domain.ImplementationModel;
import com.mycompany.myapp.domain.Userplan;
import com.mycompany.myapp.service.dto.ImplementationModelDTO;
import com.mycompany.myapp.service.dto.UserplanDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class })
public interface TaskPasswordMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    ImplementationModelDTO toImplementationModelDTO(ImplementationModel implementationModel);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "password", source = "password")
    UserplanDTO toUserplanDTO(Userplan userplan);
}
