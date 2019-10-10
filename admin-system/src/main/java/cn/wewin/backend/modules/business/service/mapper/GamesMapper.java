package cn.wewin.backend.modules.business.service.mapper;

import cn.wewin.common.mapper.EntityMapper;
import cn.wewin.backend.modules.business.domain.Games;
import cn.wewin.backend.modules.business.service.dto.GamesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Repository;

/**
* @author JULIE
* @date 2019-10-09
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Repository
public interface GamesMapper extends EntityMapper<GamesDTO, Games> {

}
