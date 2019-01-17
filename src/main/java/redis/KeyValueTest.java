package redis;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

public class KeyValueTest {

    private static long times = 1000000L;

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            Person person = new Person();
            person.setName("yhm");
            person.setGender("male");

            String text = JSON.toJSONString(person);
            jedis.set("person" + i, text);
            text = jedis.get("yhm" + i);
            person = JSON.parseObject(text, Person.class);
        }


        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
