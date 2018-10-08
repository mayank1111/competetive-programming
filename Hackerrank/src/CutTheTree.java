import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class CutTheTree {
	static int visited[] = new int[100009];
	static int val_node[]=new int[100009];
	static int val[]=new int[100009];
	static ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
	static int diff(int val, int sum)
	{
	    return Math.abs(sum - 2*val);
	}


	static int dfs (int node )
	{

	    if(visited[node] == 1)
	        return 0;

	    if(edges.get(node).size() == 1 )
	    {
	        val_node[node] = val[node];
	        visited[node]= 1;
	        return val_node[node];
	    }

	    else
	    {
	    	ArrayList<Integer> arrayList = edges.get(node);
	    	int size = arrayList.size();
	        visited[node] = 1;
	        int c = val[node] ;
	        for(int i=0;i<size;++i)
	        {
	            int k = arrayList.get(i);
	            c += dfs(k);
	        }
	        val_node[node] =c ;
	        return val_node[node];
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
	    int N,root=0,i;
	    N=input.nextInt();
	    assert(3<=N);
	    assert(N<=100000);
	    int s = 0;
	    for(i=1 ; i<= N ; i++)
	    {
	       val[i]=input.nextInt();
	        assert(1<=val[i]);
	        assert(val[i]<=10001);
	        s = s+ val[i];
	        
	    }

	    for(i=0;i<=N;++i)
	    {
	    	edges.add(new ArrayList<Integer>());
	    }

	    for(i=0 ; i< N-1 ; i++)
	    {
	        int a,b;
	      a=input.nextInt();
	      b=input.nextInt();
	        assert(1<=a);
	        assert(1<=b);
	        assert(a<=N);
	        assert(b<=N);
	        
	  edges.get(a).add(b);
	        	 edges.get(b).add(a);
	       
	    }


	    for(i=1 ; i<=N ; i++)
	    {
	        if(edges.get(i).size() > 1)
	        {
	            root = i;
	            break;
	        }
	    }

	    for(i=1 ; i<=N ; i++)
	        val_node[i] = visited[i] = 0;

	    int c = dfs(root);


	    for(i=1 ; i<=N ; i++)
	        val_node[i-1] = diff(val_node[i],s);

	    Arrays.sort(val_node,0,N);
	   System.out.println(val_node[0]);
	}



}
