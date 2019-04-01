package cn.bcf.es.es;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * 官方文档：https://www.elastic.co/guide/en/elasticsearch/client/java-api/current/java-docs-index.html
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/3/21 11:07
 **/
@Component
public class EsCRUD {

    public void json() throws IOException {
        //方法一
        /*String json = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";*/
        //方法二

        Map<String, Object> json = new HashMap<String, Object>();
        json.put("user","kimchy");
        json.put("postDate",new Date());
        json.put("message","trying out Elasticsearch");

        //方法三
        //用jaskson，感觉太麻烦

        //方法四
        //用 Elasticsearch helpers
        XContentBuilder builder = jsonBuilder()
                .startObject()
                .field("user","kimchy")
                .field("postDate",new Date())
                .field("message","trying out Elasticsearch")
                .endObject();
        String json1 = Strings.toString(builder);
    }

    public void create(TransportClient client) throws IOException{
        IndexResponse response = client.prepareIndex("twitter", "_doc", "1")
                .setSource(jsonBuilder()
                        .startObject()
                        .field("user", "kimchy")
                        .field("postDate", new Date())
                        .field("message", "trying out Elasticsearch")
                        .endObject()
                )
                .get();
        System.out.println(response);
    }
}
