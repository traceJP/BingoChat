package src.main.java.com.tracejp.bingochart.client.controller;

import src.main.java.com.tracejp.bingochart.common.domain.Message;
import src.main.java.com.tracejp.bingochart.common.domain.ResponseMapping;
import src.main.java.com.tracejp.bingochart.common.domain.Connector;
import src.main.java.com.tracejp.bingochart.common.utils.Singleton;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/7 10:57
 */
public class ServiceContext extends Singleton<ServiceContext> {

    private final ConcurrentMap<ResponseMapping, IController> controllerCollections =
            new ConcurrentHashMap<>(16);

    public ServiceContext() {
        this.addController();
    }

    public void handleMessage(Message message, Connector connector, ResponseMapping mapping) {
        IController iController = controllerCollections.get(mapping);
        iController.handlerMessage(message.getParams(), connector);
    }


    private void addController() {
        // 映射控制器
        RespChatLogController respChatLogController = new RespChatLogController();
        RespChatRealtimeMessageController respChatRealtimeMessageController = new RespChatRealtimeMessageController();
        RespFontConfigController respFontConfigController = new RespFontConfigController();
        RespRoomInfoController respRoomInfoController = new RespRoomInfoController();

        // 收集
        controllerCollections.put(respChatLogController.getResponseMapping(), respChatLogController);
        controllerCollections.put(respChatRealtimeMessageController.getResponseMapping(), respChatRealtimeMessageController);
        controllerCollections.put(respFontConfigController.getResponseMapping(), respFontConfigController);
        controllerCollections.put(respRoomInfoController.getResponseMapping(), respRoomInfoController);
    }

}
