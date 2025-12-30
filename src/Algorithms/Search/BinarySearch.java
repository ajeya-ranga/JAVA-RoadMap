package Algorithms.Search;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {3, 6, 11, 14, 25, 28, 39, 42, 47, 50};
        int tar = 11;

        int index = binarySearch(arr, tar);
        if(index != -99){
            System.out.println("Target element found at index number " + index + " !!");
        }
        else{
            System.out.println("Target element not found in the array");
        }
    }

    public static int binarySearch(int[] array, int target){

        int low = 0;
        int high = array.length;

        while(low<high){

            int mid = (low + (high-low)) / 2;
            if(array[mid] == target){
                return mid;
            }
            else if(array[mid] > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -99;
    }
}
