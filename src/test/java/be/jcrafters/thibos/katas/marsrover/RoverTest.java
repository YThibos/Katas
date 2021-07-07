package be.jcrafters.thibos.katas.marsrover;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RoverTest {

	@Test
	void givethisanamelater() {
		Rover rover = new Rover();

		String result = rover.executeCommands("r");

		assertThat(result).isEqualTo("0:0:E");
	}
}
