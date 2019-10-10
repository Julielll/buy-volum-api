package cn.wewin.backend.modules.system.rest;

import cn.wewin.logging.aop.log.Log;
import cn.wewin.common.exception.BadRequestException;
import cn.wewin.backend.modules.system.domain.TestGenerate;
import cn.wewin.backend.modules.system.service.TestGenerateService;
import cn.wewin.backend.modules.system.service.dto.TestGenerateDTO;
import cn.wewin.backend.modules.system.service.query.TestGenerateQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
* @author jession
* @date 2019-05-21
*/
@RestController
@RequestMapping("api")
public class TestGenerateController {

    @Autowired
    private TestGenerateService testGenerateService;

    @Autowired
    private TestGenerateQueryService testGenerateQueryService;

    private static final String ENTITY_NAME = "testGenerate";

    @Log("查询TestGenerate")
    @GetMapping(value = "/testGenerate")
    @PreAuthorize("hasAnyRole('ADMIN','TEST_GENERATE_LIST')")
    public ResponseEntity getTestGenerates(TestGenerateDTO resources, Pageable pageable){
        return new ResponseEntity(testGenerateQueryService.queryAll(resources,pageable),HttpStatus.OK);
    }

    @Log("新增TestGenerate")
    @PostMapping(value = "/testGenerate")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody TestGenerate resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity(testGenerateService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改TestGenerate")
    @PutMapping(value = "/testGenerate")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody TestGenerate resources){
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME +" ID Can not be empty");
        }
        testGenerateService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除TestGenerate")
    @DeleteMapping(value = "/testGenerate/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id){
        testGenerateService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}