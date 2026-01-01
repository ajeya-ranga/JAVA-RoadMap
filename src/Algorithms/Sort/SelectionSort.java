package Algorithms.Sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {3,1,6,5,9};
        System.out.println("Original array : " + Arrays.toString(arr));

        int[] sorted = selectionSort(arr);
        System.out.println("Sorted array using selection-sort : " + Arrays.toString(sorted));
    }

    private static int[] selectionSort(int[] array) {

        for(int i = 0; i < array.length; i++){

            int minValue = array[i];
            int minValueIndex = i;

            for(int j = i+1; j < array.length; j++){

                if(array[j] < minValue){
                    minValue = array[j];
                    minValueIndex = j;
                }
            }

            swapMembers(array, minValueIndex, i);
        }
        return array;
    }

    public static void swapMembers(int[] array,int a,int b){

        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


}
