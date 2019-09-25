package cn.wewin.backend.modules.system.service.mapper;

import cn.wewin.backend.modules.system.domain.Menu;
import cn.wewin.common.mapper.EntityMapper;
import cn.wewin.backend.modules.system.service.dto.MenuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author jie
 * @date 2018-12-17
 */
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper extends EntityMapper<MenuDTO, Menu> {

}
