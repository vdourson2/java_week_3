package java_week_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//This class parse a command line into 3 parts : 
//- a string with the command itself, 
//- an array with the arguments of the command if there are some, 
//- a map of the options if there are some
public class ParseInput {
	private String command;
	private List<String> arguments = new ArrayList<>();
	private Map<String, String> options = new HashMap<>();
		{
			options.put("country", "All");
			options.put("commodity", "All");
			options.put("transport_mode", "All");
			options.put("measure", "All");
		}
	
	public ParseInput(String commandLine) throws IllegalArgumentException {
		
		if (!commandLine.isEmpty()) {
		
			String[] splitCommand = commandLine.split(" ");
			
			//Encode command
			this.command = splitCommand[0];
			
			//Encode arguments
			//Variable marker is used to know the end of arguments in splitCommand
			int marker = 0;
			if (splitCommand.length > 1) {
				for (int i = 1; i < splitCommand.length; i++) {
					if (!splitCommand[i].contains("-")) {
						this.arguments.add(splitCommand[i]);
						marker = i;
					}
					else {
						break;
					}
				}
			}	
			
			//Encode options
			//Variable marker is used to know the index of splitCommand we already finished to treat  
			//To start looking for a pair <--option> <value>, we have to start from (marker + 1) 
			if ((splitCommand.length - (marker + 1)) % 2 == 0) { //Even number of left values, as pairs of option-value
				while (splitCommand.length - 1 > marker) {
					//Si l'option est bien une option existante
					String option = splitCommand[marker + 1].replace("--", "");
					String value = splitCommand[marker + 2];
					if (options.containsKey(option) && !value.contains("-")) {
						this.options.put(option, value);
						marker += 2;
					}
					else {
						throw new IllegalArgumentException("One or more options are not existing, or one value is missing");
					}
				}
			}
			else {
				throw new IllegalArgumentException("The options are not a pair number.");
			}
		}
		else {
			throw new IllegalArgumentException("The commandLine is empty");
		}
		
		
	}//End constructor ParseCommand
	
	public String getCommand() {
		return this.command;
	}
	
	public List<String> getArguments(){
		return Collections.unmodifiableList(this.arguments );
	}
	
	public Map<String,String> getOptions(){
		return Collections.unmodifiableMap(this.options);
	}
	
	public String toString() {
		return "Command = " + this.command + ", " +
				"arguments = " + this.arguments + ", " +
				"options = " + this.options;
	}

}//End class ParseCommand
