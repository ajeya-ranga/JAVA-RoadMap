package Algorithms.Sort;
import java.util.Arrays;

public class CyclicSort {

    public static void main(String[] args){

        int[] arr = {3, 5, 1, 2, 4};
        System.out.println("Original array : " + Arrays.toString(arr));

        int[] sorted = cyclicSort(arr);
        System.out.println("Sorted array using cyclic-sort : " + Arrays.toString(arr));
    }

    public static int[] cyclicSort(int[] array){

        int i = 0;
        while(i < array.length){

            int correctIndex = array[i] - 1;
            if(array[i] != array[correctIndex]){
                swapMembers(array, i, correctIndex);
            }
            else {
                i++;
            }
        }

        return array;
    }

    public static void swapMembers(int[] array,int a,int b){

        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
