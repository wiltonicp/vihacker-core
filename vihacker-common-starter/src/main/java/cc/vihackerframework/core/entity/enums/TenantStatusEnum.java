package cc.vihackerframework.core.entity.enums;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 租户状态-枚举
 * Created by Ranger on 2022/6/11.
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "租户状态TenantStatusEnum",description = "租户状态-枚举")
public enum TenantStatusEnum implements EnumMessage{
    //状态 正常 禁用 待审核
    /**
     * NORMAL="正常"
     */
    NORMAL("0","正常"),
    /**
     * FORBIDDEN="禁用"
     */
    FORBIDDEN("1","禁用"),
    /**
     * WAITING="待审核"
     */
    WAITING("2","待审核"),
    /**
     * REFUSE="拒绝"
     */
    REFUSE("3","拒绝"),
    ;

    private String code;
    @Schema(description = "描述")
    private String desc;

    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

    @Override
    public String getValue() {
        return this.name();
    }
}
