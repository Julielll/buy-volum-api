package cn.wewin.backend.modules.business.domain;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author JULIE
* @date 2019-10-09
*/
@Entity
@Data
@Table(name="games")
public class Games implements Serializable {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 客户id
     */
    @Column(name = "customerId",nullable = false)
    private Integer customerid;

    /**
     * appId
     */
    @Column(name = "appId",nullable = false)
    private String appid;

    /**
     * 游戏名称
     */
    @Column(name = "name",nullable = false)
    private String name;

    /**
     * 游戏图标
     */
    @Column(name = "icon",nullable = false)
    private String icon;

    /**
     * 二维码图片地址1
     */
    @Column(name = "qrCodeAddress1")
    private String qrcodeaddress1;

    /**
     * 二维码图片地址2
     */
    @Column(name = "qrCodeAddress2")
    private String qrcodeaddress2;

    /**
     * 跳转路径
     */
    @Column(name = "jumpPath")
    private String jumppath;

    /**
     * 跳转路径的方式 1=直接跳转 2=二维码跳转
     */
    @Column(name = "jumpType")
    private Integer jumptype;

    /**
     * 排序
     */
    @Column(name = "sort")
    private Integer sort;

    /**
     * 上架状态 0=未上架 1=已上架
     */
    @Column(name = "shelfStatus",nullable = false)
    private Integer shelfstatus;

    /**
     * 是否删除
     */
    @Column(name = "isDelete")
    private Integer isdelete;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Timestamp createtime;

    /**
     * 创建者
     */
    @Column(name = "createUserId")
    private Integer createuserid;

    /**
     * 更新时间
     */
    @Column(name = "updateTime")
    private Timestamp updatetime;

    /**
     * 更新者
     */
    @Column(name = "updateUserId")
    private Integer updateuserid;
}
