package cn.bcf.es;

import cn.bcf.es.es.ElasticSearchUtil;
import cn.bcf.es.es.EsCRUD;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.UnknownHostException;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"common.util","cn.uxin.mq.rabbitMQ"})
public class ElasticsearchTest {

    @Autowired
    private ElasticSearchUtil elasticSearchUtil;

    @Autowired
    private EsCRUD esCRUD;

    TransportClient client = null;

    @Before
    public void before() throws UnknownHostException {
        client = elasticSearchUtil.start();
    }

    @After
    public void after(){
        elasticSearchUtil.close(client);
    }

    @Test
    public void createTest() throws IOException{
        esCRUD.create(client);
    }


}
