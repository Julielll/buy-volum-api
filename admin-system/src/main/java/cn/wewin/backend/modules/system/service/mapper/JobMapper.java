package cn.wewin.backend.modules.system.service.mapper;

import cn.wewin.common.mapper.EntityMapper;
import cn.wewin.backend.modules.system.domain.Job;
import cn.wewin.backend.modules.system.service.dto.JobDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author jie
* @date 2019-03-29
*/
@Mapper(componentModel = "spring",uses = {DeptMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobMapper extends EntityMapper<JobDTO, Job> {

}