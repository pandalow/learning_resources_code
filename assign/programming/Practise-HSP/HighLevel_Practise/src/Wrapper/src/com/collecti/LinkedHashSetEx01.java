package Wrapper.src.com.collecti;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;

public class LinkedHashSetEx01 {

    public static void main(String[] args) {
        Car love = new Car("love", 22);
        Car love2 = new Car("love",22);

        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(love);
        linkedHashSet.add(love2);


    }
    static class Car{
        private String name;
        private double price;

        public Car(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            Car car = (Car) object;
            return Double.compare(price, car.price) == 0 && Objects.equals(name, car.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price);
        }
    }
}
