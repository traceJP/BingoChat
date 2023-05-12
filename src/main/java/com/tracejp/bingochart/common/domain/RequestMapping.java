package src.main.java.com.tracejp.bingochart.common.domain;

/**
 * <p> 服务端消息处理映射 <p/>
 *
 * @author traceJP
 * @since 2023/5/7 9:16
 */
public enum RequestMapping {

    ONLINE,  // 上线
    OFFLINE,  // 下线

    SEND_MESSAGE,  // 发送消息
    QUERY_CHAT_LOG,  // 查询聊天记录

    SAVE_FONT_CONFIG,  // 保存字体配置
    QUERY_FONT_CONFIG,  // 查询字体配置

    QUERY_ROOM_INFO,  // 查询房间信息

}
