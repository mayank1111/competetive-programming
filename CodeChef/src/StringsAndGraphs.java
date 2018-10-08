import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class StringsAndGraphs {
	static class Edge
	{
		int u,v;
		Edge(int u,int v)
		{
			this.u=u;
			this.v=v;
		}
	}
	static Edge[] edgeArr;
	static int t;
	static int n,m;
	static int[] arr;
	static boolean[] visited;
	static HashMap<Integer, Integer> connectedVeticesMap;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t=Integer.parseInt(br.readLine());
		while(t-->0)
		{
			String[] split = br.readLine().split(" ");
			n=Integer.parseInt(split[0]);
			m=Integer.parseInt(split[1]);
			arr=new int[n+1];
			visited=new boolean[n+1];
			int val=0;
			edgeArr=new Edge[m];
			boolean isInvalidGraph=false;
			for(int ind=0;ind<m;++ind)
			{
				String[] split1 = br.readLine().split(" ");
				int u=Integer.parseInt(split1[0]);
				int v=Integer.parseInt(split1[1]);
				if(u==v ||u>v)
					isInvalidGraph=true;
				edgeArr[ind]=new Edge(u,v);
			}
			
			if(isInvalidGraph)
			{
				System.out.println("-1");
				continue;
			}
			//sort edges array based on source index 
			//if source index of two edges is same sort on based on destination index
			Arrays.sort(edgeArr,new Comparator<Edge>() {

				public int compare(Edge e1, Edge e2) {
					if(e1.u<e2.u)
						return -1;
					else if(e1.u==e2.u)
					{
						if(e1.v<e2.v)
							return -1;
						return 1;
					}
					return 1;
				}
			});
			
			connectedVeticesMap = new HashMap<Integer, Integer>();
			for(int i=0;i<m;++i)
			{
				if(!visited[edgeArr[i].v])
				{
					if(edgeArr[i].u==0)
						arr[edgeArr[i].v]=++val;
					else
						arr[edgeArr[i].v]=arr[edgeArr[i].u];
					visited[edgeArr[i].v]=true;
				}
				if(connectedVeticesMap.containsKey(edgeArr[i].u))
				{	
					int vertexCount = connectedVeticesMap.get(edgeArr[i].u);
					connectedVeticesMap.put(edgeArr[i].u,vertexCount+1);
				}
				else
				{
					connectedVeticesMap.put(edgeArr[i].u,1);
				}
			}
			
			HashMap<Integer, Integer> distinctMap = new HashMap<Integer, Integer>();
			for(int i=1;i<=n;++i)
			{
				if(distinctMap.containsKey(arr[i]))
				{
					int count = distinctMap.get(arr[i]);
					distinctMap.put(arr[i], count+1);
				}
				else
				{
					distinctMap.put(arr[i], 1);
				}
			}
			
			boolean flag=false;
			for(int i=0;i<n;++i)
			{
				if(i==0)
				{
					if(distinctMap.size()!=connectedVeticesMap.get(i))
					{
						flag=true;
						break;
					}
				}
				else
				{
					int count = distinctMap.get(arr[i]);
					if(count==1)
					{
						distinctMap.remove(arr[i]);
					}
					else
					{
						distinctMap.put(arr[i],count-1);
					}
					if(distinctMap.size()!=connectedVeticesMap.get(i))
					{
						flag=true;
						break;
					}
					
				}
				
			}
				if(flag==false)
				{
					for(int i=1;i<=n;++i)
					{
						System.out.print(arr[i]+" ");
					}
					System.out.println();
				}
				else
				{
					System.out.println("-1");
				}
		}
	}
}
