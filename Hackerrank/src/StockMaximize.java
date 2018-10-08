import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StockMaximize {

    // Complete the stockmax function below.
    static int stockmax(int[] prices) {
        int len = prices.length;
         
        if(len==1)
            return 0;
        int profit =0;
        int count=0;
        int buy=0;
       int i=len-2;
        int sell=prices[len-1];
        while(i>=0)
        {
            
            while(i>=0 &&prices[i]<=sell)
            {
                count++;
                buy+=prices[i];
                
                i--;
            }
           
            if(i<=0)
                break;
            
            profit+=((count*sell) -buy);
            sell=prices[i];
            buy=0;
            count=0;
            i--;
        }
        
        profit+=((sell*count)-buy);
        return profit;

    }

    private static  Scanner scanner;// = new Scanner(System.in);
    

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    	File file = new File("input.txt");

    	scanner = new Scanner(file);
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] prices = new int[n];

            String[] pricesItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int pricesItem = Integer.parseInt(pricesItems[i]);
                prices[i] = pricesItem;
            }

            int result = stockmax(prices);
            System.out.println(result);

            //bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
