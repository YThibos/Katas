package be.jcrafters.thibos.katas.marsrover;

public class Rover {

	private String position = "0:0:N";

	public String executeCommands(String commands) {

		if (commands.isBlank()) {
			return position;
		}

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
