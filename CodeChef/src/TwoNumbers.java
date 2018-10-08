import java.util.Scanner;


public class TwoNumbers {
	static int t,a,b,turn;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		t =input.nextInt();
		while(t-->0)
		{
			a=input.nextInt();
			b=input.nextInt();
			turn=input.nextInt();
			if(turn%2==0)
			{
				int ans =Math.max(a,b)/Math.min(a,b);
				System.out.println(ans);
			}
			else{
				a*=2;
				int ans =Math.max(a,b)/Math.min(a,b);
				System.out.println(ans);
			}
			
			
		}
	}

}
