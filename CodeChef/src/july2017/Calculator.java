package july2017;

import java.util.Scanner;

public class Calculator {
	static int t,n,b;
public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	t =input.nextInt();
	while(t-->0)
	{
		n=input.nextInt();
		b=input.nextInt();
		if(b>=n)
			System.out.println(0);
		else
		{
			int r =n/b;
			if(r==1)
			{
				System.out.println(n%b);
			}
			else
			{
				long ans=0;
				long temp=(n-(((r/2)+1)*b));
				long choice1=temp*(r/2+1);
				temp=(n-((r/2)*b));
				long choice2 = temp*(r/2);
				ans = Math.max(choice1,choice2);
				System.out.println(ans);
			}
		}
	}
	
}
}
