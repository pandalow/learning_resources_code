package basic;

public class Boss {
    public int age;
    public static String name;

    public Boss() {
    }

    private static String say(int n,String s,char c){
        return n + " " + s + " " + c;
    }
    public void hi(String s){
        System.out.println("hi" + s);
    }
}
