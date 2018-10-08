import java.util.Scanner;


public class AprilLChallenge3 {
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int t =input.nextInt();
		for(int tc=0;tc<t;++tc)
		{
			long n =input.nextLong();
			long m =input.nextLong();
			if(n*m%2==0)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}

}
