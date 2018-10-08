package july2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAndSignSequences {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t =Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int maxcountlessthan=0;
			int maxcountgreaterthan=0;
			int countlessthan=0;
			int countgreaterthan =0;
			String s =br.readLine();
			int len =s.length();
			if(len==1)
			{
				if(s.charAt(0)=='<'||s.charAt(0)=='>')
					System.out.println(2);
				else 
					System.out.println(1);
			}	
			else
			{
				s=s.replaceAll("=","");
				if(s.length()==0)
					System.out.println(1);
				else
				{
					if(s.charAt(0)=='<')
						countlessthan=1;
					else if(s.charAt(0)=='>')
						countgreaterthan=1;
					len=s.length();
					for(int i=1;i<len;++i)
					{
						if(s.charAt(i)=='<')
						{
							if(s.charAt(i)==s.charAt(i-1))
							{
								countlessthan++;

							}
							else
							{
								maxcountgreaterthan=Math.max(maxcountgreaterthan,countgreaterthan);
								countlessthan=1;
							}
						}
						else if(s.charAt(i)=='>')
						{
							if(s.charAt(i)==s.charAt(i-1))
							{
								countgreaterthan++;

							}
							else
							{
								maxcountlessthan=Math.max(maxcountlessthan,countlessthan);
								countgreaterthan=1;
							}
						}
					}

					maxcountgreaterthan=Math.max(maxcountgreaterthan,countgreaterthan);
					maxcountlessthan=Math.max(maxcountlessthan,countlessthan);
					System.out.println(Math.max(maxcountgreaterthan,maxcountlessthan)+1);
				}
			}
		}
	}

}
