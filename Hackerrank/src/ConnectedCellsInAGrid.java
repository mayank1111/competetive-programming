import java.util.Scanner;


public class ConnectedCellsInAGrid {
	static int n,m,data[][];
	static boolean visited[][];
	static int count =0,maxcount=0;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m= input.nextInt();
		data = new int[n][m];
		visited = new boolean[n][m];
		for(int i=0;i<n;++i)
			for(int j=0;j<n;++j)
				data[i][j]=input.nextInt();
		
		for(int i=0;i<n;++i)
		{
			for(int j=0;j<m;++j)
			{
				if(data[i][j]==1 && !visited[i][j])
				{
					count=1;
					visited[i][j]=true;
					dfs(i,j);
					System.out.println(count);
					if(count>maxcount)
						maxcount =count;
				}
			}
		}
		System.out.println(maxcount);
	}
	static void dfs(int i,int j)
	{
		if(isSafe(i+1,j))
		{
			visited[i+1][j]=true;
			count++;
			dfs(i+1,j);
		}
		if(isSafe(i+1,j-1))
		{
			count++;
			visited[i+1][j-1]=true;
			dfs(i+1,j-1);
		}
		if(isSafe(i+1,j+1))
		{
			count++;
			visited[i+1][j+1]=true;
			dfs(i+1,j+1);
		}
		if(isSafe(i-1,j))
		{
			count++;
			visited[i-1][j]=true;
			dfs(i-1,j);
		}
		if(isSafe(i-1,j+1))
		{
			count++;
			visited[i-1][j+1]=true;
			dfs(i-1,j+1);
		}
		if(isSafe(i-1,j-1))
		{
			count++;
			visited[i-1][j-1]=true;
			dfs(i-1,j-1);
		}
		if(isSafe(i,j+1))
		{
			count++;
			visited[i][j+1]=true;
			dfs(i,j+1);
		}
		if(isSafe(i,j-1))
		{
			count++;
			visited[i][j-1]=true;
			dfs(i,j-1);
		}
	}
	static boolean isSafe(int x,int y)
	{
		if(x>=0 && x<n &&y>=0 &&y<n && !visited[x][y] && data[x][y]==1)
		{
			return true;
		}
		return false;
	}

}
