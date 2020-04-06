package io.project.app.javafrontend.redis;

import java.io.Serializable;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import redis.clients.jedis.Jedis;

/**
 *
 * @author armena
 */
@Named(value = "redisRepository")
@ApplicationScoped
//@ViewScoped
public class RedisRepository implements Serializable {

    private Jedis jedis;

    /**
     * Creates a new instance of RedisRepository
     */
    public RedisRepository() {
    }

    @PostConstruct
    public void init() {
        jedis = new Jedis("redis", 6379);

        String ping = jedis.ping();
        System.out.println("Ping " + ping);
    }

    @PreDestroy
    private void stopDB() {
        jedis.shutdown();
    }

    public void set(String key, String value) {
        System.out.println("key " + key);
        System.out.println("value " + value);
        String set = jedis.set(key, value);
       // jedis.flushAll();
        System.out.println("SET: DB ANSWER " + set);

    }

    public Optional<String> get(String key) {
        System.out.println("GET: key is " + key);
        String get = jedis.get(key);
        System.out.println("GET RESULT " + get);
        return Optional.ofNullable(get);
    }
}
