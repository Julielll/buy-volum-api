package cn.wewin.backend.modules.business.service;

import cn.wewin.backend.modules.business.domain.Games;
import cn.wewin.backend.modules.business.service.dto.GamesDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
* @author JULIE
* @date 2019-10-09
*/
@CacheConfig(cacheNames = "games")
public interface GamesService {

    /**
     * findById
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    GamesDTO findById(Integer id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    GamesDTO create(Games resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(Games resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}