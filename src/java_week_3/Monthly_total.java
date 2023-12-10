package java_week_3;

public class Monthly_total extends MonthlyCommand {
	static final String description = "Returns the sum of both the export and import for a specified month of a specified year.";

	public Monthly_total(ParseInput parsedInput) {
		super(parsedInput);
	}
	
	
	
	public static String help() {
		return """
				monthly_total \033[3myear month\033[0m [option \033[3mvalue\033[0m]...
				Returns the sum of both the export and import for a specified month of a specified year.
				options :
					--country  			"All" by default.
					--commodity			"All" by default.
					--transport_mode	"All" by default.
					--measure			"All" by default.""";
	}
	
	
}
