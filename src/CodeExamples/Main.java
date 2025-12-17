package CodeExamples;

import java.net.StandardSocketOptions;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int[] arr = new int[7];
        Scanner in = new Scanner(System.in);

        for(int col = 0; col < arr.length; col++)
        {
            arr[col] = in.nextInt();
        }
        //System.out.println("Original array : " + Arrays.toString(arr));

        int[] rev = ReverseArray(arr);

        //System.out.println("Reversed array : " + Arrays.toString(rev));

        int minValue = findMinValueInArray(arr);
        System.out.println("Minimum value = " + minValue);
    }

    static int[] ReverseArray(int[] originalArray)
    {
        int start = 0;
        int end = (originalArray.length - 1);
        while(start < end)
        {
            int temp = originalArray[start];
            originalArray[start] = originalArray[end];
            originalArray[end] = temp;

            start++;
            end--;
        }
        return originalArray;
    }


    static int findMinValueInArray(int[] arr)
    {
        int probable = arr[0];
        for(int i = 0; i < arr.length; i++)
        {
            int temp = arr[i];
            if(temp < probable)
            {
                probable = temp;
            }
        }
        return probable;
    }
}
