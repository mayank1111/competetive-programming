import java.util.ArrayList;
import java.util.Scanner;


public class KnightLOnChessboard {
	static int n;
	static int minMoves =0;
	static boolean visited[][];
	static class Node
	{
		int x,y,i,j,moves;

		public Node(int x, int y, int i, int j, int moves) {
			super();
			this.x = x;
			this.y = y;
			this.i = i;
			this.j = j;
			this.moves = moves;
		}
		
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		for(int i=1;i<n;++i)
		{
			for(int j=1;j<n;++j)
			{
				visited = new boolean[n][n];
				visited[0][0]=true;
				minMoves = Integer.MAX_VALUE;
				calculateMoves(0,0,i, j,0);
				if(minMoves == Integer.MAX_VALUE)
					System.out.print("-1"+" ");
				else
					System.out.print(minMoves+" ");
			}
			System.out.println();
		}
	}
	
	static void calculateMoves(int x,int y,int i,int j,int moves)
	{
		Node node = new Node(x,y,i,j,moves);
		ArrayList<Node> al = new ArrayList<Node>();
		al.add(node);
		while(!al.isEmpty())
		{
			Node element = al.remove(0);
			int x1 = element.x;
			int y1= element.y;
			int moves1 = element.moves;
			if(x1==n-1 && y1==n-1)
			{
				if(moves1<minMoves)
				{
					minMoves = moves1;
					return;
				}
			}
		
		if(isSafe(x1+i,y1+j))
				{
					visited[x1+i][y1+j]=true;
					Node nextNode = new Node(x1+i, y1+j, i, j, moves1+1);
					al.add(nextNode);
				}
		if(isSafe(x1+i,y1-j))
		{
			visited[x1+i][y1-j]=true;
			Node nextNode = new Node(x1+i, y1-j, i, j, moves1+1);
			al.add(nextNode);
		}
		
		if(isSafe(x1-i,y1+j))
		{
			visited[x1-i][y1+j]=true;
			Node nextNode = new Node(x1-i, y1+j, i, j, moves1+1);
			al.add(nextNode);
		}
		
		if(isSafe(x1-i,y1-j))
		{
			visited[x1-i][y1-j]=true;
			Node nextNode = new Node(x1-i, y1-j, i, j, moves1+1);
			al.add(nextNode);
		}
		
		if(isSafe(x1+j,y1+i))
		{
			visited[x1+j][y1+i]=true;
			Node nextNode = new Node(x1+j, y1+i, i, j, moves1+1);;
			al.add(nextNode);
		}
		if(isSafe(x1+j,y1-i))
		{
			visited[x1+j][y1-i]=true;
			Node nextNode = new Node(x1+j, y1-i, i, j, moves1+1);
			al.add(nextNode);
		}

		if(isSafe(x1-j,y1+i))
		{
			visited[x1-j][y1+i]=true;
			Node nextNode = new Node(x1-j, y1+i, i, j, moves1+1);
			al.add(nextNode);
		}

		if(isSafe(x1-j,y1-i))
		{
			visited[x1-j][y1-i]=true;
			Node nextNode = new Node(x1-j, y1-i, i, j, moves1+1);
			al.add(nextNode);
		}
	}
		
	}
	static boolean isSafe(int x,int y)
	{
		if(x>=0 && x<n &&y>=0 &&y<n && !visited[x][y])
		{
			return true;
		}
		return false;
	}

}
