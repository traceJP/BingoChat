package src.main.java.com.tracejp.bingochart.common.utils;

import java.util.Random;
import java.util.UUID;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/6 16:55
 */
public class UUIDUtils {

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static String generateRandomString(int length) {
        StringBuilder randomString = new StringBuilder();
        char[] charList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char randomChar = charList[random.nextInt(charList.length)];
            randomString.append(randomChar);
        }
        return randomString.toString();
    }

    public static String generateRandomNumber(int length) {
        StringBuilder randomString = new StringBuilder();
        char[] charList = "0123456789".toCharArray();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char randomChar = charList[random.nextInt(charList.length)];
            randomString.append(randomChar);
        }
        return randomString.toString();
    }

}
