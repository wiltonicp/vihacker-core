package cc.vihackerframework.core.entity.enums;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 企业类型-枚举
 * Created by Ranger on 2022/6/11.
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "企业类型TenantTypeEnum",description = "企业类型类型-枚举")
public enum TenantTypeEnum implements EnumMessage{
    /**
     * CREATE="创建"
     */
    CREATE("创建"),
    /**
     * REGISTER="注册"
     */
    REGISTER("注册");

    @Schema(description = "描述")
    private String desc;

    @Override
    public String getDesc() {
        return this.desc;
    }

    @Override
    @Schema(description = "编码", allowableValues = "CREATE,REGISTER",example = "CREATE")
    public String getValue() {
        return this.name();
    }
}
