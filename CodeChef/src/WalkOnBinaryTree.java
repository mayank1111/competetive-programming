import java.util.Scanner;

public class WalkOnBinaryTree {
	static int t,n,q,count;
	
	static class TrieNode
	{
		TrieNode left,right;
		TrieNode()
		{
			left=null;
			right=null;
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		t=input.nextInt();
		while(t-->0)
		{
			count=1;
			n=input.nextInt();
			q=input.nextInt();
			char[] s=new char[n];
			for(int i=0;i<n;++i)
			{
				s[i]='0';
			}
			TrieNode root=new TrieNode();
			for(int i=0;i<q;++i)
			{
				String type = input.next();
				if(type.equals("!"))
				{
					int num = input.nextInt();
					char carry='0';
					
					for(int j = n - 1 - num; j >= 0; j--)
					{
						if(carry == '0')
						{
							if(s[j] == '0')
							{
								s[j]='1';
								break;
							}
							else
							{
								s[j] = '0';
								carry = '1';
							}
						}
						else
						{
							if ( s[j] == '0')
							{
								s[j] = '1';
								carry = '0';
								break;
							}
							else
							{	
								s[j] = '0';
								carry = '1';
							}
						}
					}
					
					TrieNode crawl=root;
					for(int ind=0;ind<n;++ind)
					{
						if(s[ind]=='0')
						{
							if(crawl.left==null)
							{
								TrieNode temp=new TrieNode();
								crawl.left=temp;
								crawl=temp;
								count++;
							}
							else
								crawl=crawl.left;
						}
						else
						{
							if(crawl.right==null)
							{
								TrieNode temp=new TrieNode();
								crawl.right=temp;
								crawl=temp;
								count++;
							}
							else
								crawl=crawl.right;
						}
					}
				}
				
				else
				{
					System.out.println(count);
				}
					
			}
				
			
		}
			
	}
}

