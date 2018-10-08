package july2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhatsTheName {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t =Integer.parseInt(br.readLine());
		while(t-->0)
		{
			String[] split = br.readLine().split(" ");
			int len =split.length;
			if(len==1)
			{
				System.out.println(split[0].substring(0,1).toUpperCase()+split[0].substring(1,split[0].length()).toLowerCase());
			}
			else if(len==2)
			{
				System.out.println(split[0].substring(0,1).toUpperCase()+". "+split[1].substring(0,1).toUpperCase()+split[1].substring(1,split[1].length()).toLowerCase());	
			}
			else
			{
				System.out.println(split[0].substring(0,1).toUpperCase()+". "+split[1].substring(0,1).toUpperCase()+". "+split[2].substring(0,1).toUpperCase()+split[2].substring(1,split[2].length()).toLowerCase());	
			}
		}
	}
}