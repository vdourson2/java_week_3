package java_week_3;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand extends Command {
	
	//This field contains the command for witch help is wanted,
	//or null if help is wanted for all commands.
	private String command = null;
	//This field contains a list of all the available commands
	public static final List<String> listCommand = new ArrayList<>(
			List.of("monthly_total",
                    "monthly_average",
                    "help"));
	//Constructor
	public HelpCommand(ParseInput parsedInput) throws IllegalArgumentException {
		super(parsedInput.getCommand());
		
		List<String> arguments = parsedInput.getArguments();
		if (validArguments(arguments) && arguments.size() == 1) {
			this.command = arguments.get(0);
		}
	}
	public void execute(List<TradeData> allValues) {
		if (this.command == null || this.command.equals("monthly_total")) {
			System.out.println(Monthly_total.help());
		}
		if (this.command == null || this.command.equals("monthly_average")) {
			System.out.println(Monthly_average.help());
		}
		if (this.command == null || this.command.equals("help"))
			System.out.println(HelpCommand.help());
	}
	
	private boolean validArguments(List<String> arguments) throws IllegalArgumentException {
		if (arguments.size() == 0 || (arguments.size() == 1 && listCommand.contains(arguments.get(0)))) {
			return true;
		}
		else {
			throw new IllegalArgumentException("The arguments are not suited for the help command");
		}
	}
	
	public static final String help() {
		return """
				help \033[3mcommand\033[0m 
				Returns informations about the specified command
				ex : help monthly_average 
				""";
	}

}
