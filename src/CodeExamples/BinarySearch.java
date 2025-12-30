package CodeExamples;

import java.util.Scanner;

public class BinarySearch
{
    public static void main(String[] args){
        int[] arr = {-6, -1, 0, 4, 9, 17, 23, 29, 34, 41, 55, 69};
        System.out.print("Enter a number you want to search in the array : ");

        Scanner in = new Scanner(System.in);
        int target = in.nextInt();

        int index = binarySearch(arr, target);
        System.out.println("Your element " + target + " was found in the " + index + "th index of the array.");
    }

    static int binarySearch(int[] input, int target){
        int start = 0;
        int end = input.length;
        while(start < end){
            int mid = start + (end-start)/2;
            if(input[mid] > target){
                end = mid -1;
            }
            else if(input[mid] < target){
                start = mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
