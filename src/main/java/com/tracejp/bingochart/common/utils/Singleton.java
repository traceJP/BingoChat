package src.main.java.com.tracejp.bingochart.common.utils;

/**
 * <p> 单例工具 注意：此单例返回值为序列化的结果，不允许修改对象 ; 全局对象请使用 Rope <p/>
 *
 * @author traceJP
 * @since 2023/5/7 10:53
 */
public class Singleton<T extends Singleton<T>> {

    private static Singleton<?> instance;

    protected Singleton() {
        // 初始化
    }

    public static <T extends Singleton<T>> T getInstance(Class<T> type) {
        if (instance == null || !instance.getClass().equals(type)) {
            try {
                instance = type.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException("创建单例失败，可能原因是类型转换错误");
            }
        }
        return type.cast(instance);
    }

}
