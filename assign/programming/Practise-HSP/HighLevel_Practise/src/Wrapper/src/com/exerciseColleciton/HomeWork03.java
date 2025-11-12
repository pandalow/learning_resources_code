package Wrapper.src.com.exerciseColleciton;

import java.util.*;

public class HomeWork03 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("jack",650);
        map.put("tom",1200);
        map.put("smith",2900);

        map.put("jack",2900);

        Set<String> set = map.keySet();
        for(String o : set){
            map.put(o,(Integer) map.get(o)+100);
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next =  iterator.next();
            System.out.println(next.getKey() + " " + next.getValue());

        }
        Collection<Integer> values = map.values();
        for(Integer e : values){

        }


    }
}
