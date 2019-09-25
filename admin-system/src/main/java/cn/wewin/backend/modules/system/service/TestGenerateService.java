package cn.wewin.backend.modules.system.service;

import cn.wewin.backend.modules.system.domain.TestGenerate;
import cn.wewin.backend.modules.system.service.dto.TestGenerateDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
* @author jession
* @date 2019-05-21
*/
@CacheConfig(cacheNames = "testGenerate")
public interface TestGenerateService {

    /**
     * findById
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    TestGenerateDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    TestGenerateDTO create(TestGenerate resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(TestGenerate resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}