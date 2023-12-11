package java_week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLineTool {

	public static void main(String[] args) {
		
		Cli cli = new Cli("assets/covid_and_trade.csv");
		
		try (InputStreamReader isr = new InputStreamReader(System.in);
		    	BufferedReader br = new BufferedReader(isr)) {
			while (!cli.getExit().equals("exit")) {
				System.out.println("Data analysis command line >");
				String inputLine = br.readLine();
				cli.treatInput(inputLine);
			}
			
			
		 } 	
		 catch (IOException e) {
			 System.out.println("Failed to read stdin : " + e);
		 }
		
	}
	
}


