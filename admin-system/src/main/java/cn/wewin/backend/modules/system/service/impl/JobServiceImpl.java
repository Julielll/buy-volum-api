package cn.wewin.backend.modules.system.service.impl;

import cn.wewin.backend.modules.system.repository.JobRepository;
import cn.wewin.backend.modules.system.service.mapper.JobMapper;
import cn.wewin.backend.modules.system.domain.Job;
import cn.wewin.common.utils.ValidationUtil;
import cn.wewin.backend.modules.system.service.JobService;
import cn.wewin.backend.modules.system.service.dto.JobDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
* @author jie
* @date 2019-03-29
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobMapper jobMapper;

    @Override
    public JobDTO findById(Long id) {
        Optional<Job> job = jobRepository.findById(id);
        ValidationUtil.isNull(job,"Job","id",id);
        return jobMapper.toDto(job.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JobDTO create(Job resources) {
        return jobMapper.toDto(jobRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Job resources) {
        Optional<Job> optionalJob = jobRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalJob,"Job","id",resources.getId());

        Job job = optionalJob.get();
        // 此处需自己修改
        resources.setId(job.getId());
        jobRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        jobRepository.deleteById(id);
    }
}