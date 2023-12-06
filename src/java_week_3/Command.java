package java_week_3;

import java.util.ArrayList;
import java.util.List;

public class Command {
	private String command;
	private List<String> arguments = new ArrayList<>();
	private String helpCommand;
	private String country = "All", commodity = "All", transport_mode = "All", measure = "All";
	
	public Command(String commandLine) {
		String[] splitCommand = commandLine.split(" ");
		this.command = splitCommand[0];
		
		//Encode arguments
		if (splitCommand.length > 1) {
			for (int i = 1; i <= splitCommand.length; i++) {
				if (!splitCommand[i].contains("-")) {
					this.arguments.add(splitCommand[i]);
					
				}
			}
		}
		
		//Encode options
	}

}
