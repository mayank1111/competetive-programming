import java.util.Scanner;


public class AprilChallenge4 {
	static long mod =1000000007;
    public static void main(String[] args) {
    	Scanner input =new Scanner(System.in);
		int tc =input.nextInt();
		for(int t=0 ; t<tc ; ++t)
		{
			int n =input.nextInt();
			int k =input.nextInt();
			long ans=k%mod;
			for(int i=0;i<n-1;++i)
			{
				ans*=(k-1)%mod;
			}
			System.out.println(ans);
		}
	}
    
}