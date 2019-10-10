package cn.wewin.backend.modules.business.repository;

import cn.wewin.backend.modules.business.domain.GameAdvert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author JULIE
* @date 2019-10-10
*/
public interface GameAdvertRepository extends JpaRepository<GameAdvert, Integer>, JpaSpecificationExecutor {
}