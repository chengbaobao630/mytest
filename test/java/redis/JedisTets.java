package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by cheng on 2016/4/19 0019.
 */
public class JedisTets {
    private  static JedisPoolConfig jedisPoolConfig=null;
    private static JedisPool jedisPool=null;
    static {
        jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxWaitMillis(600);
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setMaxIdle(1000);
        jedisPool=new JedisPool(jedisPoolConfig,"192.168.153.128",6379);
    }
    public static void main(String args[]) {
        Jedis jedis=jedisPool.getResource();
        System.out.println(jedis.get("age"));
    }
}
