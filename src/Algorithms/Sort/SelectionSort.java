package Algorithms.Sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {3,1,6,5,9};
        System.out.println("Original array : " + Arrays.toString(arr));

        int[] sorted = selectionSort(arr);
        System.out.println("Sorted array using selection-sort : " + Arrays.toString(sorted));
    }

    public static int[] selectionSort(int[] array){

        for(int i = 0; i < array.length; i++){

            int lastIndex = array.length - 1 - i;
            int maxIndex = getMax(array, i, lastIndex);

            //swap(array, )
        }
        return null;
    }

    public static int getMax(int[] array, int start, int end){

        int max = 0;
        for(int i = start; i < end; i++){

            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }
}
