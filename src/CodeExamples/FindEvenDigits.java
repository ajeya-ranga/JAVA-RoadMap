package CodeExamples;

import java.util.Arrays;

import static java.lang.System.in;

public class FindEvenDigits
{
    public static void main(String[] args)
    {
        int[] arr = {234, 5432, 12, 99, 480, 238, 777777, 10, 777};

        int result = findEvenNumberOfDigits(arr);
        System.out.println("Given array : " + Arrays.toString(arr));
        System.out.println("These are " + result + " even numbers in the given array.");
    }

    static int findEvenNumberOfDigits(int[] arr)
    {
        int result = 0;
        for(int i = 0; i < arr.length; i++)
        {

            int member = arr[i];
            int digitCount = 0;
            while(member > 0)
            {
                digitCount++;
                member = member/10;
            }

            if(digitCount%2 ==0)
            {
                result += 1;
            }
        }

        return result;
    }
}
