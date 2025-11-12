package Exercise2;

public class Homework06 {

    public static void main(String[] args) {
        Person tang = new Person("唐僧",TrafficFactory.getHorse());
        tang.common();
        tang.passRiver();
        tang.common();
        tang.common();
    }
}

interface Vehicles {
    void work();
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void common() {
        if (!(vehicles instanceof Horse)) {
            vehicles = TrafficFactory.getHorse();
        }
        this.vehicles.work();
    }

    public void passRiver() {
        if (!(vehicles instanceof Boat)) {
            vehicles = TrafficFactory.getBoat();
        }
        this.vehicles.work();
    }
}

class TrafficFactory {
    private static Horse horse = new Horse();

    private TrafficFactory() {
    }

    public static Horse getHorse() {
        return horse;
    }

    public static Boat getBoat() {
        return new Boat();
    }


}

class Horse implements Vehicles {

    @Override
    public void work() {
        System.out.println("Horse working");
    }
}

class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("Boat working");
    }
}
