import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;



public class GridlandMetro {
	static int k;
	static long sum = 0,n,m;
	static class Node implements Comparable{
		int r,c1,c2;
		Node(int r,int c1,int c2)
		{
			this.r = r;
			this.c1 = c1;
			this.c2= c2;
		}
		public int compareTo(Object arg0) {
			// TODO Auto-generated method stub
			Node obj = (Node)arg0;
			if(this.r<obj.r)
				return -1;
			else
				return 1;
		}
		
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextLong();
		m = input.nextLong();
		k = input.nextInt();
		sum = n*m;
		if(k==0)
		{
			System.out.println(sum);
			return;
		}
		
		ArrayList<Node> ar = new ArrayList<Node>();
		for(int i=0;i<k;++i)
		{
			int r = input.nextInt();
			int c1=input.nextInt();
			int c2 = input.nextInt();
			Node n = new Node(r,c1,c2);
			ar.add(n);
		}
		Collections.sort(ar);
		int len = ar.size();
		ArrayList<Node> sortedAl = new ArrayList<Node>();
		sortedAl.add(ar.get(0));
		for(int i=1;i<len;++i)
		{
			if(ar.get(i).r==ar.get(i-1).r)
			{
				sortedAl.add(ar.get(i));
			}
			else
			{
				int size = sortedAl.size();
				mergeIntervals(sortedAl,size);
				sortedAl.clear();
				sortedAl.add(ar.get(i));
			}
		}
		mergeIntervals(sortedAl, sortedAl.size());
		System.out.println(sum);
	}
	
	 
	// Compares two intervals according to their staring time.
	// This is needed for sorting the intervals using library
	// function std::sort(). See http://goo.gl/iGspV
	static boolean compareInterval(Node i1, Node i2)
	{
	    return (i1.c1 < i2.c1);
	}
	 
	// The main function that takes a set of intervals, merges
	// overlapping intervals and prints the result
	static void mergeIntervals(ArrayList<Node> al, int size)
	{
	    // Test if the given set has at least one interval
	    if (size <= 0)
	        return;
	 
	    Collections.sort(al,new Comparator<Node>() {

			public int compare(Node arg0, Node arg1) {
				// TODO Auto-generated method stub
				if(arg0.c1 <arg1.c1)
					return -1;
				else
					return 1;
			}

			
		});
	 
	    Stack<Node> s = new Stack<Node>();
	 
	    // push the first interval to stack
	    s.push(al.get(0));
	 
	    // Start from the next interval and merge if necessary
	    for (int i = 1 ; i < size; i++)
	    {
	        // get interval from stack top
	        Node top = s.peek();
	 
	        // if current interval is not overlapping with stack top,
	        // push it to the stack
	        if (top.c2 < al.get(i).c1)
	            s.push(al.get(i));
	 
	        // Otherwise update the ending time of top if ending of current
	        // interval is more
	        else if (top.c2 < al.get(i).c2)
	        {
	            top.c2 = al.get(i).c2;
	            s.pop();
	            s.push(top);
	        }
	    }
	 
	   
	    while (!s.empty())
	    {
	        Node t = s.peek();
	        sum -=(t.c2 -t.c1+1);
	        s.pop();
	    }
	    return;
	}
	 
	

}
