package Exercise;
public class CaleTest{
    public static void main(String[] args) {
        Cale cale1 = new Cale(10,0);
        System.out.println(cale1.divide());
        System.out.println(cale1.sum());
        System.out.println(cale1.multiplication());
        System.out.println(cale1.sub());

    }
}
class Cale {
    private int a;
    private int b;

    public Cale(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int  sum(){
        return a + b;
    }
    public int multiplication(){
        return a*b;
    }
    public int sub(){
        return a-b;
    }
    public int divide(){
        if(b == 0) return -1;
        else return a/b;
    }

}
