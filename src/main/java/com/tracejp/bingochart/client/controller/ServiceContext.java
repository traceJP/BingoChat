package src.main.java.com.tracejp.bingochart.client.controller;

import src.main.java.com.tracejp.bingochart.common.domain.Message;
import src.main.java.com.tracejp.bingochart.common.domain.ResponseMapping;
import src.main.java.com.tracejp.bingochart.common.domain.base.Connector;
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
        Message response = iController.handlerMessage(message.getParams());
        if (response != null) {
            connector.sendMessage(response);
        }
    }


    private void addController() {
        SendController sendController = new SendController();
        controllerCollections.put(sendController.getResponseMapping(), sendController);
    }

}
