package java_week_3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonthlyCommand extends Command {
	private String month, year;
	private String country, commodity, transport_mode, measure;
	
	//constructor
	public MonthlyCommand(ParseInput parsedInput) throws NumberFormatException, IllegalArgumentException {
		super(parsedInput.getCommand());
		
		//Fields month and year
		List<String> arguments = parsedInput.getArguments();
		if (arguments.size() == 2) {
			int month = Integer.parseInt(arguments.get(0));
			int year = Integer.parseInt(arguments.get(1));
			if (month >0 && month < 13 && year > 2000 && year < 2023) {
				this.month = Integer.toString(month);
				this.year = Integer.toString(year);
			}
			else {
				throw new IllegalArgumentException("year and/or month are invalid");
			}
		} 
		else {
			throw new IllegalArgumentException("2 arguments are needed");
		}
		
		//Fields country, commodity, transport_mode, measure
		Map<String, String> options = parsedInput.getOptions();
		
		
	}
}
