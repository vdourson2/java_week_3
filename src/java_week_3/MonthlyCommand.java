package java_week_3;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract public class MonthlyCommand extends Command {
	private String month, year;
	private Map<String, String> options;
	//private String country, commodity, transport_mode, measure;
	
	//constructor
	public MonthlyCommand(ParseInput parsedInput) throws IllegalArgumentException {
		super(parsedInput.getCommand());
		
		//Fields month and year
		List<String> arguments = parsedInput.getArguments();
		if (validArguments(arguments)) {
			this.year = arguments.get(0);
			this.month = arguments.get(1);
		}
		
		//Fields country, commodity, transport_mode, measure
		this.options = parsedInput.getOptions();
			
	}//End constructor
	
	abstract public void execute(List<TradeData> allValues);
	
	private boolean validArguments(List<String> arguments) throws IllegalArgumentException, NumberFormatException {
		if (arguments.size() == 2) {
			int year = Integer.parseInt(arguments.get(0));
			int month = Integer.parseInt(arguments.get(1));
			if (month >0 && month < 13 && year > 2000 && year < 2023) {
				return true;
			}
			else {
				throw new IllegalArgumentException("year and/or month are invalid");
			}
		}
		else {
			throw new IllegalArgumentException("2 arguments are needed");
		}
	}
	
	public String getYear() {
		return this.year;
	}
	
	public String getMonth() {
		return this.month;
	}
	
	public Map<String, String> getOptions(){
		return Collections.unmodifiableMap(this.options);
	}
		
	
	
}
