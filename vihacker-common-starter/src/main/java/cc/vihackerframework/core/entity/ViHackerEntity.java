package cc.vihackerframework.core.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础实体类，所有实体需要继承
 *
 * @Description
 * @Author: Ranger
 * @Date: 2021/1/15 11:17
 * @Email: wilton.icp@gmail.com
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public abstract class ViHackerEntity<T> implements Serializable {
    private static final long serialVersionUID = -2012001878851225391L;

    /**
     * 创建者
     */
    @Schema(description = "创建者")
    @TableField(value = "CREATED_BY", fill = FieldFill.INSERT)
    private T createdBy;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @TableField(value = "CREATED_TIME", fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    /**
     * 修改者
     */
    @Schema(description = "修改者")
    @TableField(value = "MODIFY_BY", fill = FieldFill.INSERT_UPDATE)
    private T modifyBy;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    @TableField(value = "MODIFY_TIME", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyTime;

    /**
     * 版本信息
     */
    @Version
    @TableField(value = "VERSION")
    private Long version;

    /**
     * 数据逻辑删除标识字段
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;
}
