package util;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName:
 * @Description:
 * @author: Ouzl
 * @create: 2019-07-31 00:35
 */

public class JedisUtil {

    private static JedisPool jedisPool;

    static {
        Properties properties = new Properties();
        InputStream inputStream = JedisUtil.class.getClassLoader().getResourceAsStream("/Jedis.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));

        jedisPool = new JedisPool(config,properties.getProperty("host"),Integer.parseInt(properties.getProperty("port")));
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
