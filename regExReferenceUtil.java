package SanityTests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regExReferenceUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//where to apply in automation - contact us page test to check if phone no is in valid format
			String input = "Phone no: +91 9876543210";

			Pattern pattern = Pattern.compile("\\d{10}");
			Matcher matcher = pattern.matcher(input);

			if (matcher.find()) {
				System.out.println("Phone number valid " + matcher.group());
			}
			else 
			{
				System.out.println("Phone number format invalid" + matcher.group());
			}

			//email id displayed validation
			String email = "orangehrm@gmail.in";
			String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";

			System.out.println("Email match :" + email.matches(regex)); // true

			//return a number only string 
			String price = "₹1,29,999";
			String cleanPrice = price.replaceAll("[^0-9]", "");

			System.out.println("Price displayed:" + price + "Cleaned price:" + cleanPrice); // 1299

			//Date format checker (strict)

			String date = "01 Jan 2026"; //as in timeanddate.com

			regex = "^(0?[1-9]|[12]\\d|3[01])\\s" +
					"(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\s\\d{4}$";

			System.out.println("Does " + date + " match dd mmm yyyy format ? " + date.matches(regex)); // true


			//Validation of time hh:mm:ss as in timeanddate.com
			String time = "24:45:59";

			regex = "^([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$";

			if (time.matches(regex)) {
				System.out.println("Time " + time + " matches time format "+ regex);
			} else {
				System.out.println("Invalid time format");

			}
			//12 hours 
			time = "12:59:59 PM";

			regex = "^(0[1-9]|1[0-2]):[0-5]\\d:[0-5]\\d\\s?(AM|PM)$";

			if (time.matches(regex)) {
				System.out.println("Valid 12-hour time");
			} else {
				System.out.println("Invalid time");
			}


		

	}
	catch(IllegalStateException e)
	{
		System.out.println("Pattern not matched");
	}
}

}
