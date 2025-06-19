package Wrapper.src.com.m;

public class Homework01 {
    public static void main(String[] args) {
        String i = "abcdef";
        String ri = reverse(i,0,i.length()-1);
        System.out.println(ri);
    }

    public static String reverse(String str, int start, int end){
        char[] temp = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            if(i == start || i== end){
                temp[i] = str.charAt(i);
            }
            else{
                temp[i] = str.charAt(end-i);
            }

        }
        return new String(temp);
    }
}
