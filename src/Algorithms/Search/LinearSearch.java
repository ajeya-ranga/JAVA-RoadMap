package Algorithms.Search;

public class LinearSearch {

    public static void main(String[] args) {

        int[] arr = {7, 3, 6, 34, 764, 34, 35, 98, 11, 99};
        int tar = 99;

        int index = linearSearch(arr, tar);
        if(index != -99){
            System.out.println("Target element found at index number " + index + " !!");
        }
        else{
            System.out.println("Target element not found in the array");
        }
    }

    public static int linearSearch(int[] array, int target){

        for(int i = 0; i < array.length; i++)
        {
            if(array[i] == target){
                return i;
            }
        }
        return -99;
    }
}
