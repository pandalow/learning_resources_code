package Wrapper.src.com.collecti;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayList1 {
    public static void main(String[] args) {
        List list  =  new ArrayList();

        list.add(10);
        list.add("jack");
        list.add(true);

        list.remove("jack");

        list.contains(10);//返回true;

        list.addAll(new ArrayList());
        list.containsAll(new ArrayList<>());
        list.removeAll(new ArrayList<>());
        list.size();
        list.isEmpty();
        list.clear();

        Iterator itr = list.iterator();


    }
}
