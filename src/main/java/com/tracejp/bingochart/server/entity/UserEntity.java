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

    private String nickName;

    private Connector connector;

    public UserEntity() {
    }

    public UserEntity(String uuid, String nickName, Connector connector) {
        this.uuid = uuid;
        this.nickName = nickName;
        this.connector = connector;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Connector getConnector() {
        return connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

}
