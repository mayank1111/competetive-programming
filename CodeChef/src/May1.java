import java.util.Scanner;


public class May1 {
	static int t;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		t =input.nextInt();
		while(t-->0)
		{
			String s =input.next();
			int len = s.length();
			if(len==1)
				System.out.println("yes");
			else
			{
				boolean flag = false;
				for(int i=1;i<len;++i)
				{
					if(s.charAt(i)<s.charAt(i-1))
					{
						flag = true;
						System.out.println("no");
						break;
					}
				}
				
				if(flag == false)
					System.out.println("yes");
			}
		}
	}

}
