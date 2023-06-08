package cc.vihackerframework.core.auth.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 *
 * @author Ranger
 * @email wilton.icp@gmail.com
 * @since 2021/8/11
 */
@Data
@ConfigurationProperties(ViHackerUaaProperties.PREFIX)
public class ViHackerUaaProperties {

    /**
     * 前缀
     */
    public static final String PREFIX = "vihacker.uaa";

    /**
     * 是否启用token 验证
     */
    private Boolean enable = false;
}
