package Exercise;

public class A02 {
    private static char[] element = new char[]{'a','c','f','d','b','g'};

    public static void main(String[] args) {
        int index =  find('a');
        System.out.println(index);
    }
    public static int find(char word){
        int index = -1;
        for (int i = 0; i < element.length-1; i++) {
            if(word == element[i]) index = i;
        }
        return index;
    }
}
