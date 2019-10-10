package cn.wewin.backend.modules.business.service.query;

import cn.wewin.backend.modules.business.domain.Games;
import cn.wewin.backend.modules.business.service.dto.GamesDTO;
import cn.wewin.backend.modules.business.repository.GamesRepository;
import cn.wewin.backend.modules.business.service.mapper.GamesMapper;
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
@CacheConfig(cacheNames = "games")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class GamesQueryService {

    @Autowired
    private GamesRepository gamesRepository;

    @Autowired
    private GamesMapper gamesMapper;

    /**
     * 分页
     */
    @CacheEvict(keyGenerator = "keyGenerator")
    public Object queryAll(GamesDTO games, Pageable pageable){
        Page<Games> page = gamesRepository.findAll(new Spec(games),pageable);
        return PageUtil.toPage(page.map(gamesMapper::toDto));
    }

    /**
    * 不分页
    */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(GamesDTO games){
        return gamesMapper.toDto(gamesRepository.findAll(new Spec(games)));
    }

    class Spec implements Specification<Games> {

        private GamesDTO games;

        public Spec(GamesDTO games){
            this.games = games;
        }

        @Override
        public Predicate toPredicate(Root<Games> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if(!ObjectUtils.isEmpty(games.getId())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("id").as(Integer.class),games.getId()));
            }
            if(!ObjectUtils.isEmpty(games.getCustomerid())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("customerId").as(Integer.class),games.getCustomerid()));
            }
            if(!ObjectUtils.isEmpty(games.getAppid())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("appId").as(Integer.class),games.getAppid()));
            }
            if(!ObjectUtils.isEmpty(games.getName())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("name").as(String.class),"%"+games.getName()+"%"));
            }
            if(!ObjectUtils.isEmpty(games.getShelfstatus())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("shelfStatus").as(Integer.class),games.getShelfstatus()));
            }
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
        }
    }
}
