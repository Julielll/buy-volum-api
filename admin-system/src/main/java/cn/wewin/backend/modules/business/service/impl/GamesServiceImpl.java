package cn.wewin.backend.modules.business.service.impl;

import cn.wewin.backend.modules.business.domain.Games;
import cn.wewin.backend.modules.business.repository.GamesRepository;
import cn.wewin.backend.modules.business.service.GamesService;
import cn.wewin.backend.modules.business.service.dto.GamesDTO;
import cn.wewin.backend.modules.business.service.mapper.GamesMapper;
import cn.wewin.common.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
* @author JULIE
* @date 2019-10-09
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class GamesServiceImpl implements GamesService {

    @Autowired
    private GamesRepository gamesRepository;

    @Autowired
    private GamesMapper gamesMapper;

    @Override
    public GamesDTO findById(Integer id) {
        Optional<Games> games = gamesRepository.findById(id);
        ValidationUtil.isNull(games,"Games","id",id);
        return gamesMapper.toDto(games.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public GamesDTO create(Games resources) {
        return gamesMapper.toDto(gamesRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Games resources) {
        Optional<Games> optionalGames = gamesRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalGames,"Games","id",resources.getId());

        Games games = optionalGames.get();
        // 此处需自己修改
        resources.setId(games.getId());
        gamesRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        gamesRepository.deleteById(id.intValue());
    }
}
