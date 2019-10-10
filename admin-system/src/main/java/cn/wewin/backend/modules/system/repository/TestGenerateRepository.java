package cn.wewin.backend.modules.system.repository;

import cn.wewin.backend.modules.system.domain.TestGenerate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author jession
* @date 2019-05-21
*/
public interface TestGenerateRepository extends JpaRepository<TestGenerate, Long>, JpaSpecificationExecutor {
}