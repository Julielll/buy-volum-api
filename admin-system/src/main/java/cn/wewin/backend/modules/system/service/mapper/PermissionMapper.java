package cn.wewin.backend.modules.system.service.mapper;

import cn.wewin.backend.modules.system.domain.Permission;
import cn.wewin.common.mapper.EntityMapper;
import cn.wewin.backend.modules.system.service.dto.PermissionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author jie
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissionMapper extends EntityMapper<PermissionDTO, Permission> {

}
