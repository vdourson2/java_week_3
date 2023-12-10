package java_week_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cli {
	
	List<TradeData> allValues = new ArrayList<TradeData>();
	
	//This constructor initiate the Cli with the data contained into the csv file pathToDataFile
	public Cli(String pathToDataFile) {
		try (InputStream inputFS = new FileInputStream(new File(pathToDataFile));
		    	BufferedReader br = new BufferedReader(new InputStreamReader(inputFS))) {
		    	
			//Skip the header of the csv
			//Convert each line into an object of TradeData class
			this.allValues = br.lines()
		    		  .skip(1)
		    		  .map(line -> line.split(",(?!\\s)"))
		    		  .map((ar) -> {
		    			  TradeData trLine = new TradeData(ar);
		    			  return trLine;
		    		  })
		    		  .collect(Collectors.toList());
		 } 	
		 catch (IOException e) {
			 System.out.println("Loading failed" + e);
		 }
	}//End constructor Cli
	
	public void treatInput(String inputLine) {
		ParseInput parsedInput =  new ParseInput(inputLine);
		System.out.println(parsedInput);
		
		switch (parsedInput.getCommand()) {
			case "monthly_total" :
				Command command = new MonthlyCommand(parsedInput); 
				//ajouter description ici???
				break;
			case "exit" :
				return;
			default :
				System.out.printf("""
								  The << %s >> command was not found.
								  Enter << help >> to have more informations about the available commands.""", parsedInput.getCommand());
		}
		
	}
	
	
	
}//End Class Cli
