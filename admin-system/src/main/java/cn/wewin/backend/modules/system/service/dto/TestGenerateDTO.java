package cn.wewin.backend.modules.system.service.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.io.Serializable;

/**
* @author jession
* @date 2019-05-21
*/
@Data
public class TestGenerateDTO implements Serializable {

    private Integer id;

    /**
     * 代码
     */
    private String code;

    /**
     * 名字
     */
    private String name;

    /**
     * 是否删除
     */
    private Integer flgDeleted;

    /**
     * 金额
     */
    private BigDecimal amount;
}