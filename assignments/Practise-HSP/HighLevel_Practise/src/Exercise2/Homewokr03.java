package Exercise2;

public class Homewokr03 {
    public static void main(String[] args) {
        Animal cat = new Animal.Cat();
        cat.shout();
        Animal dog = new Animal.Dog();
        dog.shout();
    }
}

 abstract class Animal{
    abstract void shout();

     static class Cat extends Animal{
         void shout(){
             System.out.println("猫会喵喵叫");
         }
     }
     static class Dog extends Animal{
         void shout(){
             System.out.println("狗会汪汪叫");
         }
     }
}

