import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.AllPermission;
import java.util.Arrays;


public class HackerrankRadioTransmitters {
	static int houses[],n,k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		n = Integer.parseInt(split[0]);
		k = Integer.parseInt(split[1]);
		String[] split2 = br.readLine().split(" ");
		houses = new int[n];
		for(int i=0;i<n;++i)
		{
			houses[i]= Integer.parseInt(split2[i]);
		}
		Arrays.sort(houses);
		System.out.println(allotLocation());
	}
	
	
	
	public static int allotLocation()
	{
		int leftPos = 0;
		int tInstalled=1;
		int tPos = 0;
		
		for(int i=1;i<n;++i)
		{
			if(houses[i]-houses[leftPos]<=k)
			{
				tPos = i;
			}
			else if(houses[i]-houses[tPos]>k)
			{
				leftPos = i;
				tInstalled++;
			}
		}
		return tInstalled;

	}

}
