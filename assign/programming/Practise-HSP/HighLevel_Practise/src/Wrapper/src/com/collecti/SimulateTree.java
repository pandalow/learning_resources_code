package Wrapper.src.com.collecti;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

public class SimulateTree {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add("John");

        TreeMap treeMap = new TreeMap((Object o1,Object o2) -> ((String) o1).length()- ((String)o2).length());
        treeMap.put("John111","221");
        treeMap.put("2212","21");

        TreeMap treeMap1 = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return Double.compare(((Double)o1),((Double)o2));
            }
        });
        treeMap1.put(1.0,2.2);
        treeMap1.put(0,2.1);
        treeMap1.put(4.3,3.1);


    }

    private SimulateTree left;
    private SimulateTree right;
    private static int SIZE;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        SimulateTree that = (SimulateTree) object;
        return Objects.equals(left, that.left) && Objects.equals(right, that.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    public SimulateTree(SimulateTree left, SimulateTree right) {
        this.left = left;
        this.right = right;
        SIZE += 3;
    }

    public SimulateTree(SimulateTree left) {
        this.left = left;
        SIZE++;
    }

    public SimulateTree() {
        this.left = null;
        this.right = null;
        SIZE++;
    }
}
