package src.main.java.com.tracejp.bingochart.server.controller;

import src.main.java.com.tracejp.bingochart.common.domain.Message;
import src.main.java.com.tracejp.bingochart.common.domain.RequestMapping;
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

    private final ConcurrentMap<RequestMapping, IController> controllerCollections =
            new ConcurrentHashMap<>(16);

    public ServiceContext() {
        this.addController();
    }

    public void handleMessage(Message message, Connector connector, RequestMapping mapping) {
        IController iController = controllerCollections.get(mapping);
        Message response = iController.handlerMessage(message.getParams(), connector);
        if (response != null) {
            connector.sendMessage(response);
        }
    }


    private void addController() {
        // 映射控制器
        OfflineController offlineController = new OfflineController();
        OnlineController onlineController = new OnlineController();
        QueryChatLogController queryChatLogController = new QueryChatLogController();
        QueryFontConfigController queryFontConfigController = new QueryFontConfigController();
        QueryRoomInfoController queryRoomInfoController = new QueryRoomInfoController();
        SaveFontConfigController saveFontConfigController = new SaveFontConfigController();
        SendMessageController sendMessageController = new SendMessageController();

        // 收集
        controllerCollections.put(offlineController.getRequestMapping(), offlineController);
        controllerCollections.put(onlineController.getRequestMapping(), onlineController);
        controllerCollections.put(queryChatLogController.getRequestMapping(), queryChatLogController);
        controllerCollections.put(queryFontConfigController.getRequestMapping(), queryFontConfigController);
        controllerCollections.put(queryRoomInfoController.getRequestMapping(), queryRoomInfoController);
        controllerCollections.put(saveFontConfigController.getRequestMapping(), saveFontConfigController);
        controllerCollections.put(sendMessageController.getRequestMapping(), sendMessageController);
    }

}
