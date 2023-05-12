package src.main.java.com.tracejp.bingochart.server.controller;

import src.main.java.com.tracejp.bingochart.common.domain.Connector;
import src.main.java.com.tracejp.bingochart.common.domain.Message;
import src.main.java.com.tracejp.bingochart.common.domain.RequestMapping;

import java.util.Map;

/**
 * <p> 控制器接口 <p/>
 *
 * @author traceJP
 * @since 2023/5/7 10:59
 */
public interface IController {

    /**
     * 处理消息
     * @param params 客户端消息
     * @param connector 客户端连接器
     * @return 响应给客户端的消息
     */
    Message handlerMessage(Map<String, Object> params, Connector connector);

    RequestMapping getRequestMapping();

}
