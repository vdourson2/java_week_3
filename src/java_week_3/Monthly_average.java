package java_week_3;

import java.util.List;
import java.util.stream.Collectors;

public class Monthly_average extends MonthlyCommand {

	public static final String description = "Returns the average of the export of a specified month of a specified year.";

	public Monthly_average(ParseInput parsedInput) throws IllegalArgumentException {
		super(parsedInput);
	}
	
	public void execute(List<TradeData> allValues) {
		long average;
		average = allValues.stream()
					.filter(l -> l.getYear().equals(super.getYear()))
					.filter(l -> l.getMonth().equals(super.getMonth()))
					.filter(l -> l.getCountry().equals(super.getOptions().get("country")))
					.filter(l -> l.getCommodity().equals(super.getOptions().get("commodity")))
					.filter(l -> l.getTransport_mode().equals(super.getOptions().get("transport_mode")))
					.filter(l -> l.getMeasure().equals(super.getOptions().get("measure")))
					.filter(l -> l.getDirection().equals("Exports"))
					.collect(Collectors.averagingLong(TradeData::getLongValue)).longValue();
		
		System.out.println("The average of exports for the month is :");
		System.out.println(average + " " + super.getOptions().get("measure"));
	}
	
	public static String help() {
		return """
				monthly_average \033[3myear month\033[0m [option \033[3mvalue\033[0m]...
				Returns the average of the export for a specified month of a specified year.
				options :
					--country  			"All" by default.
					--commodity			"All" by default.
					--transport_mode	"All" by default.
					--measure			"All" by default.
				ex : monthly_average 2015 5 --country China --commodity Fruit 
				""";
	}
	
}
