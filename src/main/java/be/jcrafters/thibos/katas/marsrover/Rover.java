package be.jcrafters.thibos.katas.marsrover;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class Rover {

	private static final String NORTH = "N";
	private static final String WEST = "W";
	private static final String EAST = "E";
	private static final String SOUTH = "S";
	private int x = 0;
	private int y = 0;

	private String direction = NORTH;

	public String executeCommands(String commands) {

		if (isNotBlank(commands)) {

			for (char command : commands.toCharArray()) {

				switch (command) {
				case 'l':
					rotateLeft();
					break;

				case 'f':
					x = ++x;
					break;

				case 'r':
					rotateRight();
					break;
				}
			}
		}
		return formattedStatus();
	}

	private String formattedStatus() {
		return x + ":" + y + ":" + direction;
	}

	private void rotateLeft() {
		if (NORTH.equals(direction)) {
			direction = WEST;
		} else if (WEST.equals(direction)) {
			direction = SOUTH;
		} else if (SOUTH.equals(direction)) {
			direction = EAST;
		} else if (EAST.equals(direction)) {
			direction = NORTH;
		}
	}

	private void rotateRight() {
		if (NORTH.equals(direction)) {
			direction = EAST;
		} else if (EAST.equals(direction)) {
			direction = SOUTH;
		} else if (SOUTH.equals(direction)) {
			direction = WEST;
		} else if (WEST.equals(direction)) {
			direction = NORTH;
		}
	}
}
