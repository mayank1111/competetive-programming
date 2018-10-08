import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

static int INT_SIZE = 32;
    public static void main(String[] args) throws NumberFormatException, IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] inputArr = new int[n];
        for(int i=0;i<n;++i)
        {
            inputArr[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(bitWiseOR(inputArr,n));
    }
    
   
static long bitWiseOR(int arr[], int n)
{
    
    int zerocnt[] = new int[INT_SIZE];
 
    for (int i = 0; i < INT_SIZE; i++)     
        for (int j = 0; j < n; j++)        
            if ((arr[j] & 1 << i)==0)
                zerocnt[i] += 1;            
     
    long ans = 0;
    for (int i = 0; i < INT_SIZE; i++) 
    {
        ans += ((Math.pow(2, n) - 1) - 
               (Math.pow(2, zerocnt[i]) - 1)) * 
                Math.pow(2, i);
    }
 
    return ans;
}
}