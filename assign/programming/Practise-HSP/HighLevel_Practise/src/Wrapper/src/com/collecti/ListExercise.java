package Wrapper.src.com.collecti;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExercise {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        List list = new ArrayList();

        for (int i = 0; i < 10; i++) {
            list.add("hello" + i);
        }
        System.out.println(list);

        list.add(1,"Bye-bye");
        list.get(5);
        list.remove(6);
        list.set(7,"Good");

        Iterator itr = list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}
