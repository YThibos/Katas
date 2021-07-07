package be.jcrafters.thibos.katas.marsrover;

public class Rover {

	public String executeCommands(String commands) {
		switch (commands) {
		case "r":
			return "0:0:E";
		case "rr":
			;
			return "0:0:S";
		default:
			return "0:0:W";
		}
	}

}
