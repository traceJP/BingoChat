package src.main.java.com.tracejp.bingochart.server.entity;

import src.main.java.com.tracejp.bingochart.common.domain.Connector;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/12 8:55
 */
public class UserEntity {

    private String uuid;

    /**
     * 唯一
     */
    private String username;

    private Connector connector;

    public UserEntity() {
    }

    public UserEntity(String uuid, String username, Connector connector) {
        this.uuid = uuid;
        this.username = username;
        this.connector = connector;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Connector getConnector() {
        return connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

}
