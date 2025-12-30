package Algorithms.Sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {5, 6, 2, 7, 1, 0, 4, 3};
        System.out.println("Original array : " + Arrays.toString(arr));

        bubbleSort(arr);
        System.out.println("Sorted array using bibble-sort : " + Arrays.toString(arr));
    }

    public static void bubbleSort(int[] array){

        for(int i = 0; i < array.length; i++){

            boolean swapped = false;
            for(int j = 1; j < (array.length - i); j++){

                if(array[j] < array[j-1]){

                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;

                    swapped = true;
                }
            }
            if(!swapped){
                System.out.println("Already sorted !!");
                break;
            }
        }
    }
}
