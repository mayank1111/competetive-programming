import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class TheNextPalindrome {
	static int t;
	static String s;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t =Integer.parseInt(br.readLine());
		while(t-->0)
		{
			s= br.readLine();
			int len =s.length();
			boolean notAPalindrome =false;
			for(int i=0;i<len/2;++i)
			{
				//if(s.charAt(i)!=s.charAt(arg0))
			}
		}
	}

}
