package be.jcrafters.thibos.katas.marsrover;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RoverTest {

	private Rover rover;

	@BeforeEach
	void setUp() {
		rover = new Rover();
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
	void whenNewRover_getsNullCommand_shouldDoNothing() {
		String result = rover.executeCommands(null);

		assertThat(result).isEqualTo("0:0:N");
	}

	@Test
	void whenNewRover_moveForward_shouldReturnCorrectCoordinates() {
		String result = rover.executeCommands("f");

		assertThat(result).isEqualTo("1:0:N");
	}

	@ParameterizedTest
	@CsvSource({"r, 0:0:E",
				"rr, 0:0:S",
				"rrr, 0:0:W",
				"rrrr, 0:0:N",
				"rrrrr, 0:0:E"})
	void whenNewRover_rotateRight_variousNumberOfRotations(String commands, String expectedResult) {
		String actualResult = rover.executeCommands(commands);

		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	void whenNewRover_rotatesRightTwice_shouldReturnCorrectOrientation() {
		rover.executeCommands("r");
		String result = rover.executeCommands("r");

		assertThat(result).isEqualTo("0:0:S");
	}

}
