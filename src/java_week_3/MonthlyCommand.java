package java_week_3;

import java.util.List;
import java.util.Map;

public class MonthlyCommand extends Command {
	private List<String> arguments;
	private Map<String, String> options;
	private String description;
	
	public MonthlyCommand(ParseInput parsedInput) {
		super(parsedInput.getCommand(),description);
	}
}
