package redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class HashTest {
    private static long times = 1000000L;

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");

        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            Person person = new Person();
            person.setName("yhm" + i);
            person.setGender("male" + i);
            Map<String, String> map = new HashMap<>();
            map.put("name", person.getName());
            map.put("gender", person.getGender());
            jedis.hmset("person" + i, map);
        }
        for (int i = 0; i < times; i++) {
            Person person = new Person();
            Map<String, String> map = jedis.hgetAll("person" + i);
            person.setName(map.get("name"));
            person.setGender(map.get("gender"));
        }
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }





}
