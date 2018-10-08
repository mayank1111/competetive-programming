import java.util.Scanner;


public class PalindromicGame {
	static int t;
	static String str1,str2;
	static int[] hash1,hash2;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		t=input.nextInt();
		while(t-->0)
		{
			str1=input.next();
			str2=input.next();
			if(game())
				System.out.println("A");
			else
				System.out.println("B");
		}
	}
	static boolean game()
	{
		if(str1.length()<2)
		{
			return false;
		}
		else
		{
			hash1=new int[26];
			hash2=new int[26];
			int len=str1.length();
			for(int i=0;i<len;++i)
			{
				hash1[str1.charAt(i)-97]++;
				hash2[str2.charAt(i)-97]++;
			}
			
			for(int i=0;i<26;++i)
			{
				if(hash1[i]>1&&hash2[i]==0)
					return true;
			}
			for(int i=0;i<26;++i)
			{
				if(hash1[i]>0 && hash2[i]==0)
				{
					for(int j=0;j<26;++j)
					{
						if(hash2[j]>0 && hash1[j]==0)
							return false;
					}
					return true;				
				}
			}
			return false;
			
		}
	}


}
