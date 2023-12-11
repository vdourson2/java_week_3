package java_week_3;

import java.time.LocalDate;

public class Date {
	private  String year, month, day;
	
	public Date(String date) {
		String[] arrayDate = date.split("/");
		this.year = arrayDate[2];
		this.month = arrayDate[1].replaceFirst("^0+(?!$)", "");
		this.day = arrayDate[0].replaceFirst("^0+(?!$)", "");
	}
	
	public String getMonth() {
		return this.month;
	}
	
	public LocalDate createLocalDate() {
		return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
	}
}
