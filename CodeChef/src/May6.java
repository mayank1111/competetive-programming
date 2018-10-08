/* package whatever; // don't place package name! 
 
import java.util.*;
 
 Name of the class has to be "Main" only if the class is public. 
public class May6
{
	static int n;
	static long k,arr[],count=0,index=0,inc=0;
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		k = input.nextLong();
		index=0;
		inc=0;
		arr = new long[n];
		for(int i=0;i<n;++i)
		arr[i]=input.nextLong();
		
		TreeSet<Long> al = new TreeSet<Long>();
		
		
		for(int i=0;i<n;++i)
		{
			if(arr[i]>k)
			continue;
			inc=index;
		Iterator<Long> it =	al.iterator();
		ArrayList<Long> al1 = new ArrayList<Long>();
			while(it.hasNext())
			{
				long val =it.next();
				long mul = arr[i]*val;
				if(mul>0 &&mul<=k)
				{
					al1.add(arr[i]*val);
					++index;
				}
				else
				break;
				
				--inc;
			}
			int len = al1.size();
			for(int l =0;l<len;++l)
			{
				al.add(al1.get(l));
			}
				al.add(arr[i]);
				++index;
			
		}
			System.out.println(index);
		
		// your code goes here
	//	printSubsequences();
	//	System.out.println(count);
	}
}  */

/* package whatever; // don't place package name! */
 
import java.util.*;
 
/* Name of the class has to be "Main" only if the class is public. */
public class May6
{
	static int n;
	static long k,arr[],count=0,index=0,inc=0;
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		k = input.nextLong();
		index=0;
		inc=0;
		arr = new long[n];
		for(int i=0;i<n;++i)
		arr[i]=input.nextLong();
		
		ArrayList<Long> al = new ArrayList<Long>();
		for(int i=0;i<n;++i)
		{
			if(arr[i]>k)
			continue;
			inc=index;
			for(int j=0;j<inc;++j)
			{
				long mul = arr[i]*al.get(j);
				if(mul>0 &&mul<=k)
				{
					al.add(arr[i]*al.get(j));
					++index;
				}
			}
			
				al.add(arr[i]);
				++index;
		}
			System.out.println(index);
		
		// your code goes here
	//	printSubsequences();
	//	System.out.println(count);
	}
} 