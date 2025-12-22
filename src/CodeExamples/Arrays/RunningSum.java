package CodeExamples.Arrays;

import java.util.Arrays;

public class RunningSum
{
    public static void main(String[] args)
    {
        int[] nums = {1,2,3,4};
        int[] sum = calculateRunningSum(nums);

        System.out.println("Running sum = " + Arrays.toString(sum));
    }

    public static int[] calculateRunningSum(int[] array)
    {
        int[] result = new int[array.length];
        int sum = 0;

        for(int i=0; i<array.length; i++)
        {
            result[i] = sum + array[i];
            sum = sum + array[i];
        }
        return result;
    }
}
