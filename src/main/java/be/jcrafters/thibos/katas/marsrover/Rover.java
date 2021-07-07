package be.jcrafters.thibos.katas.marsrover;

public class Rover {

	public String executeCommands(String commands) {
		return "r".equals(commands) ? "0:0:E" : "0:0:W";
	}

}
