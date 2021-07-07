package be.jcrafters.thibos.katas.marsrover;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoverTest {

	private Rover rover;

	@BeforeEach
	void setUp() {
		rover = new Rover();
	}

	@Test
	void whenNewRover_rotateRight_shouldReturnCorrectOrientation() {
		String result = rover.executeCommands("r");

		assertThat(result).isEqualTo("0:0:E");
	}

	@Test
	void whenNewRover_rotateRightTwice_shouldDoOneEightyDegreesTurn() {
		String result = rover.executeCommands("rr");

		assertThat(result).isEqualTo("0:0:S");
	}

	@Test
	void whenNewRover_rotateLeft_shouldReturnCorrectOrientation() {
		String result = rover.executeCommands("l");

		assertThat(result).isEqualTo("0:0:W");
	}

	@Test
	void whenNewRover_getsNoCommands_shouldReturnCorrectOrientation() {
		String result = rover.executeCommands("");

		assertThat(result).isEqualTo("0:0:N");
	}

	@Test
	void whenNewRover_getNullCommandString_shouldDoNothing() {
		String result = rover.executeCommands(null);

		assertThat(result).isEqualTo("0:0:N");
	}

	@Test
	void whenNewRover_moveForward_shouldReturnCorrectCoordinates() {
		String result = rover.executeCommands("f");

		assertThat(result).isEqualTo("1:0:N");
	}
}
