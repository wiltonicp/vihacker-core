package cc.vihackerframework.core.log.feign.fallback;

import cc.vihackerframework.core.api.ViHackerApiResult;
import cc.vihackerframework.core.log.feign.ISysLogProvider;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Ranger on 2022/3/6
 */
@Slf4j
//@Component
public class RemoteSysLogProviderFallback {
    public ISysLogProvider create(Throwable throwable) {
        return sysLog -> ViHackerApiResult.failed("调用失败");

    }
}
