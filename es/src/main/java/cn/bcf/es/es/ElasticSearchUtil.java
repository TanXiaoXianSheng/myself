package cn.bcf.es.es;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/3/21 10:48
 **/
@Component
public class ElasticSearchUtil {

    TransportClient client = null;

    public TransportClient start() throws UnknownHostException {
        //Note that you have to set the cluster name if you use one different than "elasticsearch"
        Settings settings = Settings.builder()
                .put("client.transport.sniff", true)
                .build();

        client = new PreBuiltTransportClient(settings)
                //.addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300))
                .addTransportAddress(new TransportAddress(InetAddress.getByName("10.70.93.94"), 9300))
                .addTransportAddress(new TransportAddress(InetAddress.getByName("10.70.93.95"), 9300))
                .addTransportAddress(new TransportAddress(InetAddress.getByName("10.70.93.96"), 9300))
        ;
        return client;
    }

    public void close(TransportClient client){
        if (client!= null){
            client.close();
        }
    }
}
