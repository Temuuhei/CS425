import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MortgageCalculator {

	public boolean isAdult(int age){
		if (age > 18) {
			return true;
		} else {
			return false;
		}
	} 

	public String computeIncome(double income) {
		String result = "";
		if (income >= 2000 && income < 3000) {
			result = "medium";
		} else if (income >= 3000 && income < 5000) {
			result = "high";
		} else if (income >= 5000) {
			result = "great";
		}
		return result;
	}

	public double computeMaxMortgage(int yearOfBirt, int month, int day, double monthlyIncome, boolean married, double monthlyIncomePartner, String profession) {
		double result=0;
		//calculate age
		LocalDate today = LocalDate.now();                          //Today's date
		LocalDate birthday = LocalDate.of(yearOfBirt, month, day);  //Birth date
		 
		Period p = Period.between(birthday, today);
		int age = p.getYears();
		System.out.println(age);
		List<String> medium = new ArrayList<String>(Arrays.asList("Developer", "Architect","Scrum master"));
		List<String> high = new ArrayList<String>(Arrays.asList("Tester", "System Administrator","Technical writer"));
		List<String> great = new ArrayList<String>(Arrays.asList("Department head", "Professor"));

		if (! married) {
			if (isAdult(age) && computeIncome(monthlyIncome) == "medium") {
				if (medium.contains(profession)) result = 160000;
				if (high.contains(profession)) result = 120000;
				if (great.contains(profession)) result = 220000;
			}
			if (isAdult(age) && computeIncome(monthlyIncome) == "high") {
				if (medium.contains(profession)) result = 180000;
				if (high.contains(profession)) result = 140000;
				if ( great.contains(profession)) result = 250000;
			}
			if (isAdult(age) && computeIncome(monthlyIncome) == "great") {
				if (medium.contains(profession)) result = 220000;
				if (high.contains(profession)) result = 160000;
				if (great.contains(profession)) result = 280000;
			}
			if (!isAdult(age)) {
				result = 0;
			}
		}
		else {
			double totalIncome = monthlyIncome + monthlyIncomePartner * 0.94; 
			if (isAdult(age) && computeIncome(totalIncome) == "medium") {
				if (medium.contains(profession)) result = 160000;
				if (high.contains(profession)) result = 120000;
				if (great.contains(profession)) result = 220000;
			}
			if (isAdult(age) && computeIncome(totalIncome) == "high") {
				if (medium.contains(profession)) result = 180000;
				if (high.contains(profession)) result = 140000;
				if ( great.contains(profession)) result = 250000;
			}
			if (isAdult(age) && computeIncome(totalIncome) == "great") {
				if (medium.contains(profession)) result = 220000;
				if (high.contains(profession)) result = 160000;
				if (great.contains(profession)) result = 280000;
			}
			if (!isAdult(age)) {
				result = 0;
			}

		}
		
		return result;
	}

}
