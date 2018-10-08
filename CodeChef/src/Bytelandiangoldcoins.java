import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Bytelandiangoldcoins {
	static HashMap<Integer,Long> hm;
	static String x="";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		hm =new HashMap<Integer,Long>();
		while((x=br.readLine())!=null)
		{
			int num =Integer.parseInt(x);
			System.out.println(calculate(num));
		}
	}

	static long calculate(int n)
	{
		if(hm.containsKey(n))
			return hm.get(n);
		if(n==0 || n==1)
			return n;
		long val =calculate(n/2)+calculate(n/3)+calculate(n/4);
		if(val>n)
		{
			hm.put(n, val);
			return val;
		}
		hm.put(n, (long) n);
		return n;
	}

}
