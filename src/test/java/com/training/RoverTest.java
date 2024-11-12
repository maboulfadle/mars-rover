package com.training;

import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Set;

import static com.training.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

/**
 * The {@link RoverTest} class contains the unit tests for the {@link Rover} class.
 *
 * @author mohammed aboulfadle
 * @since 11.2024
 */
@RunWith(MockitoJUnitRunner.class)
public class RoverTest {

    private Rover rover;
    private Surface surface;

    @Before
    public void setUp() {
        final Position initialPosition = new Position(0, 0);
        final Set<Position> obstacles = Sets.newHashSet();

        surface = new Surface(5, 5, obstacles);
        rover = new Rover(surface, initialPosition, NORTH);
    }

    @Test
    public void testMoveForward() {
        // when
        rover.executeCommands("f");

        // then
        assertThat(rover.getPosition().toString()).isEqualTo("(0, 1)");
    }

    @Test
    public void testMoveBackward() {
        // when
        rover.executeCommands("b");

        // then
        assertThat(rover.getPosition().toString()).isEqualTo("(0, 4)");
    }

    @Test
    public void testTurnLeft() {
        // when
        rover.executeCommands("l");

        // then
        assertThat(rover.getDirection()).isEqualTo(WEST);
    }

    @Test
    public void testTurnRight() {
        // when
        rover.executeCommands("r");

        // then
        assertThat(rover.getDirection()).isEqualTo(EAST);
    }

    @Test
    public void testExecuteCommands() {
        // when
        rover.executeCommands("ffrff");

        // then
        assertThat(rover.getPosition().toString()).isEqualTo("(2, 2)");
        assertThat(rover.getDirection()).isEqualTo(EAST);
    }

    @Test
    public void testWrappingTopEdge() {
        // when
        rover.executeCommands("fffff");

        // then
        assertThat(rover.getPosition().toString()).isEqualTo("(0, 0)");
    }

    @Test
    public void testWrappingBottomEdge() {
        // when
        rover.executeCommands("b");

        // then
        assertThat(rover.getPosition().toString()).isEqualTo("(0, 4)");
    }

    @Test
    public void testWrappingRightEdge() {
        // when
        rover.executeCommands("rfffff");

        // then
        assertThat(rover.getPosition().toString()).isEqualTo("(0, 0)");
    }

    @Test
    public void testWrappingLeftEdge() {
        // when
        rover.executeCommands("lf");

        // then
        assertThat(rover.getPosition().toString()).isEqualTo("(4, 0)");
    }

    @Test
    public void testObstacleDetection() {
        // given
        final Position obstacle = new Position(0, 2);

        surface.defineObstacle(obstacle);

        // when
        final String actual = rover.executeCommands("ff");

        // then
        assertThat(actual).isEqualTo("Obstacle found at the NORTH of (0, 1)");
        assertThat(rover.getPosition().toString()).isEqualTo("(0, 1)");
    }

    @Test
    public void testInvalidCommand() {
        // when
        final IllegalArgumentException actual = assertThrows(IllegalArgumentException.class, () -> rover.executeCommands("x"));

        // then
        assertThat("Invalid command x").isEqualTo(actual.getMessage());
    }
}