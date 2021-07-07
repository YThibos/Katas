package be.jcrafters.thibos.katas.marsrover;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class Rover {

	private static final String NORTH = "N";
	private static final String WEST = "W";
	private static final String EAST = "E";
	private static final String SOUTH = "S";

	private static class Coordinate {
		private final int x;
		private final int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}

	private Coordinate coordinate = new Coordinate(0, 0);
	private String direction = NORTH;

	public String executeCommands(String commands) {

		if (isNotBlank(commands)) {

			for (char command : commands.toCharArray()) {

				switch (command) {
				case 'l':
					rotateLeft();
					break;

				case 'f':
					moveForward();
					break;

				case 'r':
					rotateRight();
					break;
				}
			}
		}
		return formattedStatus();
	}

	private void moveForward() {
		switch (direction) {
		case NORTH:
			if (coordinate.getY() + 1 > 4) {
				coordinate = new Coordinate(coordinate.getX(), 0);
			} else {
				coordinate = new Coordinate(coordinate.getX(), coordinate.getY() + 1);
			}
			break;

		case EAST:
			if (coordinate.getX() + 1 > 4) {
				coordinate = new Coordinate(0, coordinate.getY());
			} else {
				coordinate = new Coordinate(coordinate.getX() + 1, coordinate.getY());
			}
			break;

		case SOUTH:
			if (coordinate.getY() - 1 < 0) {
				coordinate = new Coordinate(coordinate.getX(), 4);
			} else {
				coordinate = new Coordinate(coordinate.getX(), coordinate.getY() - 1);
			}
			break;

		case WEST:
			if (coordinate.getX() - 1 < 0) {
				coordinate = new Coordinate(4, coordinate.getY());
			} else {
				coordinate = new Coordinate(coordinate.getX() - 1, coordinate.getY());
			}
			break;
		}

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

	private String formattedStatus() {
		return coordinate.getX() + ":" + coordinate.getY() + ":" + direction;
	}
}
