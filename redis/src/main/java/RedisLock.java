import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

public class RedisLock {

    private String redis_lock = "redis_lock";
    private long interval_lock_lease_time = 30000;
    private long timeout = 99999;

    SetParams params = SetParams.setParams().nx().px(interval_lock_lease_time);

    JedisPool jedisPool = new JedisPool();


}
