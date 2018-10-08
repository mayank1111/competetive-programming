import java.util.Arrays;
import java.util.Scanner;


public class May3 {
	static int t,n,arr[];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		t = input.nextInt();
		while(t-->0)
		{
			n =input.nextInt();
			arr = new int[2*n];
			for(int i=0;i<2*n;++i)
			{
				arr[i]=input.nextInt();
			}
			Arrays.sort(arr);
			int start = n;
			int mid = (n+(2*n-1))/2;
			System.out.println(arr[mid]);
			
			int temp= 2*n-1;
			for(int i=0;i<start;++i)
			{
				System.out.print(arr[i]+" ");
				for(int j=temp;j>=start;)
				{
					System.out.print(arr[j]+" ");
					temp--;
					break;
				}
			}
			
			System.out.println();
		}
	}

}
