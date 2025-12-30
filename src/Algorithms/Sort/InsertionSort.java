package Algorithms.Sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = {5, 3, 7, 2, 9, 1, 4, 6, 8};
        System.out.println("Original array : " + Arrays.toString(arr));

        insertionSort(arr);
        System.out.println("Sorted array using insertion-sort : " + Arrays.toString(arr));
    }

    private static void insertionSort(int[] array) {

        for(int i = 0; i < (array.length - 1); i++){

            for(int j = i+1; j > 0; j--){

                if(array[j] < array[j-1]){

                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
                else{
                    break;
                }
            }
        }
    }
}
