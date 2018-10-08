import java.util.Scanner;


public class AprilChallenge2 {
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);

		int tc =input.nextInt();
		for(int t=0 ; t<tc ; ++t)
		{
			long r = input.nextLong();

			long g =input.nextLong();

			 long b =input.nextLong();
			
			long k = input.nextLong();
		
			long ans=0,count=0;
			if(r<k)
				ans+=r;
			
			else
			 count++;	
			if(g<k)
				ans+=g;
			else
				count++;
			if(b<k)
				ans+=b;
			else 
				count++;
			ans+=k*count-(count-1);
			
			System.out.println(ans);
		}

	}
}