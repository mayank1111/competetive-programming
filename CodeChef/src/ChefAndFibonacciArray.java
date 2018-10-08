import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class ChefAndFibonacciArray {
	static int t,n;
	static long count;
	static ArrayList<ArrayList<Integer>> fibonacciList;
	static Trie trie;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		t=input.nextInt();
		while(t-->0)
		{
			count=0;
			n=input.nextInt();
			fibonacciList=new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> inputList = new ArrayList<Integer>();
			trie= new Trie();
			for(int i=0;i<n;++i)
			{
				inputList.add(input.nextInt());
			}
			calculate(inputList);
			System.out.println((count+1)%1000000007);
		}
	}
	static void calculate(ArrayList<Integer> inputList)
	{
		int size=inputList.size();
		for(int i=0;i<size-1;++i)
		{
			if(inputList.get(i)>0 && inputList.get(i+1)>0 &&i+2<size)
			{
				int n1=inputList.get(i);
				int n2=inputList.get(i+1);
				int n3=inputList.get(i+2);
				n1--;
				n2--;
				n3++;
				ArrayList<Integer> clone = (ArrayList<Integer>)inputList.clone();
				clone.set(i, n1);
				clone.set(i+1,n2);
				clone.set(i+2,n3);
				if(trie.insert(clone))
					{
						calculate(clone);
					}
				
			}
			if(inputList.get(i)>0 && inputList.get(i+1)>0 &&i+2==size)
			{
				int n1=inputList.get(i);
				int n2=inputList.get(i+1);
				int n3=1;
				n1--;
				n2--;
				ArrayList<Integer> clone = (ArrayList<Integer>)inputList.clone();
				clone.set(i, n1);
				clone.set(i+1,n2);
				clone.add(n3);	
				if(trie.insert(clone))
				{
					calculate(clone);
				}
			}
		}
	}
	
	static class TrieNode {
	    public TrieNode(int ch)  {
	        value = ch;
	        children = new HashMap<Integer,TrieNode>();
	        bIsEnd = false;
	    }
	    public HashMap<Integer,TrieNode> getChildren() {   return children;  }
	    public int getValue()                           {   return value;     }
	    public void setIsEnd(boolean val)                {   bIsEnd = val;     }
	    public boolean isEnd()                           {   return bIsEnd;    }
	 
	    private int value;
	    private HashMap<Integer, TrieNode> children;
	    private boolean bIsEnd;
	}
	 
	// Implements the actual Trie
	static class Trie {
	    // Constructor
	    public Trie()   {     root = new TrieNode(-1);       }    
	
	    // Method to insert a new word to Trie
	    public  boolean insert(ArrayList<Integer> al)  {
	 
	    	 boolean flag=false;
	        // Find length of the given word
	        int length = al.size();
	        TrieNode crawl = root;
	 
	        // Traverse through all characters of given word
	        for( int level = 0; level < length; level++)
	        {
	            HashMap<Integer,TrieNode> child = crawl.getChildren();
	            int ch = al.get(level);
	 
	            // If there is already a child for current character of given word
	            if( child.containsKey(ch))
	                crawl = child.get(ch);
	            else   // Else create a child
	            {
	            	if(!flag)
	            	{
	            		count++;
	            		flag=true;
	            	}
	                TrieNode temp = new TrieNode(ch);
	                child.put( ch, temp );
	                crawl = temp;
	            }
	        }
	 
	        // Set bIsEnd true for last character
	        crawl.setIsEnd(true);
	        return flag;
	    }
	    private TrieNode root; 
	}
	
}