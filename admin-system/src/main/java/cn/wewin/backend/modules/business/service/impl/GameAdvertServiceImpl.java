package cn.wewin.backend.modules.business.service.impl;

import cn.wewin.backend.modules.business.domain.GameAdvert;
import cn.wewin.backend.modules.business.repository.GameAdvertRepository;
import cn.wewin.backend.modules.business.service.GameAdvertService;
import cn.wewin.backend.modules.business.service.dto.GameAdvertDTO;
import cn.wewin.backend.modules.business.service.mapper.GameAdvertMapper;
import cn.wewin.common.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
* @author JULIE
* @date 2019-10-10
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class GameAdvertServiceImpl implements GameAdvertService {

    @Autowired
    private GameAdvertRepository gameAdvertRepository;

    @Autowired
    private GameAdvertMapper gameAdvertMapper;

    @Override
    public GameAdvertDTO findById(Integer id) {
        Optional<GameAdvert> gameAdvert = gameAdvertRepository.findById(id);
        ValidationUtil.isNull(gameAdvert,"GameAdvert","id",id);
        return gameAdvertMapper.toDto(gameAdvert.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public GameAdvertDTO create(GameAdvert resources) {
        return gameAdvertMapper.toDto(gameAdvertRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(GameAdvert resources) {
        Optional<GameAdvert> optionalGameAdvert = gameAdvertRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalGameAdvert,"GameAdvert","id",resources.getId());

        GameAdvert gameAdvert = optionalGameAdvert.get();
        // 此处需自己修改
        resources.setId(gameAdvert.getId());
        gameAdvertRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        gameAdvertRepository.deleteById(id.intValue());
    }
}
