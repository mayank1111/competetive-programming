import java.util.Scanner;


public class NonRepeatingDigit {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner scanner = new Scanner(System.in);
		 int x = scanner.nextInt();
	      //  scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

	        int y = scanner.nextInt();
	        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

	        int z = scanner.nextInt();
	        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

	        int res = nonRepeatingDigitProductCount(x, y, z);

	       

	        scanner.close();
	}
	
	
    static int nonRepeatingDigitProductCount(int x, int y, int z) {
    	int validCount=0;
    	for(int i= y;i<=z;++i)
    	{
    		int res = x*i;
    		String resString = String.valueOf(res);
    		String iString = String.valueOf(i);
    		int len = iString.length();
    		boolean flag = false;
    		for(int j=0;j<len;++j)
    		{
    			if(resString.contains(String.valueOf(iString.charAt(j))))
    			{
    				flag = true;
    			}
    		}
    		if(!flag)
    			validCount++;
    		
    	}
    	System.out.println(validCount);
    	return validCount;

    }

}
