package Wrapper.src.com.collecti;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListCode {
    public static void main(String[] args) {
        List list = new ArrayList();

        for (int i = 0; i < 11; i++) {
            list.add(i);
        }

        List list2 = new ArrayList(8);

        for (int i = 0; i < 12; i++) {
            list2.add(i);
        }

        List vector = new Vector();
        for (int i= 0;  i< 10; i++) {
            vector.add(i);

        }

        LinkedList linkedList = new LinkedList<>();
        linkedList.add(2);
    }

}
