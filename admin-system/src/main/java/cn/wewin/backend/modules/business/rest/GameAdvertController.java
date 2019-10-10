package cn.wewin.backend.modules.business.rest;

import cn.wewin.backend.modules.business.domain.GameAdvert;
import cn.wewin.backend.modules.business.service.GameAdvertService;
import cn.wewin.backend.modules.business.service.dto.GameAdvertDTO;
import cn.wewin.backend.modules.business.service.query.GameAdvertQueryService;
import cn.wewin.common.exception.BadRequestException;
import cn.wewin.logging.aop.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
* @author JULIE
* @date 2019-10-10
*/
@RestController
@RequestMapping("api")
public class GameAdvertController {

    @Autowired
    private GameAdvertService gameAdvertService;

    @Autowired
    private GameAdvertQueryService gameAdvertQueryService;

    private static final String ENTITY_NAME = "gameAdvert";

    @Log("查询GameAdvert")
    @GetMapping(value = "/gameAdvert")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getGameAdverts(GameAdvertDTO resources, Pageable pageable){
        return new ResponseEntity(gameAdvertQueryService.queryAll(resources,pageable),HttpStatus.OK);
    }

    @Log("新增GameAdvert")
    @PostMapping(value = "/gameAdvert")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody GameAdvert resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity(gameAdvertService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改GameAdvert")
    @PutMapping(value = "/gameAdvert")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody GameAdvert resources){
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME +" ID Can not be empty");
        }
        gameAdvertService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除GameAdvert")
    @DeleteMapping(value = "/gameAdvert/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id){
        gameAdvertService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
