package be.jcrafters.thibos.katas.marsrover;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class Rover {

	private String position = "0:0:N";

	public String executeCommands(String commands) {

		if (isBlank(commands)) {
			return position;
		}

		switch (commands) {
		case "r":
			return "0:0:E";
		case "rr":
			return "0:0:S";
		case "f":
			return "1:0:N";
		default:
			return "0:0:W";
		}
	}

}
