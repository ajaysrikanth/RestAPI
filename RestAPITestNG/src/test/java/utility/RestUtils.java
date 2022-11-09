package utility;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String empName() {
		
		String empName = "John"+RandomStringUtils.randomAlphabetic(2);
		
		return empName;
	}
	
	public static double empSalary() {
		double salary = Integer.parseInt(RandomStringUtils.randomNumeric(6));
		
		return salary;
	}
	
	public static int empAge() {
		int age = Integer.parseInt(RandomStringUtils.randomNumeric(2));
		
		return age;
	}

}
