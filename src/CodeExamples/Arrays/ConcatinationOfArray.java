package CodeExamples.Arrays;
import java.util.Arrays;


//  https://leetcode.com/problems/concatenation-of-array/description/
//  Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
//
//Specifically, ans is the concatenation of two nums arrays.
//
//Return the array ans.

public class ConcatinationOfArray
{
    public static void main(String[] args)
    {
         int nums[] = {0 , 1 , 2 };
         int[] ans = concatArray(nums);

         System.out.print("Answer : " + Arrays.toString(ans));
    }

    public static int[] concatArray(int[] array)
    {
        int[] result = new int[((array.length * 2))];
        int length = array.length;
        for(int i=0; i < array.length; i++)
        {
            result[i] = array[i];
            result[array.length + i] = array[i];
        }
        return result;
    }
}
