package cn.wewin.backend.modules.system.service.query;

import cn.wewin.backend.modules.system.domain.TestGenerate;
import cn.wewin.common.utils.PageUtil;
import cn.wewin.backend.modules.system.service.dto.TestGenerateDTO;
import cn.wewin.backend.modules.system.repository.TestGenerateRepository;
import cn.wewin.backend.modules.system.service.mapper.TestGenerateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
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
@CacheConfig(cacheNames = "testGenerate")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TestGenerateQueryService {

    @Autowired
    private TestGenerateRepository testGenerateRepository;

    @Autowired
    private TestGenerateMapper testGenerateMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(TestGenerateDTO testGenerate, Pageable pageable){
        Page<TestGenerate> page = testGenerateRepository.findAll(new Spec(testGenerate),pageable);
        return PageUtil.toPage(page.map(testGenerateMapper::toDto));
    }

    /**
    * 不分页
    */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(TestGenerateDTO testGenerate){
        return testGenerateMapper.toDto(testGenerateRepository.findAll(new Spec(testGenerate)));
    }

    class Spec implements Specification<TestGenerate> {

        private TestGenerateDTO testGenerate;

        public Spec(TestGenerateDTO testGenerate){
            this.testGenerate = testGenerate;
        }

        @Override
        public Predicate toPredicate(Root<TestGenerate> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if(!ObjectUtils.isEmpty(testGenerate.getCode())){
                /**
                * 精确
                */
                list.add(cb.equal(root.get("code").as(String.class),testGenerate.getCode()));
            }
            if(!ObjectUtils.isEmpty(testGenerate.getName())){
                /**
                * 模糊
                */
                list.add(cb.like(root.get("name").as(String.class),"%"+testGenerate.getName()+"%"));
            }
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
        }
    }
}