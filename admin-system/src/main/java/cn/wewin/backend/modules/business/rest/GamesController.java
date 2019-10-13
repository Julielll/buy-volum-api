package cn.wewin.backend.modules.business.rest;

import cn.wewin.common.exception.BadRequestException;
import cn.wewin.logging.aop.log.Log;
import cn.wewin.backend.modules.business.domain.Games;
import cn.wewin.backend.modules.business.service.GamesService;
import cn.wewin.backend.modules.business.service.dto.GamesDTO;
import cn.wewin.backend.modules.business.service.query.GamesQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author JULIE
 * @date 2019-10-09
 */
@RestController
@RequestMapping("api")
public class GamesController {

    @Autowired
    private GamesService gamesService;

    @Autowired
    private GamesQueryService gamesQueryService;

    private static final String ENTITY_NAME = "games";

    @Log("查询Games")
    @GetMapping(value = "/games")
    @PreAuthorize("hasAnyRole('ADMIN','GAME_ALL','GAME_SELECT')")
    public ResponseEntity getGamess(GamesDTO resources, Pageable pageable) {
        return new ResponseEntity(gamesQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增Games")
    @PostMapping(value = "/games")
    @PreAuthorize("hasAnyRole('ADMIN','GAME_ALL','GAME_CREATE')")
    public ResponseEntity create(@Validated @RequestBody Games resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(gamesService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改Games")
    @PutMapping(value = "/games")
    @PreAuthorize("hasAnyRole('ADMIN','GAME_ALL','GAME_EDIT')")
    public ResponseEntity update(@Validated @RequestBody Games resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        gamesService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除Games")
    @DeleteMapping(value = "/games/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','GAME_ALL','GAME_DELETE')")
    public ResponseEntity delete(@PathVariable Long id) {
        gamesService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
