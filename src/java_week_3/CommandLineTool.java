package java_week_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CommandLineTool {

	public static void main(String[] args) {
		System.out.println("Test0");
		//Scanner commandLine = new Scanner(System.in);
		//String command = commandLine.nextLine(); 
		System.out.println("Test1");
		List<TradeData> allValues = processInputFile("assets/covid_and_trade.csv");
		Long monthly_total = monthly_total(1, 2019, allValues);
		System.out.println(monthly_total);
	}
	
	public static List<TradeData> processInputFile(String inputFilePath) {
		
		List<TradeData> allValues = new ArrayList<TradeData>();		
	    
		try (InputStream inputFS = new FileInputStream(new File(inputFilePath));
	    	BufferedReader br = new BufferedReader(new InputStreamReader(inputFS))) {
	    	
	    	//Skip the header of the csv
	    	//Convert each line into an object of TradeData class
	    	allValues = br.lines()
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
	    
	    return allValues;
	}
	
	public static Long monthly_total(Integer month, Integer year, List<TradeData> allValues) {
		Long monthly_total = allValues.stream()
							.filter(l -> l.getYear().equals(Integer.toString(year)) && (l.getDirection().equals("Exports") || l.getDirection().equals("Imports")) && l.getMonth() == month.intValue())
							.peek(System.out::println)
							.map(l -> Long.parseLong(l.getValue()))
							.reduce(0l, Long::sum);
		return monthly_total;
	}
}


