package org.blake;

public class HelloWorld
{
    public static void main(String[] args) {
        System.out.println("helloworld!");
        CStringReverse flip = new CStringReverse();

        String friendo = "abcdegccc/";


        System.out.println(flip.reverse(friendo));
    }

    public void doesSomething(){
    System.out.println("1");
    }

    public void doNothing(){
        //does nothing
        int a = 0;
        System.out.println(a);
    }
}
