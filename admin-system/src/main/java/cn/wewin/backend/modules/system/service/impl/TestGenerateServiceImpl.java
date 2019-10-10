package cn.wewin.backend.modules.system.service.impl;

import cn.wewin.backend.modules.system.domain.TestGenerate;
import cn.wewin.backend.modules.system.repository.TestGenerateRepository;
import cn.wewin.backend.modules.system.service.TestGenerateService;
import cn.wewin.backend.modules.system.service.mapper.TestGenerateMapper;
import cn.wewin.common.utils.ValidationUtil;
import cn.wewin.backend.modules.system.service.dto.TestGenerateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
* @author jession
* @date 2019-05-21
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TestGenerateServiceImpl implements TestGenerateService {

    @Autowired
    private TestGenerateRepository testGenerateRepository;

    @Autowired
    private TestGenerateMapper testGenerateMapper;

    @Override
    public TestGenerateDTO findById(Long id) {
        Optional<TestGenerate> testGenerate = testGenerateRepository.findById(id);
        ValidationUtil.isNull(testGenerate,"TestGenerate","id",id);
        return testGenerateMapper.toDto(testGenerate.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TestGenerateDTO create(TestGenerate resources) {
        return testGenerateMapper.toDto(testGenerateRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TestGenerate resources) {
        Optional<TestGenerate> optionalTestGenerate = testGenerateRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalTestGenerate,"TestGenerate","id",resources.getId());

        TestGenerate testGenerate = optionalTestGenerate.get();
        // 此处需自己修改
        resources.setId(testGenerate.getId());
        testGenerateRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        testGenerateRepository.deleteById(id);
    }
}