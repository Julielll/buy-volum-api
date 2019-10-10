package cn.wewin.backend.modules.system.service.mapper;

import cn.wewin.common.mapper.EntityMapper;
import cn.wewin.backend.modules.system.domain.Dict;
import cn.wewin.backend.modules.system.service.dto.DictDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author jie
* @date 2019-04-10
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictMapper extends EntityMapper<DictDTO, Dict> {

}