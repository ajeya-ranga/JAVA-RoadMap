package Algorithms;
import java.util.ArrayList;

public class RoughBook
{
    public static void main(String[] args)
    {

        Trial thread = new Trial();
        thread.start();


    }


    static class Trial extends Thread
    {
        @Override
        public void run()
        {
            System.out.println("Hi i am runnig !");
            try{ Trial.sleep(1000); }
            catch(Exception ex) {}
        }
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




    abstract class Banyan
    {
        int number;
        String name;
        abstract void showClass();
    }

    class Tree extends Banyan
    {

        @Override
        void showClass() {

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



class Sports
{
    private static Sports instance;

    public static Sports getInstance()
    {
        if(instance == null)
        {
            return instance = new Sports();
        }
        else {
            return instance;
        }
    }
}

