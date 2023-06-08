package cc.vihackerframework.core.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.lionsoul.ip2region.xdb.Searcher;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 根据 IP获取地址
 * @author Ranger
 * @since 2021/5/20
 * @email wilton.icp@gmail.com
 */
@Slf4j
public abstract class AddressUtil {

    public static void main(String[] args) {
        System.out.println(AddressUtil.getCityInfo("183.247.152.98"));
    }

    public static String getCityInfo(String ip) {
        Searcher searcher = null;
        try {
            String dbPath = AddressUtil.class.getResource("/ip2region/ip2region.xdb").getPath();
            File file = new File(dbPath);
            if (!file.exists()) {
                String tmpDir = System.getProperties().getProperty("java.io.tmpdir");
                dbPath = tmpDir + "ip.xdb";
                file = new File(dbPath);
                InputStream resourceAsStream = AddressUtil.class.getClassLoader().getResourceAsStream("classpath:ip2region/ip2region.xdb");
                if (resourceAsStream != null) {
                    FileUtils.copyInputStreamToFile(resourceAsStream, file);
                }
            }
            searcher = Searcher.newWithFileOnly(file.getPath());
            return searcher.search(ip);
        } catch (Exception e) {
            log.warn("获取地址信息异常,{}", e.getMessage());
            return StringUtils.EMPTY;
        } finally {
            if (searcher != null) {
                try {
                    searcher.close();
                } catch (IOException e) {
                    log.error("ip2region searcher close error", e);
                }
            }
        }
    }
}