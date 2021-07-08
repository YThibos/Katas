package be.jcrafters.thibos.katas.marsrover;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class Rover {

	private static final String NORTH = "N";
	private static final String WEST = "W";
	private static final String EAST = "E";
	private static final String SOUTH = "S";

	private static final Coordinate boulder = new Coordinate(1, 2);

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
					doMoveIfPossible();
					break;

				case 'r':
					rotateRight();
					break;
				}
			}
		}
		return formattedStatus();
	}

	private void doMoveIfPossible() {
		if (isMovePossible()) {
			doMove();
		}
	}

	private boolean isMovePossible() {
		Coordinate target;
		switch (direction) {
		case NORTH:
			target = nextNorthernCoordinate();
			break;

		case EAST:
			target = nextEasternCoordinate();
			break;

		case SOUTH:
			target = nextSouthernCoordinate();
			break;

		case WEST:
			target = nextWesternCoordinate();
			break;

		default:
			target = null;
		}

		return !target.equals(boulder);
	}

	private void doMove() {
		Coordinate target;
		switch (direction) {
		case NORTH:
			target = nextNorthernCoordinate();
			break;

		case EAST:
			target = nextEasternCoordinate();
			break;

		case SOUTH:
			target = nextSouthernCoordinate();
			break;

		case WEST:
			target = nextWesternCoordinate();
			break;

		default:
			target = null;
		}
		coordinate = target;
	}

	private Coordinate nextNorthernCoordinate() {
		Coordinate target;
		if (coordinate.getY() + 1 > 4) {
			target = new Coordinate(coordinate.getX(), 0);
		} else {
			target = new Coordinate(coordinate.getX(), coordinate.getY() + 1);
		}
		return target;
	}

	private Coordinate nextWesternCoordinate() {
		Coordinate target;
		if (coordinate.getX() - 1 < 0) {
			target = new Coordinate(4, coordinate.getY());
		} else {
			target = new Coordinate(coordinate.getX() - 1, coordinate.getY());
		}
		return target;
	}

	private Coordinate nextSouthernCoordinate() {
		Coordinate target;
		if (coordinate.getY() - 1 < 0) {
			target = new Coordinate(coordinate.getX(), 4);
		} else {
			target = new Coordinate(coordinate.getX(), coordinate.getY() - 1);
		}
		return target;
	}

	private Coordinate nextEasternCoordinate() {
		Coordinate target;
		if (coordinate.getX() + 1 > 4) {
			target = new Coordinate(0, coordinate.getY());
		} else {
			target = new Coordinate(coordinate.getX() + 1, coordinate.getY());
		}
		return target;
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
