package src.main.java.com.tracejp.bingochart.common.utils;

import java.util.UUID;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/6 16:55
 */
public class UUIDUtil {

    public static final String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
