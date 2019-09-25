package cn.wewin.backend.modules.system.service.mapper;

import cn.wewin.common.mapper.EntityMapper;
import cn.wewin.backend.modules.system.domain.DictDetail;
import cn.wewin.backend.modules.system.service.dto.DictDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author jie
* @date 2019-04-10
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictDetailMapper extends EntityMapper<DictDetailDTO, DictDetail> {

}