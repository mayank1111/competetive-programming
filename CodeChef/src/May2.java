import java.util.Scanner;


public class May2 {
	static int t,n,arr[];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		t = input.nextInt();
		while(t-->0)
		{
			n = input.nextInt();
			arr = new int[n];
			int temp=0;
			int flag =0;
			for(int i=0 ;i<n;++i)
			{
				temp=0;
				arr[i]=input.nextInt();
				temp+=arr[i];
				if(flag<temp)
					flag=temp;
			}
			System.out.println(n-flag);
		}
	
	}

}
