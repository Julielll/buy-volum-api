package cn.wewin.backend.modules.system.service.mapper;

import cn.wewin.backend.modules.system.domain.User;
import cn.wewin.common.mapper.EntityMapper;
import cn.wewin.backend.modules.system.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author jie
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring",uses = {RoleMapper.class, DeptMapper.class, JobMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends EntityMapper<UserDTO, User> {

}
