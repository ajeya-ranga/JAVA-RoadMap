package CodeExamples.Sort;


/*
https://leetcode.com/problems/missing-number/description/
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Example 1:
    Input: nums = [3,0,1]
    Output: 2
    Explanation : n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
                  2 is the missing number in the range since it does not appear in nums.

Example 3:
    Input: nums = [9,6,4,2,3,5,7,0,1]
    Output: 8
    Explanation : n = 9 since there are 9 numbers, so all numbers are in the range [0,9].
                  8 is the missing number in the range since it does not appear in nums.

*/

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args){

        int[] arr = {4, 2, 1, 5, 6};
        int missingNumber = findMissingNumber(arr);

        System.out.println("In the given array : " + Arrays.toString(arr) + " , the missing number is - " + missingNumber);
    }

    private static int findMissingNumber(int[] array) {

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

        for(int j = 0; j < array.length; j++){

            if(array[j] != j+1){
                return j;
            }
        }
        return -1;

    }

    public static void swapMembers(int[] array,int a,int b){

        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
