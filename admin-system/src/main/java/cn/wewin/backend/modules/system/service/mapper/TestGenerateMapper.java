package cn.wewin.backend.modules.system.service.mapper;

import cn.wewin.backend.modules.system.domain.TestGenerate;
import cn.wewin.common.mapper.EntityMapper;
import cn.wewin.backend.modules.system.service.dto.TestGenerateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author jession
* @date 2019-05-21
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TestGenerateMapper extends EntityMapper<TestGenerateDTO, TestGenerate> {

}