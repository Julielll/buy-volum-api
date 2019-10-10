package cn.wewin.backend.modules.business.service.query;

import cn.wewin.backend.modules.business.domain.GameAdvert;
import cn.wewin.backend.modules.business.service.dto.GameAdvertDTO;
import cn.wewin.backend.modules.business.repository.GameAdvertRepository;
import cn.wewin.backend.modules.business.service.mapper.GameAdvertMapper;
import cn.wewin.common.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jie
 * @date 2018-12-03
 */
@Service
@CacheConfig(cacheNames = "gameAdvert")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class GameAdvertQueryService {

    @Autowired
    private GameAdvertRepository gameAdvertRepository;

    @Autowired
    private GameAdvertMapper gameAdvertMapper;

    /**
     * 分页
     */
    @CacheEvict(keyGenerator = "keyGenerator")
    public Object queryAll(GameAdvertDTO gameAdvert, Pageable pageable){
        Page<GameAdvert> page = gameAdvertRepository.findAll(new Spec(gameAdvert),pageable);
        return PageUtil.toPage(page.map(gameAdvertMapper::toDto));
    }

    /**
    * 不分页
    */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(GameAdvertDTO gameAdvert){
        return gameAdvertMapper.toDto(gameAdvertRepository.findAll(new Spec(gameAdvert)));
    }

    class Spec implements Specification<GameAdvert> {

        private GameAdvertDTO gameAdvert;

        public Spec(GameAdvertDTO gameAdvert){
            this.gameAdvert = gameAdvert;
        }

        @Override
        public Predicate toPredicate(Root<GameAdvert> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
        }
    }
}
