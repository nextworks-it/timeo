package it.nextworks.nfvmano.timeo.rc.algorithms.dijkstra;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Random;

public class MapByValueTest {

    private MapByValue<String, Integer> map;
    private MapByValue<String, Double> doubleMap;
    private Random random = new Random();

    @Before
    public void setup(){
        map = new MapByValue<>();
        doubleMap = new MapByValue<>();
    }

    @Test
    public void test_poll(){
        Map.Entry<String, Integer> isNull = map.poll();
        Assert.assertNull(isNull);
        map.put("a", 1);
        Map.Entry<String, Integer> isNotNull = map.poll();
        Assert.assertEquals("a", isNotNull.getKey());
        Assert.assertEquals((Integer) 1, isNotNull.getValue());
        Map.Entry<String, Integer> isNull2 = map.poll();
        Assert.assertNull(isNull2);
    }

    @Test
    public void test_nullPut(){
        try{
            map.put("a", null);
            Assert.fail("Expected exception");
        } catch (NullPointerException exc) {
            //As expected
        }
        map.put(null, 3); //should work
    }

    @Test
    public void test_minimality(){
        for (Integer i = 0; i<1000; i++) {
            Integer id = random.nextInt(1000);
            map.put(id.toString(), random.nextInt(1000));
        }
        Integer size = map.size();
        Map.Entry<String, Integer> e = map.poll();
        Assert.assertEquals(size - 1, map.size());
        for (Map.Entry<String, Integer> e2 : map.entrySet()){
            Assert.assertTrue(e.getValue() <= e2.getValue());
        }
    }

    @Test
    public void test_minimality_D(){
        for (Integer i = 0; i<1000; i++) {
            Integer id = random.nextInt(1000);
            doubleMap.put(id.toString(), random.nextDouble());
        }
        Integer size = doubleMap.size();
        Map.Entry<String, Double> e = doubleMap.poll();
        Assert.assertEquals(size - 1, doubleMap.size());
        for (Map.Entry<String, Double> e2 : doubleMap.entrySet()){
            Assert.assertTrue(e.getValue() <= e2.getValue());
        }
    }
    @Test
    public void test_put_poll_size(){
        map.put("a", 1);
        map.put("b", 2);
        Assert.assertEquals(2, map.size());
        map.put("a", 2);
        Assert.assertEquals(2, map.size());
        Assert.assertEquals((Integer) 2, map.get("a"));
        Assert.assertEquals((Integer) 2, map.poll().getValue());
        Assert.assertEquals(1, map.size());
    }

    @Test
    public void test_remove(){
        map.put("a", 1);
        map.put("b", 1);
        Assert.assertEquals(2, map.size());
        map.remove("b");
        Assert.assertEquals(1, map.size());
        Assert.assertEquals(new AbstractMap.SimpleEntry<>("a", 1), map.poll());
        Assert.assertTrue(map.isEmpty());
    }
}
