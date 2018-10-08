import java.util.Scanner;


public class AprilChallenge1 {
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int tc =input.nextInt();
		for(int t=0 ; t<tc ; ++t)
		{
			int vr=0,vg=0,vb=0;
			int max1=0,max2=0;
			int n=input.nextInt();
			String s =input.next();
			
			for(int i=0;i<s.length();++i)
			{
				if(s.charAt(i)=='R')
					++vr;
				else if(s.charAt(i)=='G')
					++vg;
				else
					++vb;
			}
			if(vr>vg)
				max1=vr;
			else
				max1=vg;
			
			if(vb>max1)
				max2=vb;
			else
				max2=max1;
			
			System.out.println(n-max2);
				
		}
	}

}
