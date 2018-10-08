import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;


public class MaximumUniqueSegment {
	static int t,n;
	static long[] sum;
	static HashMap<Integer,Integer> hm;
	static int[] hash;
	
	public static void main(String[] args) throws IOException {
		//Scanner input = new Scanner(System.in);
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		t =Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int left=-1;
			int right=-1;
			long res=0;
			long maxValue =0;
			hm=new HashMap<Integer, Integer>();
			n=Integer.parseInt(br.readLine());
			sum = new long[1000005];
			hash =  new int[1000005];
			int foundIndex=0;
			for(int i=0;i<1000005;++i)
			{
				hash[i]=-1;
			}
			String[] split1=br.readLine().split(" ");
			String[] split2=br.readLine().split(" ");
			for(int i=0;i<n;++i)
			{
				if(i==0)
					sum[i]=Integer.parseInt(split2[i]);
				else
					sum[i]=Integer.parseInt(split2[i])+sum[i-1];
			}
			for(int i=0;i<n;++i)
			{
				int val = Integer.parseInt(split1[i]);
				if(hash[val]==-1)
				{
					hash[val]=i;
					if(left==-1)
					{
						left=0;
						right=0;
					}
					else
						right++;
				}
				else
				{

					if(left==0)
						res=sum[right];
					else
					{
						res = sum[right]-sum[left-1];
					}
					maxValue=Math.max(maxValue,res);
					int newval=hash[val];
					for(int l=left;l<=hash[val];++l)
					{
						hash[Integer.parseInt(split1[l])]=-1;
					}
					left =newval+1;
					hash[val]=i;
					right++;
				}
				
			}
			if(left==0)
				res=sum[right];
			else
			{
				res = sum[right]-sum[left-1];
			}
			maxValue=Math.max(maxValue, res);
				System.out.println(maxValue);
			
			
		}
	}

}
