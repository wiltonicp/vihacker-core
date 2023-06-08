package cc.vihackerframework.core.log.feign;

import cc.vihackerframework.core.api.ViHackerApiResult;
import cc.vihackerframework.core.log.model.SysLog;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 调用vihacker-system存储日志
 *
 * Created by Ranger on 2022/2/20
 */
public interface ISysLogProvider {

    /**
     * 日志打包保存
     * @param sysLog
     * @return
     */
    @PostMapping("provider/log/set")
    ViHackerApiResult saveLog(@RequestBody SysLog sysLog);
}
