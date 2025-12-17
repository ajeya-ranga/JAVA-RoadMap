package CodeExamples;

public class RichestMan
{
    public static void main(String[] args)
    {
        int[][] arrTwo = {{1,2,3,4},{2,4,9},{1,6,7,7,9},{9,9,2,4}};
        int[] wealthy = findWealth(arrTwo);
        int richest = findRichest(wealthy);

        System.out.println("The richest guy is : " + richest);
    }

    static int[] findWealth(int[][] arr)
    {
        int richest = 0;
        int[] sum = new int[arr.length];
        for(int row = 0; row < arr.length; row++)
        {
            int total = 0;
            for(int col = 0; col < arr[row].length; col++)
            {
                int member = arr[row][col];
                total = total+member;
            }
            sum[row] = total;
            if(total>richest)
            {
                richest = total;
            }
        }
        return sum;
    }


    static int findRichest(int[] arr)
    {
        int temp = arr[0];
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > temp)
            {
                temp = arr[i];
            }
        }
        return temp;
    }
}
