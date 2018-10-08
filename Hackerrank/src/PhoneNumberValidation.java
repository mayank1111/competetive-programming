import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhoneNumberValidation {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String str = br.readLine();
			System.out.println(find_phone_number(str));
			
		}

	}
	
	 static String find_phone_number(String text) {
	     
			String pattern1 = "(\\d{3}-)(\\d{3}-)(\\d{4})";
			String pattern2 = "\\((\\d{3})\\)(\\s)(\\d{3}-)(\\d{4})";
			Pattern p1 = Pattern.compile(pattern1);
			Matcher matcher1 = p1.matcher(text);
			int firstMatcher =-1,secondMatcher =-1;
			if(matcher1.find())
			{
				firstMatcher=matcher1.start();
			}
			Pattern p2 = Pattern.compile(pattern2);
			Matcher matcher2 = p2.matcher(text);
			if(matcher2.find())
			{
				secondMatcher=matcher2.start();
			}
			
			if(firstMatcher==-1 && secondMatcher==-1)
			{
				return "NONE";
				
			}
			else if(firstMatcher==-1 && secondMatcher!=-1)
			{
				return (text.substring(secondMatcher,secondMatcher+14));
			}
			else if(firstMatcher!=-1 && secondMatcher==-1)
			{
				return (text.substring(firstMatcher,firstMatcher+12));
			}
			else
			{
				if(firstMatcher<secondMatcher)
				{
					return text.substring(firstMatcher,firstMatcher+12);
				}
				else
				{
					return (text.substring(secondMatcher,secondMatcher+14));
				}
			}

		}

}
