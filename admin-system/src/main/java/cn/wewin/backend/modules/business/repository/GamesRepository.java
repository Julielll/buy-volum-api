package cn.wewin.backend.modules.business.repository;

import cn.wewin.backend.modules.business.domain.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author JULIE
* @date 2019-10-09
*/
public interface GamesRepository extends JpaRepository<Games, Integer>, JpaSpecificationExecutor {
}