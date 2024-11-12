package com.training;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static com.training.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * The {@link PositionTest} class contains the unit tests for the {@link Position} class.
 *
 * @author mohammed aboulfadle
 * @since 11.2024
 */
@RunWith(MockitoJUnitRunner.class)
public class PositionTest {

    private static final int X = RandomUtils.nextInt();
    private static final int Y = RandomUtils.nextInt();

    private Position position;

    @Before
    public void setUp() {
        position = new Position(X, Y);
    }

    @Test
    public void testGetForwardPosition_NORTH() {
        // when
        final Position expected = position.forward(NORTH);

        // then
        assertThat(expected.x()).isEqualTo(position.x());
        assertThat(expected.y()).isEqualTo(position.y() + 1);
    }

    @Test
    public void testGetForwardPosition_EAST() {
        // when
        final Position expected = position.forward(EAST);

        // then
        assertThat(expected.x()).isEqualTo(position.x() + 1);
        assertThat(expected.y()).isEqualTo(position.y());
    }

    @Test
    public void testGetBackwardPosition_NORTH() {
        // when
        final Position expected = position.behind(NORTH);

        // then
        assertThat(expected.x()).isEqualTo(position.x());
        assertThat(expected.y()).isEqualTo(position.y() - 1);
    }

    @Test
    public void testGetBackwardPosition_EAST() {
        // when
        final Position expected = position.behind(EAST);

        // then
        assertThat(expected.x()).isEqualTo(position.x() - 1);
        assertThat(expected.y()).isEqualTo(position.y());
    }
}