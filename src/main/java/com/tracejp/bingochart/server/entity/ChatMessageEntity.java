package src.main.java.com.tracejp.bingochart.server.entity;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/12 9:15
 */
public class ChatMessageEntity {

    private String uuid;

    private String message;

    private Long time;

    public ChatMessageEntity() {
    }

    public ChatMessageEntity(String uuid, String message, Long time) {
        this.uuid = uuid;
        this.message = message;
        this.time = time;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

}
