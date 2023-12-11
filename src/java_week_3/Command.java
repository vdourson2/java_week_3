package java_week_3;

import java.util.List;

abstract public class Command {
	private String name;
	
	public Command(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	abstract public void execute(List<TradeData> allValues);
	
	
	
}
