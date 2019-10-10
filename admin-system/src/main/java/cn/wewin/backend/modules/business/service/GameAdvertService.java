package cn.wewin.backend.modules.business.service;

import cn.wewin.backend.modules.business.domain.GameAdvert;
import cn.wewin.backend.modules.business.service.dto.GameAdvertDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
* @author JULIE
* @date 2019-10-10
*/
@CacheConfig(cacheNames = "gameAdvert")
public interface GameAdvertService {

    /**
     * findById
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    GameAdvertDTO findById(Integer id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    GameAdvertDTO create(GameAdvert resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(GameAdvert resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}