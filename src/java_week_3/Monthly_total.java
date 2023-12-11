package java_week_3;

import java.util.List;
import java.util.stream.Collectors;

public class Monthly_total extends MonthlyCommand {
	
	public static final String description = "Returns the sum of the export for a specified month of a specified year.";

	public Monthly_total(ParseInput parsedInput) throws IllegalArgumentException {
		super(parsedInput);
	}
	
	public void execute(List<TradeData> allValues) {
		Long sum;
		sum = allValues.stream()
					.filter(l -> l.getYear().equals(super.getYear()))
					.filter(l -> l.getMonth().equals(super.getMonth()))
					.filter(l -> l.getCountry().equals(super.getOptions().get("country")))
					.filter(l -> l.getCommodity().equals(super.getOptions().get("commodity")))
					.filter(l -> l.getTransport_mode().equals(super.getOptions().get("transport_mode")))
					.filter(l -> l.getMeasure().equals(super.getOptions().get("measure")))
					.filter(l -> l.getDirection().equals("Exports"))
					.collect(Collectors.summingLong(TradeData::getLongValue));
		
		System.out.println("The sum of exports for the month is :");
		System.out.println(sum + " " + super.getOptions().get("measure"));
	}
	
	public static final String help() {
		return """
				monthly_total \033[3myear month\033[0m [option \033[3mvalue\033[0m]...
				Returns the sum of the export for a specified month of a specified year.
				options :
					--country  			"All" by default.
					--commodity			"All" by default.
					--transport_mode	"All" by default.
					--measure			"All" by default.
				ex : monthly_total 2015 5 --country China --commodity Fruit 
				""";
	}
	
	
}
