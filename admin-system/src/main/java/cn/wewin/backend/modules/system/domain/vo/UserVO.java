package cn.wewin.backend.modules.system.domain.vo;

import lombok.Data;

/**
 * <h1>UserVO</h1>
 * </br>
 *
 * @author Julie
 * @date 2019/10/13
 */
@Data
public class UserVO {
    /**
     * 旧密码
     */
    private String oldPass;
    /**
     * 新密码
     */
    private String newPass;
}
