package src.main.java.com.tracejp.bingochart.client.controller;

import src.main.java.com.tracejp.bingochart.common.domain.Message;
import src.main.java.com.tracejp.bingochart.common.domain.ResponseMapping;

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
     */
    Message handlerMessage(Map<String, Object> params);

    ResponseMapping getResponseMapping();

}
