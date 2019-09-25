package cn.wewin.backend.modules.system.domain;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.io.Serializable;

/**
* @author jession
* @date 2019-05-21
*/
@Entity
@Data
@Table(name="test_generate")
public class TestGenerate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 代码
     */
    @Column(name = "code")
    private String code;

    /**
     * 名字
     */
    @Column(name = "name")
    private String name;

    /**
     * 是否删除
     */
    @Column(name = "flg_deleted",nullable = false)
    private Integer flgDeleted;

    /**
     * 金额
     */
    @Column(name = "amount",nullable = false)
    private BigDecimal amount;
}