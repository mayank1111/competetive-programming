import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class BitMask2 {
	static int t,n,a[],b[];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
			t = input.nextInt();
			while(t-->0)
			{
				n =input.nextInt();
				a =new int[n];
				b = new int[n];
				for(int i=0;i<n;++i)
					a[i]=input.nextInt();
				
				for(int i=0;i<n;++i)
					b[i]=input.nextInt();
				
				Arrays.sort(a);
				for(int i=0;i<n;++i)
				{
					for(int j=i;j<n-i-1;++j)
					{
						if(b[j]<b[j+1])
						{
							int temp = b[j];
							b[j]=b[j+1];
							b[j+1]= temp;
						}
					}
				}
				
				long ans =0;
				for(int i=0;i<n;++i)
				{
					ans+=a[i]*b[i];
				}
				System.out.println(ans);
			}
	}

}
