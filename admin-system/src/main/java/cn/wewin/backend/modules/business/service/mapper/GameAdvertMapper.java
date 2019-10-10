package cn.wewin.backend.modules.business.service.mapper;

import cn.wewin.backend.modules.business.domain.GameAdvert;
import cn.wewin.backend.modules.business.service.dto.GameAdvertDTO;
import cn.wewin.common.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author JULIE
* @date 2019-10-10
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GameAdvertMapper extends EntityMapper<GameAdvertDTO, GameAdvert> {

}
