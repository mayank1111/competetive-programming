import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;


public class StringDeReDuplication {


	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String str = br.readLine();
			String str1 = dedup(str, 4);
			String str2 =redup(str1,4);
			System.out.println(str1);
			System.out.println(str2);
		}
	}
	
	 static String dedup(String inputStr, int chunkSize) {
		 
		 int len = inputStr.length();
		 HashMap<String,String> map = new HashMap<String, String>();
		 for(int i=0;i<len;i=i+chunkSize)
		 {
			 String substring = inputStr.substring(i,i+chunkSize);
			 if(map.containsKey(substring))
			 {
				 String indexesStr = map.get(substring);
				 indexesStr+=","+String.valueOf(i);
				 map.put(substring,indexesStr);
				 
			 }
			 else
			 {
				 map.put(substring,String.valueOf(i));
			 }
		 }
		 
		 Iterator<String> iterator = map.keySet().iterator();
		 String dedup ="";
		 while(iterator.hasNext())
		 {
			 String mKey= iterator.next();
			 dedup+=mKey+map.get(mKey)+",";
		 }
	        return dedup.substring(0,dedup.length()-1);
	    }

	    static String redup(String deduplicatedStr, int chunkSize) {
	    	String currentStr = "";
	    	String[] split = deduplicatedStr.split(",");
	    	int len = split.length;
	    	char[] arr = new char[len* chunkSize];
	        for(int i=0;i<len;++i)
	        {
	        	if(!(split[i].charAt(0)>=48 && split[i].charAt(0)<=57))
	        	{
	        		currentStr = split[i].substring(0,chunkSize);
	        		int index = Integer.parseInt(split[i].substring(chunkSize,split[i].length()));
	        		for(int j=0;j<chunkSize;++j)
	        		{
	        			arr[index+j]=currentStr.charAt(j);
	        		}
	        	}
	        	else
	        	{
	        		int index = Integer.parseInt(split[i].substring(0,split[i].length()));
	        		for(int j=0;j<chunkSize;++j)
	        		{
	        			arr[index+j]=currentStr.charAt(j);
	        		}
	        	}
	        	
	        }
	        return String.valueOf(arr);
	    }

}
