package CodeExamples;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,5,4,1,2,0};
        System.out.println("Original array: " + Arrays.toString(arr));
        int[] sorted = bubbleSort(arr);
        System.out.println("Sorted array using Bubble-Sort : " + Arrays.toString(sorted));
    }

    public static int[] bubbleSort(int[] array)
    {
        for(int i=0; i < array.length; i++)
        {
            boolean swapped = false;
            for(int j=1; j < (array.length) - i; j++)
            {
                if(array[j] < array[j-1])
                {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;

                    swapped = true;
                }
            }
            if(!swapped)
            {
                break;
            }
        }
        return array;
    }
}
