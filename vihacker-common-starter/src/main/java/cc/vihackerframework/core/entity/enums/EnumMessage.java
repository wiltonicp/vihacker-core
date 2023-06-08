package cc.vihackerframework.core.entity.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

import java.io.Serializable;

/**
 * <p> 通用枚举
 *
 * @author Ranger
 * @email wilton.icp@gmail.com
 * @since 2021/3/12
 */
public interface EnumMessage<T extends Serializable> extends IEnum<T> {

    /**
     * 编码
     * @return
     */
    default T getCode(){return (T) toString();};

    /**
     * 描述
     * @return
     */
    String getDesc();

    /**
     * 枚举值
     * @return 数据库中的值
     */
    @Override
    default T getValue() {
        return getCode();
    }
}
