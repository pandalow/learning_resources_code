package com.innerClass;

public class LocalInnerClass {
    public static void main(String[] args) {

    }
}

class Outer02{
    private int n1 = 100;
    private void m2(){
        System.out.println("Outer02 m2()");
    }
    public void m1(){
        //不能用访问符修饰，但可以被final修饰，表示不能继承；
        //作用域： 仅仅在定义它的方法或代码块中；
        //内部类可以直接访问外部类成员；
        //外部类在方法中，可以创建Inner02对象，然后调用方法即可；
        final class Inner02{
            private int n1 = 800;
            public void f1(){
                // Using outer class needs the 外部类名+this（务必要）+变量名；
                //Outer02.this 本质就是外部类的对象；
                System.out.println("n1 = " + n1 + "Outer02" + Outer02.this.n1);
                m2();
            }
        }
    }
    {
        class Inner03{

        }
    }
}
