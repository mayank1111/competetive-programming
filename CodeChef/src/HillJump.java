import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class HillJump {
	static int n,q;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		n=Integer.parseInt(split[0]);
		q=Integer.parseInt(split[1]);
		arr=new int[n+1];
		String[] split2 = br.readLine().split(" ");
		for(int i=1;i<=n;++i)
			arr[i]=Integer.parseInt(split2[i-1]);
		while(q-->0)
		{
			String[] split3 = br.readLine().split(" ");
			if(split3.length==3)
			{
				int start = Integer.parseInt(split3[1]);
				int k=Integer.parseInt(split3[2]);
				boolean flag=false;
				for(int i=start+1;i<=n;++i)
				{
					if(i-start>100)
						break;
					if(arr[i]>arr[start])
					{
						start=i;
						k--;
						if(k==0)
						{
							break;
						}
					}
				}
				System.out.println(start);
			}
			else
			{
				int l = Integer.parseInt(split3[1]);
				int r=Integer.parseInt(split3[2]);
				int x=Integer.parseInt(split3[3]);
		
				for(int i=l;i<=r;++i)
					arr[i]+=x;
			}
		}

	}

}
