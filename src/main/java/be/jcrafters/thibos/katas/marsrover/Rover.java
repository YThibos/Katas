package be.jcrafters.thibos.katas.marsrover;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class Rover {

	private static final String NORTH = "N";
	private static final String WEST = "W";
	private static final String EAST = "E";
	private static final String SOUTH = "S";
	private String position = "0:0";
	private String direction = NORTH;

	public String executeCommands(String commands) {

		if (isNotBlank(commands)) {

			switch (commands) {
			case "l":
				if (direction.equals(NORTH)) {
					direction = WEST;
				}
				break;

			case "f":
				position = "1:0";
				break;

			case "r":
				if (NORTH.equals(direction)) {
					direction = EAST;
				} else if (EAST.equals(direction)) {
					direction = SOUTH;
				}
				break;

			case "rr":
				direction = SOUTH;
				break;

			case "rrr":
				direction = WEST;
				break;
			}
		}

		return position + ":" + direction;
	}

}
