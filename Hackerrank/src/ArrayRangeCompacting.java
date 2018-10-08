import java.util.Scanner;


public class ArrayRangeCompacting {
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(true)
		{
			String next = input.next();
			String[] split = next.split(",");
			arr = new int[split.length];
			for(int i=0;i<split.length;++i)
			{
				arr[i]=Integer.parseInt(split[i]);
			}
			String s="";
			int len = arr.length;

			s+=String.valueOf(arr[0]);
			int count=1;
			for(int i=1;i<len;++i)
			{
				if(arr[i]==arr[i-1]+1)
				{
					count++;
				}
				else
				{
					if(count>=3)
					{
						s+="-"+String.valueOf(arr[i-1])+",";
					}
					else
					{
						if(count==1)
						{
							s+=",";
						}
						else
						{
							s+=","+String.valueOf(arr[i-1])+",";
						}
					}
					count=1;
					s+=String.valueOf(arr[i]);
				}
			}

			if(count ==2)
			{
				s+=","+String.valueOf(arr[len-1]);
			}
			if(count>=3)
			{
				s+="-"+String.valueOf(arr[len-1]);
			}


			System.out.println(s);
		}
	}

}
