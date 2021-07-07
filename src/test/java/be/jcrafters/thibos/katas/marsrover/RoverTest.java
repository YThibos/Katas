package be.jcrafters.thibos.katas.marsrover;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RoverTest {

	@Test
	void whenNewRover_rotateRight_shouldReturnCorrectOrientation() {
		Rover rover = new Rover();

		String result = rover.executeCommands("r");

		assertThat(result).isEqualTo("0:0:E");
	}

	@Test
	void whenNewRover_rotateRightTwice_shouldDoOneEightyDegreesTurn() {
		Rover rover = new Rover();

		String result = rover.executeCommands("rr");

		assertThat(result).isEqualTo("0:0:S");
	}

	@Test
	void whenNewRover_rotateLeft_shouldReturnCorrectOrientation() {
		Rover rover = new Rover();

		String result = rover.executeCommands("l");

		assertThat(result).isEqualTo("0:0:W");
	}

	@Test
	void whenNewRover_getsNoCommands_shouldReturnCorrectOrientation() {
		Rover rover = new Rover();

		String result = rover.executeCommands("");

		assertThat(result).isEqualTo("0:0:N");
	}

	@Test
	void whenNewRover_getNullCommandString_shouldDoNothing() {
		Rover rover = new Rover();

		String result = rover.executeCommands(null);

		assertThat(result).isEqualTo("0:0:N");
	}
}
