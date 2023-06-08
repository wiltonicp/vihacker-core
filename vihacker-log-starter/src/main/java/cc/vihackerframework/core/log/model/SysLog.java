package cc.vihackerframework.core.log.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Ranger on 2023/06/08.
 */
@Data
@Accessors(chain = true)
public class SysLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志ID
     */
    private Long id;

    /**
     * 操作用户
     */
    private String username;

    /**
     * 日志标题
     */
    private String title;

    /**
     * 跟踪ID
     */
    private String traceId;

    /**
     * 请求路径
     */
    private String url;

    /**
     * 操作内容
     */
    private String operation;

    /**
     * 耗时
     */
    private Long time;

    /**
     * 操作方法
     */
    private String method;

    /**
     * 方法参数
     */
    private String params;

    /**
     * 操作者IP
     */
    private String ip;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 操作地点
     */
    private String location;

    /**
     * 详情
     */
    private Object result;

    /**
     * 异常信息
     */
    private String exception;

    private transient String createTimeFrom;
    private transient String createTimeTo;
}
