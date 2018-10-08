import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Leaderboard {

	static int[] ranks;
	static ArrayList<Integer> al; 
    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
    	al = new ArrayList<Integer>();
    	int len = scores.length;
    	ranks = new int[len];
    	al.add(scores[0]);
    	ranks[0]=1;
    	for(int i=1;i<len;++i)
    	{
    		al.add(scores[i]);
    		if(scores[i]==scores[i-1])
    			ranks[i]=ranks[i-1];
    		else
    			ranks[i]=ranks[i-1]+1;
    	}
    	int len2=alice.length;
    	int[] ranksArr= new int[len2];
    	for(int i=0;i<len2;++i)
    	{
    		int binarySearch = Collections.binarySearch(al,alice[i],Collections.reverseOrder());
    		if(binarySearch>=0)
    			ranksArr[i]=ranks[binarySearch];
    		else
    		{
    			binarySearch+=1;
    		binarySearch=-binarySearch;
    			if(binarySearch==len)
    			{
    				binarySearch-=1;
    				ranksArr[i]=ranks[binarySearch]+1;
    			}
    			else
    				ranksArr[i]=ranks[binarySearch];
    			
    		}
    			
    	}
    	return ranksArr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);
        for (int i = 0; i < result.length; i++) {
        	System.out.print(result[i]+" ");
        }

//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
