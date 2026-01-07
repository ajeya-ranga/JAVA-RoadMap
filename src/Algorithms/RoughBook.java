package Algorithms;

public class RoughBook {
    public static void main(String[] args) {

        A obj = (i) -> System.out.println("Keiichi"+i);
        obj.show(5);
    }
}

interface A{
    void show(int i);
}


