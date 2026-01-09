package Algorithms;
import java.util.ArrayList;

public class RoughBook
{
    public static void main(String[] args)
    {

        An obj = new Bo();
        obj.printAn();

    }


    static class An {
        String abc;
        int num;

        public void printAn() {
            System.out.println("Class An method");
        }
    }

    static class Bo extends An
    {
        String xo;

        @Override
        public void printAn()
        {
            System.out.println("Printing in class Bo");
        }
    }








    class Fruit
    {
        private String name;


        private static Fruit instance;

        public Fruit getInstance(){
            if(instance == null){
                return instance = new Fruit();
            }
            else{
                return instance;
            }
        }
    }


    Fruit obj = new Fruit();
}





