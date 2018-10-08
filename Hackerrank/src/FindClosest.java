import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class FindClosest {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HashMap<Character,ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		for(int i=0;i<len;++i)
		{
			if(map.containsKey(str.charAt(i)))
			{
				ArrayList<Integer> arrayList = map.get(str.charAt(i));
				arrayList.add(i);
			}
			else
			{
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(str.charAt(i),list);
			}
		}
		int q = Integer.parseInt(br.readLine());
		while(q-->0)
		{
			int index = Integer.parseInt(br.readLine());
			char c = str.charAt(index);
			if(map.containsKey(c))
			{
				ArrayList<Integer> arrayList = map.get(c);
				if(arrayList.size()==1)
				{
					System.out.println("-1");
				}
				else
				{
					int foundIndex = Collections.binarySearch(arrayList,index);
					
					if(foundIndex==0)
					{
						System.out.println(arrayList.get(foundIndex+1));
					}
					else if(foundIndex==arrayList.size()-1)
					{
						System.out.println(arrayList.get(foundIndex-1));
					}
					else
					{
						int diff1 = Math.abs(arrayList.get(foundIndex-1)-index);
						int diff2 = Math.abs(arrayList.get(foundIndex+1)-index);
						if(diff1<=diff2)
						{
							System.out.println(arrayList.get(foundIndex-1));
						}
						else
						{
							System.out.println(arrayList.get(foundIndex+1));
						}
					}
				}
			}
			else
			{
				System.out.println("-1");
			}
		}
		
	}

}
