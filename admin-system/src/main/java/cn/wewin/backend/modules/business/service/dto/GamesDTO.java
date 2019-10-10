package cn.wewin.backend.modules.business.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author JULIE
* @date 2019-10-09
*/
@Data
public class GamesDTO implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * 客户id
     */
    private Integer customerid;

    /**
     * appId
     */
    private String appid;

    /**
     * 游戏名称
     */
    private String name;

    /**
     * 游戏图标
     */
    private String icon;

    /**
     * 二维码图片地址1
     */
    private String qrcodeaddress1;

    /**
     * 二维码图片地址2
     */
    private String qrcodeaddress2;

    /**
     * 跳转路径
     */
    private String jumppath;

    /**
     * 跳转路径的方式 1=直接跳转 2=二维码跳转
     */
    private Integer jumptype;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 上架状态 0=未上架 1=已上架
     */
    private Integer shelfstatus;

    /**
     * 是否删除
     */
    private Integer isdelete;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Timestamp createtime;

    /**
     * 创建者
     */
    private Integer createuserid;

    /**
     * 更新时间
     */
    private Timestamp updatetime;

    /**
     * 更新者
     */
    private Integer updateuserid;
}
