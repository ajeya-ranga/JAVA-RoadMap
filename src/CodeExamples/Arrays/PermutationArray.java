package CodeExamples.Arrays;


import java.util.Arrays;

//  https://leetcode.com/problems/build-array-from-permutation/description/
//  Given a zero-based permutation nums(0-indexed), build an array ans of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
//  A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
public class PermutationArray
{
    public static void main(String[] args)
    {
        int[] arr = {0 , 2, 1 , 5 , 3 , 4};
        int[] ans = buildPermutationArray(arr);

        System.out.println("Answer : " + Arrays.toString(ans));
    }

    public static int[] buildPermutationArray(int[] array)
    {
        int[] answer = new int[array.length];
        for(int i = 0; i < array.length; i++)
        {
            answer[i] = array[array[i]];
        }
        return answer;
    }
}
