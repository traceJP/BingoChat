package src.main.java.com.tracejp.bingochart.common.domain;

import java.io.Serializable;
import java.util.Map;

/**
 * <p> 消息体 <p/>
 *
 * @author traceJP
 * @since 2023/5/7 9:15
 */
public class Message implements Serializable {

    private String id;

    private RequestMapping request;

    private ResponseMapping response;

    private Map<String, Object> params;

    public Message() {
    }

    public Message(String id, RequestMapping request, Map<String, Object> params) {
        this.id = id;
        this.request = request;
        this.params = params;
    }

    public Message(String id, ResponseMapping response, Map<String, Object> params) {
        this.id = id;
        this.response = response;
        this.params = params;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RequestMapping getRequest() {
        return request;
    }

    public void setRequest(RequestMapping request) {
        this.request = request;
    }

    public ResponseMapping getResponse() {
        return response;
    }

    public void setResponse(ResponseMapping response) {
        this.response = response;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", request=" + request +
                ", response=" + response +
                ", params=" + params +
                '}';
    }

}
