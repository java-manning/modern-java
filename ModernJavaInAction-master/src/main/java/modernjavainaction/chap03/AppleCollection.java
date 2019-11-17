package modernjavainaction.chap03;

import modernjavainaction.chap01.FilteringApples;
import scala.App;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppleCollection {

    List<Apple> apples = new ArrayList<Apple>();
    public Map<String, Apple> appleHashMap = new HashMap<String, Apple>();

    public static void main(String... args) {
        AppleCollection appleCollection = new AppleCollection();
        appleCollection.predicateOnAMap();
        appleCollection.consumerInterface();
    }

    public AppleCollection() {

    }

    public void add(Apple a) {
        this.apples.add(a);
    }

    public List<Apple> getList() {
        return this.apples;
    }

    public <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for(T t: list) {
            if(p.test(t)) {
                results.add(t);
            } }
        return results;
    }

    public void testAppleCollection() {

        AppleCollection appleCollection = new AppleCollection();
        appleCollection.add(new Apple(100, Color.GREEN));
        appleCollection.add(new Apple(120, Color.GREEN));
        appleCollection.add(new Apple(200, Color.RED));
        appleCollection.add(new Apple(83, Color.GREEN));
        appleCollection.add(new Apple(84, Color.GREEN));
        appleCollection.add(new Apple(85, Color.RED));

        Color c = Color.RED;
        int w = 100;
        Predicate<Apple> filterForColor = (Apple a) -> a.getColor().equals(c);
        Predicate<Apple> filterForWeight = (Apple a) -> a.getWeight()>w;
        List<Apple> redApples = filter(filter(appleCollection.getList(), filterForWeight), filterForColor);

        int i = redApples.size();

    }


    public <K,T> Map<K,T> filterMap(Map<K,T> map, Predicate<K> p) {
        Map<K,T> results = new HashMap<>();
        for(K k: map.keySet()) {
            if(p.test(k)) {
                results.put(k,map.get(k));
            } }
        return results;
    }

    public <K,T> Map<K,T> filterMapWithApple(Map<K,T> map, Predicate<T> p1, Predicate <K> p2) {
        Map<K,T> results = new HashMap<>();
        for(K k: map.keySet()) {
            if(p1.test(map.get(k))) {
                if (p2.test(k)) {
                    results.put(k, map.get(k));
                }
            } }
        return results;
    }

    public void predicateOnAMap() {
        AppleCollection appleCollection = new AppleCollection();
        appleCollection.appleHashMap.put("McIntosh1", new Apple(85, Color.RED));
        appleCollection.appleHashMap.put("McIntosh2", new Apple(85, Color.RED));
        appleCollection.appleHashMap.put("McIntosh3", new Apple(120, Color.RED));
        appleCollection.appleHashMap.put("McIntosh4", new Apple(140, Color.RED));
        appleCollection.appleHashMap.put("M2Intosh5", new Apple(185, Color.RED));
        appleCollection.appleHashMap.put("M3Intosh7", new Apple(285, Color.RED));


        Predicate<String> filterForName = (String a) -> a.startsWith("McIntosh");
        Predicate<Apple> filterForWeight = (Apple a) -> a.getWeight()>100;

        Map somemap = filterMapWithApple(appleCollection.appleHashMap, filterForWeight, filterForName);
        somemap.size();
    }

    public void consumerInterface() {

        AppleCollection appleCollection = new AppleCollection();
        appleCollection.appleHashMap.put("McIntosh1", new Apple(85, Color.RED));
        appleCollection.appleHashMap.put("McIntosh2", new Apple(85, Color.RED));
        appleCollection.appleHashMap.put("McIntosh3", new Apple(120, Color.RED));
        appleCollection.appleHashMap.put("McIntosh4", new Apple(140, Color.RED));
        appleCollection.appleHashMap.put("M2Intosh5", new Apple(185, Color.RED));
        appleCollection.appleHashMap.put("M3Intosh7", new Apple(285, Color.RED));

        Consumer<Apple> consumer = apple -> {System.out.println("Weight of apple is: " + apple.getWeight());};

        appleCollection.appleHashMap.keySet().stream().forEach(key ->{
            consumer.accept(appleCollection.appleHashMap.get((key)));});


    }


}
