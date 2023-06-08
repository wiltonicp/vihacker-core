package cc.vihackerframework.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Ranger
 * @email wilton.icp@gmail.com
 * @since 2021/3/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentUser implements Serializable {

    private static long serialVersionUID = 761748087824726463L;

    /**
     * 用户id
     */
    @Schema(hidden = true)
    private Long userId;
    /**
     * 账号
     */
    @Schema(hidden = true)
    private String account;
    /**
     * 昵称
     */
    @Schema(hidden = true)
    private String nickName;
    /**
     * 租户ID
     */
    @Schema(hidden = true)
    private String tenantId;
    /**
     * 部门id
     */
    @Schema(hidden = true)
    private String deptId;
    /**
     * 岗位id
     */
    @Schema(hidden = true)
    private String postId;
    /**
     * 角色id
     */
    @Schema(hidden = true)
    private String roleId;

    /**
     * 角色编码
     */
    @Schema(hidden = true)
    private String roleCode;

    /**
     * 角色名
     */
    @Schema(hidden = true)
    private String roleName;

    /**
     * 登录类型
     */
    @Schema(hidden = true)
    private String type;

    /**
     * 权限集合
     */
    @JsonIgnore
    @Schema(hidden = true)
    private Set<GrantedAuthority> authorities;
}
